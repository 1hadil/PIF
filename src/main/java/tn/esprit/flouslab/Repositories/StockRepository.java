package tn.esprit.flouslab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.flouslab.Entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
    // Vous pouvez ajouter des méthodes de requêtes personnalisées si nécessaire
    // Exemple:
    // List<Stock> findByCompanyName(String companyName);
}
