package tn.esprit.flouslab.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Bond {
 @Id

 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long idBond;
 private String name;
 private LocalDate startDate;
 private LocalDate endDate;
 private Double interestRate;
 private Double amount;
}
