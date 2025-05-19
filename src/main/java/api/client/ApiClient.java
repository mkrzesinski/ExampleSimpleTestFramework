package api.client;

import api.requests.CloneRepository;
import api.requests.DeleteRepository;
import api.requests.GetBranchSha;
import api.requests.GetCheckIfBranchExists;
import api.requests.GetCheckIfRepositoryExists;
import api.requests.GetFileSha;
import api.requests.GetLoginToGitHub;
import api.requests.PatchClosePullRequest;
import api.requests.PatchIssue;
import api.requests.PostCreateNewBranch;
import api.requests.PostNewIssue;
import api.requests.PostNewRepository;
import api.requests.PostPullRequest;
import api.requests.PutMergePullRequest;
import api.requests.PutUpdateFile;
import io.restassured.builder.RequestSpecBuilder;
import java.util.function.Supplier;

/**
 * ApiClient is a class that provides methods to interact with the GitHub API. It uses a
 * RequestSpecBuilder to build the request specifications for each API call.
 */
public class ApiClient {
  private final Supplier<RequestSpecBuilder> requestSpecBuilderSupplier;

  /**
   * Constructor for ApiClient.
   *
   * @param requestSpecBuilderSupplier - A supplier that provides a RequestSpecBuilder instance.
   */
  public ApiClient(Supplier<RequestSpecBuilder> requestSpecBuilderSupplier) {
    this.requestSpecBuilderSupplier = requestSpecBuilderSupplier;
  }

  /**
   * getLoginToGitHub is a method that returns an instance of GetLoginToGitHub.
   *
   * @param token - The token used for authentication.
   * @return GetLoginToGitHub
   */
  public GetLoginToGitHub getLoginToGitHub(String token) {
    return new GetLoginToGitHub(this.requestSpecBuilderSupplier.get(), token);
  }

  /**
   * createNewRepository is a method that returns an instance of PostNewRepository.
   *
   * @param token - The token used for authentication.
   * @param requestBody - The request body for creating a new repository.
   * @return PostNewRepository
   */
  public PostNewRepository createNewRepository(String token, String requestBody) {
    return new PostNewRepository(this.requestSpecBuilderSupplier.get(), token, requestBody);
  }

  /**
   * deleteRepository is a method that returns an instance of DeleteRepository.
   *
   * @param token - The token used for authentication.
   * @param userName - The username of the owner of the repository.
   * @param repositoryName - The name of the repository to be deleted.
   * @return DeleteRepository
   */
  public DeleteRepository deleteRepository(String token, String userName, String repositoryName) {
    return new DeleteRepository(
        this.requestSpecBuilderSupplier.get(), token, userName, repositoryName);
  }

  /**
   * cloneRepository is a method that returns an instance of CloneRepository.
   *
   * @param token - The token used for authentication.
   * @param userName - The username of the owner of the repository.
   * @param repositoryName - The name of the repository to be cloned.
   * @return CloneRepository
   */
  public CloneRepository cloneRepository(String token, String userName, String repositoryName) {
    return new CloneRepository(
        this.requestSpecBuilderSupplier.get(), token, userName, repositoryName);
  }

  /**
   * checkIfRepositoryExists is a method that returns an instance of GetCheckIfRepositoryExists.
   *
   * @param token - The token used for authentication.
   * @param userName - The username of the owner of the repository.
   * @param repositoryName - The name of the repository to be checked.
   * @return GetCheckIfRepositoryExists
   */
  public GetCheckIfRepositoryExists checkIfRepositoryExists(
      String token, String userName, String repositoryName) {
    return new GetCheckIfRepositoryExists(
        this.requestSpecBuilderSupplier.get(), token, userName, repositoryName);
  }

  /**
   * checkIfRepositoryExists is a method that returns an instance of GetCheckIfRepositoryExists.
   *
   * @param token - The token used for authentication.
   * @param userName - The username of the owner of the repository.
   * @param repositoryName - The name of the repository to be checked.
   * @return GetCheckIfRepositoryExists
   */
  public PostNewIssue addNewIssue(
      String token, String requestBody, String userName, String repositoryName) {
    return new PostNewIssue(
        this.requestSpecBuilderSupplier.get(), token, requestBody, userName, repositoryName);
  }

  /**
   * checkIfRepositoryExists is a method that returns an instance of GetCheckIfRepositoryExists.
   *
   * @param token - The token used for authentication.
   * @param userName - The username of the owner of the repository.
   * @param repositoryName - The name of the repository to be checked.
   * @return GetCheckIfRepositoryExists
   */
  public PatchIssue editIssue(
      String token, String requestBody, String userName, String repositoryName, int issueId) {
    return new PatchIssue(
        this.requestSpecBuilderSupplier.get(),
        token,
        requestBody,
        userName,
        repositoryName,
        issueId);
  }

  /**
   * checkIfRepositoryExists is a method that returns an instance of GetCheckIfRepositoryExists.
   *
   * @param token - The token used for authentication.
   * @param userName - The username of the owner of the repository.
   * @param repositoryName - The name of the repository to be checked.
   * @return GetCheckIfRepositoryExists
   */
  public PostPullRequest createNewPullRequest(
      String token, String requestBody, String userName, String repositoryName) {
    return new PostPullRequest(
        this.requestSpecBuilderSupplier.get(), token, requestBody, userName, repositoryName);
  }

  /**
   * checkIfRepositoryExists is a method that returns an instance of GetCheckIfRepositoryExists.
   *
   * @param token - The token used for authentication.
   * @param userName - The username of the owner of the repository.
   * @param repositoryName - The name of the repository to be checked.
   * @return GetCheckIfRepositoryExists
   */
  public PutMergePullRequest mergePullRequest(
      String token, String userName, String repositoryName, int pullRequestId) {
    return new PutMergePullRequest(
        this.requestSpecBuilderSupplier.get(), token, userName, repositoryName, pullRequestId);
  }

  /**
   * checkIfRepositoryExists is a method that returns an instance of GetCheckIfRepositoryExists.
   *
   * @param token - The token used for authentication.
   * @param userName - The username of the owner of the repository.
   * @param repositoryName - The name of the repository to be checked.
   * @return GetCheckIfRepositoryExists
   */
  public PatchClosePullRequest closePullRequest(
      String token, String requestBody, String userName, String repositoryName, int pullRequestId) {
    return new PatchClosePullRequest(
        this.requestSpecBuilderSupplier.get(),
        token,
        requestBody,
        userName,
        repositoryName,
        pullRequestId);
  }

  /**
   * checkIfRepositoryExists is a method that returns an instance of GetCheckIfRepositoryExists.
   *
   * @param token - The token used for authentication.
   * @param userName - The username of the owner of the repository.
   * @param repositoryName - The name of the repository to be checked.
   * @return GetCheckIfRepositoryExists
   */
  public PostCreateNewBranch createNewBranch(
      String token, String requestBody, String userName, String repositoryName) {
    return new PostCreateNewBranch(
        this.requestSpecBuilderSupplier.get(), token, requestBody, userName, repositoryName);
  }

  /**
   * checkIfRepositoryExists is a method that returns an instance of GetCheckIfRepositoryExists.
   *
   * @param token - The token used for authentication.
   * @param userName - The username of the owner of the repository.
   * @param repositoryName - The name of the repository to be checked.
   * @return GetCheckIfRepositoryExists
   */
  public GetCheckIfBranchExists checkIfBranchExists(
      String token, String userName, String repositoryName, String branchName) {
    return new GetCheckIfBranchExists(
        this.requestSpecBuilderSupplier.get(), token, userName, repositoryName, branchName);
  }

  /**
   * checkIfRepositoryExists is a method that returns an instance of GetCheckIfRepositoryExists.
   *
   * @param token - The token used for authentication.
   * @param userName - The username of the owner of the repository.
   * @param repositoryName - The name of the repository to be checked.
   * @return GetCheckIfRepositoryExists
   */
  public GetBranchSha getBaseBranchSha(
      String token, String userName, String repositoryName, String branchName) {
    return new GetBranchSha(
        this.requestSpecBuilderSupplier.get(), token, userName, repositoryName, branchName);
  }

  /**
   * checkIfRepositoryExists is a method that returns an instance of GetCheckIfRepositoryExists.
   *
   * @param token - The token used for authentication.
   * @param userName - The username of the owner of the repository.
   * @param repositoryName - The name of the repository to be checked.
   * @return GetCheckIfRepositoryExists
   */
  public GetFileSha getFileSha(
      String token, String userName, String repositoryName, String filePath) {
    return new GetFileSha(
        this.requestSpecBuilderSupplier.get(), token, userName, repositoryName, filePath);
  }

  /**
   * checkIfRepositoryExists is a method that returns an instance of GetCheckIfRepositoryExists.
   *
   * @param token - The token used for authentication.
   * @param userName - The username of the owner of the repository.
   * @param repositoryName - The name of the repository to be checked.
   * @return GetCheckIfRepositoryExists
   */
  public PutUpdateFile updateFile(
      String token, String requestBody, String userName, String repositoryName, String filePath) {
    return new PutUpdateFile(
        this.requestSpecBuilderSupplier.get(),
        token,
        requestBody,
        userName,
        repositoryName,
        filePath);
  }
}
