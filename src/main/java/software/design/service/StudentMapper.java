package software.design.service;

import software.design.entity.GroupEntity;
import software.design.entity.StudentEntity;
import software.design.model.Student;
import software.design.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentMapper {

    private final GroupRepository groupRepository;

    public StudentEntity modelToEntity(Student model) {
        GroupEntity group = Optional.ofNullable(model.group())
                .map(groupName -> groupRepository
                        .findByName(groupName)
                        .orElseThrow(
                                () -> new IllegalArgumentException("Group with name " + model.group() + " not found")
                        )
                ).orElse(null);
        return new StudentEntity(
                model.id(),
                model.name(),
                model.surname(),
                model.expelled(),
                group
        );
    }

    public Student entityToModel(StudentEntity entity) {
        return new Student(
                entity.getId(),
                entity.getName(),
                entity.getSurname(),
                Optional.ofNullable(entity.getGroup())
                        .map(GroupEntity::getName)
                        .orElse(null),
                entity.isExpelled()
        );
    }
}
