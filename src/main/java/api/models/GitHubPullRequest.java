package api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GitHubIssue is a class that represents a GitHub issue. It contains fields for the title, body,
 * and state of the issue.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GitHubPullRequest {
  private String title;
  private String head;
  private String base;
  private String description;
}
