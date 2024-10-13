package tn.esprit.flouslab.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.flouslab.Entities.Insurance;
import tn.esprit.flouslab.Entities.Orders;

@Repository
public interface OrderRepository extends CrudRepository<Orders,Long> {

}
