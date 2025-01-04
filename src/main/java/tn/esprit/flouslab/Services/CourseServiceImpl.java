package tn.esprit.flouslab.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.flouslab.Entities.Course;
import tn.esprit.flouslab.Entities.User;
import tn.esprit.flouslab.Repositories.CourseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService{
    private final CourseRepository courseRepository;

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {

    }

    @Override
    public List<Course> getAll() {
        return (List<Course>) courseRepository.findAll();
    }


}
