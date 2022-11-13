package software.design.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import software.design.entity.StudentEntity;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<StudentEntity, UUID> {
}
