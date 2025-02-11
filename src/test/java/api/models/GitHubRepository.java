package api.models;

import lombok.*;

@AllArgsConstructor
@Data
public class GitHubRepository {
    private String name;
    private String description;
    private boolean isPrivate;
    private boolean auto_init;
}
