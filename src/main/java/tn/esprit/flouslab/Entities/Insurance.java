package tn.esprit.flouslab.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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

 @Enumerated(EnumType.STRING)
 private IType type;
 private float clientcoverageamount;
 private float clientpremium;
 private Integer duration;
 private Long idorder;
 @Column(columnDefinition = "TEXT")
 private String policy;
 @Enumerated(EnumType.STRING)
 private  InStatus state;

 @ManyToOne
 @JoinColumn(name = "user_id")
 private User user;
@JsonIgnore
 @OneToMany(cascade = CascadeType.ALL,mappedBy = "insurance")
 private Set<Claim> claims;

 @OneToMany(cascade = CascadeType.ALL,mappedBy = "insurance")
 private Set<Premium> premiums;



 @ManyToMany(cascade = CascadeType.ALL)
 private Set<PredictiveModel> predictiveModels;


}
