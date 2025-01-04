package tn.esprit.flouslab.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.flouslab.Entities.Lesson;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
}
