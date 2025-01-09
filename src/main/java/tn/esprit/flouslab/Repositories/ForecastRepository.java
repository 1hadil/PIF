package tn.esprit.flouslab.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.flouslab.Entities.Forecast;
import tn.esprit.flouslab.Entities.User;

import java.util.List;
@Repository
public interface ForecastRepository extends CrudRepository<Forecast,Long> {
    List<Forecast> findAllByUser(User user);
}
