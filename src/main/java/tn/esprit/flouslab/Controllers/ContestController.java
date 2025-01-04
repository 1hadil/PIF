package tn.esprit.flouslab.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.flouslab.Entities.Contest;
import tn.esprit.flouslab.Services.IContestService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contest")
public class ContestController {
    private final IContestService contestService;

    @PostMapping("/add")
    public Contest addContest(@RequestBody Contest contest){
        return contestService.addContest(contest);
    }
    @GetMapping("/get/{id}")
    public Contest getContest(@PathVariable Long id){
        return contestService.getContestById(id);
    }
    @PutMapping("/update")
    public Contest updateContest(@RequestBody Contest contest){
        return contestService.updateContest(contest);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteContest( Long id){
        contestService.deleteContest(id);
        return "Contest deleted !!";
    }
    @GetMapping("/all")
    public List<Contest> getAllContest(){
        return contestService.getAll();
    }

    @Operation(description = "Assign Contest to Course")
    @PutMapping("/assignContestCourse/{idContest}/{idCourse}")
    public Contest assignContestToCourse(@PathVariable("idContest")Long idContest,
                                         @PathVariable("idCourse")Long idCourse){
        return contestService.assignContestToCourse(idContest,idCourse);
    }



}
