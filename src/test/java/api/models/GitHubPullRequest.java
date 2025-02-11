package api.models;

import lombok.*;

@AllArgsConstructor
@Data
public class GitHubPullRequest {
    private String title;
    private String head;
    private String base;
    private String description;
}
