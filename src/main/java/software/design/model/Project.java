package software.design.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Project {
    private UUID id;

    @NotBlank
    private String name;

    private String description;

    private Date dateCreated;

    private User user;

    @NotNull
    private List<Task> tasks;
}
