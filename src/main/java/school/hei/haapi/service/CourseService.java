package school.hei.haapi.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.hei.haapi.model.Course;
import school.hei.haapi.repository.CourseRepository;

import java.util.List;
import java.util.Objects;

import static school.hei.haapi.model.Course.Status.LINKED;
import static school.hei.haapi.model.Course.Status.UNLINKED;

@Service
@AllArgsConstructor
@Slf4j
public class CourseService {
    private final CourseRepository courseRepository;

public List<Course> getCourseByStatus (String student_id,Course.Status status ){
    if(status == LINKED){
        return courseRepository.findCourseByIdAndStatus(student_id, status);
    }
    return courseRepository.findCourseByIdAndStatus(student_id,UNLINKED);
}
}
