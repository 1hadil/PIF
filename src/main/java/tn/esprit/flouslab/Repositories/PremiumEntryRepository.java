package tn.esprit.flouslab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.flouslab.Entities.PremiumEntry;

public interface PremiumEntryRepository extends JpaRepository<PremiumEntry, Long> {
}
