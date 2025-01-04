package tn.esprit.flouslab.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.flouslab.Entities.Game;

public interface GameRepository extends CrudRepository<Game, Long> {
}
