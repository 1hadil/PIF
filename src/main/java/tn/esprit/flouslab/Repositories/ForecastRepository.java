package tn.esprit.flouslab.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.flouslab.Entities.Forecast;

public interface ForecastRepository extends CrudRepository<Forecast,Long> {
}
