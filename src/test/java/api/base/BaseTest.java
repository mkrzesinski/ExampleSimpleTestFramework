package api.base;

import static org.testng.AssertJUnit.assertEquals;

import api.client.ApiClient;
import api.models.GitHubRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.ConfigProvider;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

  protected static final String USER_NAME = System.getenv("USER_NAME");
  protected static final String USER_TOKEN = System.getenv("USER_TOKEN");
  protected static final String INIT_REPOSITORY_NAME = "InitRepository";
  protected static final String REPOSITORY_NAME = "TestRespositoryforMVPchecks";
  protected static final String REPOSITORY_DESCRIPTION = "description";
  protected static final String HEAD_BRANCH = "feature-branch";
  protected static final String BASE_BRANCH = "main";
  protected static final ObjectMapper objectMapper = new ObjectMapper();
  protected ApiClient apiClient;

  protected static String generateRandomPostFix() {
    return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
  }

  @BeforeSuite
  public void setUp() throws JsonProcessingException {
    this.apiClient = createApiClient();
    checkSecrets();
    setUpTestRepository();
  }

  @BeforeClass
  public void setUpClient() {
    this.apiClient = createApiClient();
  }

  protected ApiClient createApiClient() {
    return new ApiClient(
        () ->
            new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .setBaseUri(ConfigProvider.getProperty("baseapiurl")));
  }

  protected void createBranch() throws JsonProcessingException {
    String baseBranchSha =
        this.apiClient
            .getBaseBranchSha(USER_TOKEN, USER_NAME, INIT_REPOSITORY_NAME, BASE_BRANCH)
            .execute()
            .jsonPath()
            .getString("object.sha");

    Map<String, String> requestBody = new HashMap<>();
    requestBody.put("ref", "refs/heads/" + BaseTest.HEAD_BRANCH);
    requestBody.put("sha", baseBranchSha);

    Response response =
        this.apiClient
            .createNewBranch(
                USER_TOKEN,
                objectMapper.writeValueAsString(requestBody),
                USER_NAME,
                BaseTest.INIT_REPOSITORY_NAME)
            .execute();
    assertEquals(HttpStatus.SC_CREATED, response.getStatusCode());
  }

  private void checkSecrets() {
    if (USER_NAME == null) {
      throw new RuntimeException("User name secret is not populated");
    } else if (USER_TOKEN == null) {
      throw new RuntimeException("User token secret is not populated");
    }
  }

  private void setUpTestRepository() throws JsonProcessingException {
    if (this.apiClient
            .checkIfRepositoryExists(USER_TOKEN, USER_NAME, INIT_REPOSITORY_NAME)
            .execute()
            .getStatusCode()
        == HttpStatus.SC_NOT_FOUND) {
      GitHubRepository gitHubRepository =
          new GitHubRepository(INIT_REPOSITORY_NAME, REPOSITORY_DESCRIPTION, true, true);
      String requestBody = objectMapper.writeValueAsString(gitHubRepository);
      this.apiClient.createNewRepository(USER_TOKEN, requestBody).execute();
    }
    if (this.apiClient
            .checkIfBranchExists(USER_TOKEN, USER_NAME, INIT_REPOSITORY_NAME, HEAD_BRANCH)
            .execute()
            .getStatusCode()
        == HttpStatus.SC_NOT_FOUND) {
      createBranch();
    }
  }
}
