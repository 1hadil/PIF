package tn.esprit.flouslab.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Forecast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idForecast;
    private String type;
    private String premiumRange;
    private Double estimatedCompensationAmount;
    private Double claimProbability;

    @OneToOne
    @JoinColumn(name = "idInsurance")
    private Insurance insurance;
}
