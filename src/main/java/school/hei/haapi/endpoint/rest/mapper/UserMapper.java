package school.hei.haapi.endpoint.rest.mapper;

import org.springframework.stereotype.Component;
import school.hei.haapi.endpoint.model.StudentResource;
import school.hei.haapi.endpoint.model.TeacherResource;
import school.hei.haapi.model.User;

@Component
public class UserMapper {
  public StudentResource toExternalStudent(User user) {
    return StudentResource.builder()
        .id(user.getId())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .email(user.getEmail())
        .build();
  }

  public TeacherResource toExternalTeacher(User user) {
    return TeacherResource.builder()
        .id(user.getId())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .email(user.getEmail())
        .build();
  }
}