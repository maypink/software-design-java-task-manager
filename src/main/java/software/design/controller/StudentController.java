package software.design.controller;

import software.design.model.Student;
import software.design.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping
    public Student createStudent(@RequestBody @Validated Student student) {
        return service.createStudent(student);
    }

    @GetMapping
    public List<Student> getStudents(@RequestParam(value = "limit", required = false, defaultValue = "100") int limit,
                                     @RequestParam(value = "offset", required = false, defaultValue = "0") int offset) {
        return service.getStudents(limit, offset);
    }

    @GetMapping("/{id}")
    public Student findStudent(@PathVariable("id") UUID id) {
        return service.findStudent(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student with id " + id + " not found")
                );
    }

    @PostMapping("/{id}/actions/expel")
    public Student expelStudent(@PathVariable("id") UUID id) {
        return service.expelStudent(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") UUID id) {
        service.deleteStudent(id);
    }
}
