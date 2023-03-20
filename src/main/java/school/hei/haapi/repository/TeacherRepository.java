package school.hei.haapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.hei.haapi.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
}
