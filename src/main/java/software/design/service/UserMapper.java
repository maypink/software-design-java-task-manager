package software.design.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import software.design.entity.UserEntity;
import software.design.model.User;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ProjectMapper projectMapper;

    public UserEntity modelToEntity(User model){
        return new UserEntity(
                model.getId(),
                model.getUsername(),
                model.getCreated(),
                model.getProjects().stream().map(projectMapper::modelToEntity).toList());
    }

    public User entityToModel(UserEntity entity){
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getDateCreated(),
                entity.getProjects().stream().map(projectMapper::entityToModel).toList());
    }
}
