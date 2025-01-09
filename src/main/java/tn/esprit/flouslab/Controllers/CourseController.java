package tn.esprit.flouslab.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.flouslab.Entities.Contest;
import tn.esprit.flouslab.Entities.Course;
import tn.esprit.flouslab.Services.ICourseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
@CrossOrigin(origins = "*")
public class CourseController {
    private final ICourseService courseService;
    @PostMapping("/addCourseAndUser")
    public Course addCourseAndUser(@RequestParam Long idcourse, @RequestParam Integer iduser) {

        return courseService.addCourseanduser(idcourse, iduser);
    }
    @GetMapping("/all/{id}")
    public List<Course> getAllContest(@PathVariable Integer id){
        return courseService.getAllbyuser(id);
    }
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
    public void deleteCourse( @PathVariable  Long id){
        courseService.deleteCourse(id);

    }
    @GetMapping("/all")
    public List<Course> getAllCourse(){
        return courseService.getAll();
    }

}
