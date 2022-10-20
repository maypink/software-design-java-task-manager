package software.design.controller;

import software.design.model.Group;
import software.design.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService service;

    @GetMapping
    public List<String> getGroups() {
        return service.getGroups();
    }

    @GetMapping("/{name}")
    public Group getGroup(@PathVariable("name") String name) {
        return service.findGroup(name)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Group with name " + name + " not found")
                );
    }

    @PostMapping
    public Group createGroup(@RequestBody @Validated Group group) {
        return service.createGroup(group);
    }

    @DeleteMapping("/{name}")
    public void deleteGroup(@PathVariable("name") String name) {
        service.deleteGroup(name);
    }
}
