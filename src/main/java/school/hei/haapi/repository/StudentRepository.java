package school.hei.haapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.hei.haapi.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
}
