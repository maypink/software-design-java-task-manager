package software.design.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "task_statuses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskStatusEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "status")
    private List<TaskEntity> tasks;
}
