package tn.esprit.flouslab.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.flouslab.Entities.Course;
import tn.esprit.flouslab.Entities.Lesson;
import tn.esprit.flouslab.Repositories.CourseRepository;
import tn.esprit.flouslab.Repositories.LessonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements ILessonService{
    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;
    @Override
    public Lesson addLesson(Lesson lesson,Long id) {
        Course course= courseRepository.findById(id).orElse(null);
        lesson.setCourse(course);
        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonRepository.findById(id).orElse(null);
    }

    @Override
    public Lesson updateLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public void deleteLesson(Long id) {
       lessonRepository.deleteById(id);
    }

    @Override
    public List<Lesson> getAll() {
        return (List<Lesson>) lessonRepository.findAll();
    }
    @Override
    public List<Lesson> getAllbucourse(Long id) {
        Course course = courseRepository.findById(id).get();

        return  lessonRepository.findAllByCourse(course);
    }
}
