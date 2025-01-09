package tn.esprit.flouslab.Services;

import tn.esprit.flouslab.Entities.Contest;
import tn.esprit.flouslab.Entities.Lesson;

import java.util.List;

public interface IContestService {
    public Contest addContest(Contest contest,Long id);
    public List<Contest> getAllbucourse(Long id);
    Contest getContestById(Long id);
    Contest updateContest(Contest contest);
    void deleteContest(Long id);
    List<Contest> getAll();
    Contest assignContestToCourse(Long idContest, Long idCourse);
}
