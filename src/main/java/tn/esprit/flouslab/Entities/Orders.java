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
public class Orders {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long idOrder;

 @Enumerated(EnumType.STRING)
 private IType type;
 private LocalDate date;
 private String status;

 @ManyToOne
 @JoinColumn(name = "idPortfolio")
 private Portfolio portfolio;

 @OneToOne
 @JoinColumn(name = "idStock")
 private Stock stock;

 @OneToOne
 @JoinColumn(name = "idBond")
 private Bond bond;

 @OneToOne
 @JoinColumn(name = "idCurrency")
 private Currency currency;

}