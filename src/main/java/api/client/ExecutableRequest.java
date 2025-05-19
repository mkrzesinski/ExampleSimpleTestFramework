package api.client;

import io.restassured.response.Response;

/**
 * ExecutableRequest is a functional interface that represents a request that can be executed. It
 * contains a single abstract method execute() that returns a Response object.
 */
@FunctionalInterface
public interface ExecutableRequest {

  /**
   * Executes the request and returns the response.
   *
   * @return Response object containing the response from the executed request.
   */
  Response execute();
}
