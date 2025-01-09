package tn.esprit.flouslab.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Enumerated(EnumType.STRING)
    private CStatus status;
    private String amount;
    private String image;
    @Column(columnDefinition = "TEXT")
    private String details;
    @ManyToOne
    User user;
    @ManyToOne
    Insurance insurance;


}
