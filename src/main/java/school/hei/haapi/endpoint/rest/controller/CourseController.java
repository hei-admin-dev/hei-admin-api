package school.hei.haapi.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import school.hei.haapi.endpoint.rest.mapper.CourseMapper;
import school.hei.haapi.endpoint.rest.model.Course;
import school.hei.haapi.endpoint.rest.model.CrupdateCourse;
import school.hei.haapi.service.CourseService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @PutMapping(value = "/courses")
    public List<Course> createOrUpdateCourses(@RequestBody List<CrupdateCourse> toWrite) {
        var saved = courseService.saveAll(toWrite.stream()
                .map(courseMapper::toDomainCrupdateCourse)
                .collect(Collectors.toUnmodifiableList()));
        return saved.stream()
                .map(courseMapper::toRestCourse)
                .collect(Collectors.toUnmodifiableList());
    }
}
