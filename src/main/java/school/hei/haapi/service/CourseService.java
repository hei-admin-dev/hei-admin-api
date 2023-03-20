package school.hei.haapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import school.hei.haapi.model.Course;
import school.hei.haapi.repository.CourseRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    private CourseRepository courseRepository;

    @Transactional
    public List<Course> saveAll(List<Course> courses) {
        return courseRepository.saveAll(courses);
    }
}
