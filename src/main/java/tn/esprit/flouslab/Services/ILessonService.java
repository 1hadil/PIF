package tn.esprit.flouslab.Services;

import tn.esprit.flouslab.Entities.Lesson;

import java.util.List;

public interface ILessonService {
    Lesson addLesson(Lesson lesson);
    Lesson getLessonById(Long id);
    Lesson updateLesson(Lesson lesson);
    void deleteLesson(Long id);
    List<Lesson> getAll();
}
