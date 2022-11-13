package software.design.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private UUID id;

    @NotBlank
    private String username;

    final private Date created;

    private List<Project> projects;
}
