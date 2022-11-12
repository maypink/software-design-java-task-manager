package software.design.model;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

public class Task {

    private UUID id;

    @NotBlank
    private String name;

    private String description;

    private Date dateCreated;

    private TaskStatus status;

    private Project project;
}
