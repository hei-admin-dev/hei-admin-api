package school.hei.haapi.model;

import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import school.hei.haapi.repository.types.PostgresEnumType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@EqualsAndHashCode
@Table(name = "\"teacher\"")
@TypeDef(name = "pgsql_enum", typeClass = PostgresEnumType.class)
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String id;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Reference is mandatory")
    private String ref;

    @Type(type = "pgsql_enum")
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotBlank(message = "Phone number is mandatory")
    private String phone;

    private LocalDate birthDate;

    private Instant entranceDatetime;

    @Type(type = "pgsql_enum")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @NotBlank(message = "Address is mandatory")
    private String address;


    public enum Status {
        ENABLED, DISABLED
    }
    public enum Sex {
        M, F
    }

}
