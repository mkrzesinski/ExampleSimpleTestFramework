package api.models;

import lombok.*;

@AllArgsConstructor
@Data
public class GitHubIssue {
    private String title;
    private String body;
    private String state;
}
