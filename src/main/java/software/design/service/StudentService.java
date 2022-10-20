package software.design.service;

import software.design.entity.StudentEntity;
import software.design.model.Student;
import software.design.repository.StudentRepository;
import software.design.util.OffsetBasedPageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentMapper mapper;
    private final StudentRepository repository;

    @Transactional
    public Student createStudent(Student student) {
        StudentEntity entity;
        try {
            entity = mapper.modelToEntity(student);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return mapper.entityToModel(repository.save(entity));
    }

    public List<Student> getStudents(int limit, int offset) {
        return repository.findAll(new OffsetBasedPageRequest(offset, limit, Sort.by("surname")))
                .map(mapper::entityToModel)
                .toList();
    }

    public Optional<Student> findStudent(UUID id) {
        return repository.findById(id).map(mapper::entityToModel);
    }

    @Transactional
    public Student expelStudent(UUID id) {
        StudentEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id " + id + " not found"));
        entity.setExpelled(true);
        entity.setGroup(null);
        return mapper.entityToModel(repository.save(entity));
    }


    public void deleteStudent(UUID id) {
        repository.deleteById(id);
    }
}
