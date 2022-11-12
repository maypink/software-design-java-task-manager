package software.design.model;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class User {
    private UUID id;

    @NotBlank
    private String username;

    private Date created;

    private List<Project> projects;
}
