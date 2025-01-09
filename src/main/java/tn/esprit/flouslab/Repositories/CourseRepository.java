package tn.esprit.flouslab.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.flouslab.Entities.Course;
import tn.esprit.flouslab.Entities.User;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findAllByUser(User user);
}
