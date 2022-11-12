package software.design.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import software.design.entity.TaskEntity;
import software.design.model.Task;

@Component
@RequiredArgsConstructor
public class TaskMapper {

    private final ProjectMapper projectMapper;

    private final TaskStatusMapper taskStatusMapper;

    public TaskEntity modelToEntity(Task model){
        return new TaskEntity(
                model.getId(),
                model.getName(),
                model.getDescription(),
                model.getDateCreated(),
                taskStatusMapper.modelToEntity(model.getStatus()),
                projectMapper.modelToEntity(model.getProject()));
    }

    public Task entityToModel(TaskEntity entity){
        return new Task(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getDateCreated(),
                taskStatusMapper.entityToModel(entity.getStatus()),
                projectMapper.entityToModel(entity.getProject()));
    }
}
