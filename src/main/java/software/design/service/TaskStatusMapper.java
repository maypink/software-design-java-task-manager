package software.design.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import software.design.entity.TaskStatusEntity;
import software.design.model.TaskStatus;

@Component
@RequiredArgsConstructor
public class TaskStatusMapper {

    private final TaskMapper taskMapper;

    public TaskStatusEntity modelToEntity(TaskStatus model){
        return new TaskStatusEntity(
                model.getId(),
                model.getName(),
                model.getTasks().stream().map(taskMapper::modelToEntity).toList());
    }

    public TaskStatus entityToModel(TaskStatusEntity entity){
        return new TaskStatus(
                entity.getId(),
                entity.getName(),
                entity.getTasks().stream().map(taskMapper::entityToModel).toList());
    }
}
