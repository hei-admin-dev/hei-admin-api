package school.hei.haapi.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.hei.haapi.model.Course;
import school.hei.haapi.model.exception.BadRequestException;
import school.hei.haapi.model.validator.CourseValidator;
import school.hei.haapi.repository.CourseRepository;
import school.hei.haapi.repository.UserRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import school.hei.haapi.model.BoundedPageSize;
import school.hei.haapi.model.PageFromOne;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final  CourseMapper courseMapper;
    private final CourseValidator courseValidator;

    public Course updateCourseStatus(String student_id, String course_id, String status) {
        Course course = courseRepository.findById(course_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("", course_id)));
        if (status == "UNLINKED") {
            course.getStudent().remove(userRepository.getById(student_id));
        }
        if (status == "LINKED") {
            course.getStudent().add(userRepository.getById(student_id));
        } else throw new BadRequestException("Not recognized parameters");

        return course;
    }

    public List<Course> getAll(PageFromOne page, BoundedPageSize pageSize) {
        int pageValue = 1;
        int pageSizeValue = 15;
        if (page.getValue() != 0)
            pageValue = page.getValue();
        if (pageSize.getValue() != 0)
            pageSizeValue = pageSize.getValue();
        Pageable pageable = PageRequest.of(
                pageValue - 1,
                pageSizeValue
        );
        return courseRepository.findAll(pageable).getContent();
    }

    @Transactional
    public List<Course> saveAll(List<Course> courses) {
        courseValidator.accept(courses);
        return courseRepository.saveAll(courses);
    }
}
