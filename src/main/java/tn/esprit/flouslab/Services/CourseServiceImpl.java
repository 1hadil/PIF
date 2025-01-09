package tn.esprit.flouslab.Services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.flouslab.Entities.Course;
import tn.esprit.flouslab.Entities.User;
import tn.esprit.flouslab.Repositories.CourseRepository;
import tn.esprit.flouslab.Repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService{
    private final CourseRepository courseRepository;
    private final UserRepository  userRepository;

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
    @Override
    public Course addCourseanduser(Long idcourse, Integer iduser) {

        User user = userRepository.findById(iduser)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + iduser));
        Course course = courseRepository.findById(idcourse)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + idcourse));


        if (!course.getUser().contains(user)) {
            course.getUser().add(user);
        }


        if (!user.getCourses().contains(course)) {
            user.getCourses().add(course);
        }

        courseRepository.save(course);
        return course;
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
    @Transactional
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Supprimer toutes les associations utilisateur
        for (User user : course.getUser()) {
            user.getCourses().remove(course);
        }

        course.getUser().clear(); // Nettoyer la liste d'utilisateurs associés
        courseRepository.save(course); // Sauvegarder les modifications

        // Supprimer le cours
        courseRepository.deleteById(id);
    }


    @Override
    public List<Course> getAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public List<Course> getAllbyuser (Integer id) {
        User user = userRepository.findById(id).orElse(null);
        return  courseRepository.findAllByUser(user);
    }


}
