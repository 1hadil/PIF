package tn.esprit.flouslab.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.flouslab.Entities.Contest;
import tn.esprit.flouslab.Entities.Course;
import tn.esprit.flouslab.Repositories.ContestRepository;
import tn.esprit.flouslab.Repositories.CourseRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ContestServiceImpl implements IContestService{
    public final ContestRepository contestRepository;
    public final CourseRepository courseRepository;
    @Override
    public Contest addContest(Contest contest) {
        return contestRepository.save(contest);
    }

    @Override
    public Contest getContestById(Long id) {
        return contestRepository.findById(id).orElse(null);
    }

    @Override
    public Contest updateContest(Contest contest) {
        return contestRepository.save(contest);
    }

    @Override
    public void deleteContest(Long id) {

    }

    @Override
    public List<Contest> getAll() {
        return (List<Contest>) contestRepository.findAll();
    }

    @Override
    public Contest assignContestToCourse(Long idContest, Long idCourse) {
        Contest contest = contestRepository.findById(idContest).orElse(null);
        Course course = courseRepository.findById(idCourse).orElse(null);
        contest.setCourse(course);
        return contestRepository.save(contest);
    }
}
