package school.hei.haapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import school.hei.haapi.model.Course;
import school.hei.haapi.model.Student;
import school.hei.haapi.repository.CourseRepository;
import school.hei.haapi.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    public List<Course> getLinkedCourse (String student_id){
        return courseRepository.findCourseByStudentId(student_id);
    }
}
