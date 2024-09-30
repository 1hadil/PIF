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
    private String status;
    private Double accumulatedInterest;

    @ManyToOne
    @JoinColumn(name = "idInsurance")
    private Insurance insurance;
}
