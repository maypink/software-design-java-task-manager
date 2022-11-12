package software.design.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String surname;

    private boolean expelled;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private GroupEntity group;
}
