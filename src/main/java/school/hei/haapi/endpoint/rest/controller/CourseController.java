package school.hei.haapi.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.hei.haapi.model.Course;
import school.hei.haapi.service.CourseService;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/student/{student_id}/courses")
    public List<Course> getCourseByStatus (@PathVariable String student_id, @RequestParam Course.Status status){
        return courseService.getCourseByStatus(student_id,status);
    }
}
