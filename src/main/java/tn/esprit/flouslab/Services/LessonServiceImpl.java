package tn.esprit.flouslab.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.flouslab.Entities.Lesson;
import tn.esprit.flouslab.Repositories.LessonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements ILessonService{
    private final LessonRepository lessonRepository;
    @Override
    public Lesson addLesson(Lesson lesson) {
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

    }

    @Override
    public List<Lesson> getAll() {
        return (List<Lesson>) lessonRepository.findAll();
    }
}
