package software.design.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import software.design.entity.GroupEntity;
import software.design.entity.ProjectEntity;
import software.design.entity.StudentEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<StudentEntity, UUID> {
}
