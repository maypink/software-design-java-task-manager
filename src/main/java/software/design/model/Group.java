package software.design.model;

import javax.validation.constraints.NotBlank;
import java.util.List;

public record Group(
        @NotBlank
        String name,
        List<Student> students
) {
}
