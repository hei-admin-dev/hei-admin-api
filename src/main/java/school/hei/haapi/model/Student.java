package school.hei.haapi.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String ref;

    private Instant entranceDatetime;

    private String phone;

    private String address;

    private User.Sex sex;

    private User.Status status;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Course> courseList;
}
