package api.requests;

import static io.restassured.RestAssured.given;

import api.client.ExecutableRequest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

/**
 * CloneRepository is a class that provides a method to clone a GitHub repository. It uses a
 * RequestSpecBuilder to build the request specifications for the API call.
 */
public class GetFileSha implements ExecutableRequest {
  private final RequestSpecBuilder requestSpecBuilder;

  /**
   * Constructor for CloneRepository.
   *
   * @param requestSpecBuilder - A RequestSpecBuilder instance used to build the request.
   * @param token - The token used for authentication.
   * @param userName - The name of the user who owns the repository.
   * @param repositoryName - The name of the repository to be cloned.
   * @param filePath - The path of the file in the repository.
   */
  public GetFileSha(
      RequestSpecBuilder requestSpecBuilder,
      String token,
      String userName,
      String repositoryName,
      String filePath) {
    this.requestSpecBuilder = requestSpecBuilder;
    this.requestSpecBuilder.addHeader("Content-Type", "application/json");
    this.requestSpecBuilder.addHeader("Authorization", "token " + token);
    this.requestSpecBuilder.addPathParam("userName", userName);
    this.requestSpecBuilder.addPathParam("repositoryName", repositoryName);
    this.requestSpecBuilder.addPathParam("filePath", filePath);
  }

  @Override
  public Response execute() {
    return given()
        .spec(requestSpecBuilder.build())
        .when()
        .get("repos/{userName}/{repositoryName}/contents/{filePath}");
  }
}
