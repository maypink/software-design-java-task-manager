package software.design.service;

import software.design.entity.GroupEntity;
import software.design.model.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GroupMapper {

    private final StudentMapper studentMapper;

    public GroupEntity modelToEntity(Group model) {
        return new GroupEntity(
                null,
                model.name(),
                model.students().stream().map(studentMapper::modelToEntity).toList()
        );
    }

    public Group entityToModel(GroupEntity entity) {
        return new Group(
                entity.getName(),
                Optional.ofNullable(entity.getStudents())
                        .stream()
                        .flatMap(Collection::stream)
                        .map(studentMapper::entityToModel)
                        .toList()
        );
    }
}
