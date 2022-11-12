package software.design.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Task {

    private UUID id;

    @NotBlank
    private String name;

    private String description;

    final private Date dateCreated;

    private TaskStatus status;

    private Project project;
}
