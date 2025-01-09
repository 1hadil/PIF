package tn.esprit.flouslab.Services;

import tn.esprit.flouslab.Entities.Lesson;

import java.util.List;

public interface ILessonService {
    public Lesson addLesson(Lesson lesson,Long id)
        ;
    public List<Lesson> getAllbucourse(Long id);
    Lesson getLessonById(Long id);
    Lesson updateLesson(Lesson lesson);
    void deleteLesson(Long id);
    List<Lesson> getAll();
}
