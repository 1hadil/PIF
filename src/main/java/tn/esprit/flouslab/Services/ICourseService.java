package tn.esprit.flouslab.Services;

import tn.esprit.flouslab.Entities.Course;

import java.util.List;

public interface ICourseService {
    Course addCourse(Course course);
    Course getCourseById(Long id);
    Course updateCourse(Course course);
    void deleteCourse(Long id);
    List<Course> getAll();

}
