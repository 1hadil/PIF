package tn.esprit.flouslab.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Premium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPremium;
    private LocalDate date;
    private Double amount;
    private boolean status;
    private Double accumulatedInterest;

    @ManyToOne
    Insurance insurance;

}
