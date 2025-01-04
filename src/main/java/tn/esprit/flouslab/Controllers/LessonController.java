package tn.esprit.flouslab.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.flouslab.Entities.Lesson;
import tn.esprit.flouslab.Services.ILessonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lesson")
public class LessonController {
    private final ILessonService lessonService;

    @PostMapping("/add")
    public Lesson addLesson(@RequestBody Lesson lesson){
        return lessonService.addLesson(lesson);
    }
    @GetMapping("/get/{id}")
    public Lesson getLesson(@PathVariable Long id){
        return lessonService.getLessonById(id);
    }
    @PutMapping("/update")
    public Lesson updateLesson(@RequestBody Lesson lesson){
        return lessonService.updateLesson(lesson);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteLesson( Long id){
        lessonService.deleteLesson(id);
        return "Lesson deleted !!";
    }
    @GetMapping("/all")
    public List<Lesson> getAllLesson(){
        return lessonService.getAll();
    }

}
