package tn.esprit.flouslab.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.flouslab.Entities.Contest;
import tn.esprit.flouslab.Entities.Course;

import java.util.List;

public interface ContestRepository extends CrudRepository <Contest, Long>{
    List<Contest> findAllByCourse(Course course);

}
