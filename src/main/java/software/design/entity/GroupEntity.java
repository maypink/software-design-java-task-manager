package software.design.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "university_group") // group is a reserved keyword
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GroupEntity {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(unique = true)
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "group")
    private List<StudentEntity> students;
}
