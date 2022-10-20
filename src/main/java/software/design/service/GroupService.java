package software.design.service;

import software.design.entity.GroupEntity;
import software.design.model.Group;
import software.design.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupMapper mapper;
    private final GroupRepository repository;

    public List<String> getGroups() {
        return repository.findAll().stream()
                .map(GroupEntity::getName)
                .collect(Collectors.toList());
    }

    @Transactional
    public Optional<Group> findGroup(String name) {
        return repository.findByName(name).map(mapper::entityToModel);
    }

    public Group createGroup(Group group) {
        GroupEntity entity = new GroupEntity(null, group.name(), null);
        return mapper.entityToModel(repository.save(entity));
    }

    @Transactional
    public void deleteGroup(String name) {
        repository.deleteByName(name);
    }
}
