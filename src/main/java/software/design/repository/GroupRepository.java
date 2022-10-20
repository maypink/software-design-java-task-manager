package software.design.repository;

import software.design.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GroupRepository extends JpaRepository<GroupEntity, UUID> {
    Optional<GroupEntity> findByName(String name);

    void deleteByName(String name);
}
