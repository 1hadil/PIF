package tn.esprit.flouslab.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.flouslab.Entities.Contest;
import tn.esprit.flouslab.Entities.Lesson;
import tn.esprit.flouslab.Services.ILessonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lesson")
@CrossOrigin(origins = "*")
public class LessonController {
    private final ILessonService lessonService;

    @PostMapping("/add/{id}")
    public Lesson addLesson(@RequestBody Lesson lesson,@PathVariable Long id){
        return lessonService.addLesson(lesson,id);
    }
    @GetMapping("/all/{id}")
    public List<Lesson> getAllContest(@PathVariable Long id){
        return lessonService.getAllbucourse(id);
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
    public String deleteLesson( @PathVariable  Long id){
        lessonService.deleteLesson(id);
        return "Lesson deleted !!";
    }
    @GetMapping("/all")
    public List<Lesson> getAllLesson(){
        return lessonService.getAll();
    }

}
