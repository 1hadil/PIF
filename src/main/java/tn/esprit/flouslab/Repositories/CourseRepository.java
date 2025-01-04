package tn.esprit.flouslab.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.flouslab.Entities.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
