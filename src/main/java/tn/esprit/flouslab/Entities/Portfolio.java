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
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPortfolio;
    private String totalValue;
    private String status;
    private String performance;
    private LocalDate creationDate;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    @OneToMany(mappedBy = "portfolio")
    private List<Orders> orders;
}
