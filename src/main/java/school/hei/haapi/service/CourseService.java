package school.hei.haapi.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.hei.haapi.endpoint.rest.mapper.CourseMapper;
import school.hei.haapi.model.Course;
import school.hei.haapi.model.exception.BadRequestException;
import school.hei.haapi.repository.CourseRepository;
import java.util.List;
import java.util.Objects;
import static school.hei.haapi.model.Course.Status.LINKED;
import static school.hei.haapi.model.Course.Status.UNLINKED;

import school.hei.haapi.repository.UserRepository;


@Service
@AllArgsConstructor
@Slf4j
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final  CourseMapper courseMapper;

    public Course updateCourseStatus(String stundet_id,String course_id,String status){
        Course course = courseRepository.findById(course_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("", course_id)));
        if(status == "UNLINKED"){
            course.getStudent().remove(userRepository.getById(stundet_id));
        }
        if(status == "LINKED"){
            course.getStudent().add(userRepository.getById(stundet_id));
        }
        else throw new BadRequestException("Not recognized parameters");


public List<Course> getCourseByStatus (String student_id,Course.Status status ){
    if(status == LINKED){
        return courseRepository.findCourseByIdAndStatus(student_id, status);
    }
    return courseRepository.findCourseByIdAndStatus(student_id,UNLINKED);
}        return course;
    
}

