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
public class PredictiveModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModel;
    private String name;
    private String type;
    private LocalDate creationDate;
    private String parameters;

    @OneToOne
    @JoinColumn(name = "idClaim")
    private Claim claim;
}
