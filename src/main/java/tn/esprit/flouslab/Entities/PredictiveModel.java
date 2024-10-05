package tn.esprit.flouslab.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

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


    @ManyToMany(mappedBy = "predictiveModels",cascade = CascadeType.ALL)
    private Set<Insurance> insurances;
}
