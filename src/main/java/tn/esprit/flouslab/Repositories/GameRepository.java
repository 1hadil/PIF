package tn.esprit.flouslab.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.flouslab.Entities.Contest;
import tn.esprit.flouslab.Entities.Game;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Long> {
    List<Game> findAllByContest(Contest contest);
}
