package school.hei.haapi.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "\"course\"")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String id;

    private String code;

    private String name;

    private Integer credits;

    private Integer totalHours;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher mainTeacher;

}
