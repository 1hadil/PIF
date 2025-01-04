package tn.esprit.flouslab.Services;

import tn.esprit.flouslab.Entities.Contest;

import java.util.List;

public interface IContestService {
    Contest addContest(Contest contest);
    Contest getContestById(Long id);
    Contest updateContest(Contest contest);
    void deleteContest(Long id);
    List<Contest> getAll();
    Contest assignContestToCourse(Long idContest, Long idCourse);
}
