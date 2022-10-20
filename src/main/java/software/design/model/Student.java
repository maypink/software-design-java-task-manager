package software.design.model;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public record Student(
        UUID id,
        @NotBlank
        String name,
        @NotBlank
        String surname,
        String group,
        boolean expelled
) { }
