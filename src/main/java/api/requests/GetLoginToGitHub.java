package api.requests;

import static io.restassured.RestAssured.given;

import api.client.ExecutableRequest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

/**
 * CloneRepository is a class that provides a method to clone a GitHub repository. It uses a
 * RequestSpecBuilder to build the request specifications for the API call.
 */
public class GetLoginToGitHub implements ExecutableRequest {
  private final RequestSpecBuilder requestSpecBuilder;

  /**
   * Constructor for CloneRepository.
   *
   * @param requestSpecBuilder - A RequestSpecBuilder instance used to build the request.
   * @param token - The token used for authentication.
   */
  public GetLoginToGitHub(RequestSpecBuilder requestSpecBuilder, String token) {
    this.requestSpecBuilder = requestSpecBuilder;
    this.requestSpecBuilder.addHeader("Content-Type", "application/json");
    this.requestSpecBuilder.addHeader("Authorization", "token " + token);
  }

  @Override
  public Response execute() {
    return given().spec(requestSpecBuilder.build()).when().get("user");
  }
}
