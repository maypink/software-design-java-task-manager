package software.design.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class TaskStatus {
    private UUID id;

    @NotBlank
    private String name;

    private List<Task> tasks;
}
