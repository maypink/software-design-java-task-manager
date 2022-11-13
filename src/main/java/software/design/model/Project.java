package software.design.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RequiredArgsConstructor
public record Project(
    UUID id,

    @NotBlank
    String name,

    String description,

    Date dateCreated,

    User user,

    @NotNull
    List<Task> tasks
)
{}
