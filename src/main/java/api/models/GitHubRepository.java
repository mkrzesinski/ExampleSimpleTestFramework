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
public class GitHubRepository {
  private String name;
  private String description;
  private boolean isPrivate;
  private boolean autoInit;
}
