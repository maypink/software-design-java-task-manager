package software.design.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import software.design.entity.ProjectEntity;
import software.design.model.Project;

@Component
@RequiredArgsConstructor
public class ProjectMapper {

    private final TaskMapper taskMapper;
    private final UserMapper userMapper;

    public ProjectEntity modelToEntity(Project model) {
        return new ProjectEntity(
                null,
                model.name(),
                model.description(),
                model.dateCreated(),
                userMapper.modelToEntity(model.user()),
                model.tasks().stream().map(taskMapper::modelToEntity).toList()
        );
    }

    public Project entityToModel(ProjectEntity entity) {
        return new Project(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getDateCreated(),
                userMapper.entityToModel(entity.getUser()),
                entity.getTasks().stream().map(taskMapper::entityToModel).toList()
        );
    }
}
