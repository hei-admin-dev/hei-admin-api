package school.hei.haapi.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import school.hei.haapi.model.Course;
import school.hei.haapi.service.CourseService;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/courses/{courseId}")

    public Optional<Course> getCourseById (@PathVariable String courseId ){
       return courseService.getCourseById(courseId);
    }

}
