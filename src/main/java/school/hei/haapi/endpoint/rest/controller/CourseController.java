package school.hei.haapi.endpoint.rest.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.hei.haapi.model.Course;
import school.hei.haapi.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import school.hei.haapi.endpoint.rest.mapper.CourseMapper;
import school.hei.haapi.service.CourseService;
import school.hei.haapi.endpoint.rest.model.UpdateStudentCourse;
import school.hei.haapi.endpoint.rest.model.Course;
import java.util.List;
import java.io.toString;


@RestController
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;
     private final CourseMapper courseMapper;

    @GetMapping("/student/{student_id}/courses")
    public List<Course> getCourseByStatus (@PathVariable String student_id, @RequestParam Course.Status status){
        return courseService.getCourseByStatus(student_id,status);
    }
}
   
    @PutMapping("/students/{student_id}/courses")
    public Course updateCoursesByStatus(@RequestBody List<UpdateStudentCourse> course,@PathVariable String  student_id,String status){
       return courseMapper.toRestCourse(courseService.updateCourseStatus(student_id,course.get(0).getCourseId(),course.get(0).getStatus().toString()));
   }
}

