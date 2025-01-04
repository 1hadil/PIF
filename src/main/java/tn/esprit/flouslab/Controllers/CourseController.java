package tn.esprit.flouslab.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.flouslab.Entities.Course;
import tn.esprit.flouslab.Services.ICourseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {
    private final ICourseService courseService;

    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }
    @GetMapping("/get/{id}")
    public Course getCourse(@PathVariable Long id){
        return courseService.getCourseById(id);
    }
    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteCourse( Long id){
        courseService.deleteCourse(id);
        return "Course deleted !!";
    }
    @GetMapping("/all")
    public List<Course> getAllCourse(){
        return courseService.getAll();
    }

}
