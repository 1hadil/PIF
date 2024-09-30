package tn.esprit.flouslab.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Insurance {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long idInsurance;
 private LocalDate startDate;
 private LocalDate endDate;
 private String name;
 private String type;
 private String coverageLevel;
 private Double premium;
 @ManyToOne
 @JoinColumn(name = "id")
 private User user;

 @OneToOne(mappedBy = "insurance", cascade = CascadeType.ALL)
 private Claim claim;

 @OneToMany(mappedBy = "insurance")
 private List<Premium> premiums;

 @OneToOne(mappedBy = "insurance", cascade = CascadeType.ALL)
 private Forecast forecast;
}