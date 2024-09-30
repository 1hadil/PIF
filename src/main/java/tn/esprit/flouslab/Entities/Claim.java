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

public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClaim;
    private LocalDate date;
    private String status;
    private String amount;

    @OneToOne
    @JoinColumn(name = "idInsurance")
    private Insurance insurance;

    @OneToOne(mappedBy = "claim", cascade = CascadeType.ALL)
    private PredictiveModel predictiveModel;
}
