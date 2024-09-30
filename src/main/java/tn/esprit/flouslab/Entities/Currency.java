package tn.esprit.flouslab.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurrency;
    private String symbol;
    private Double exchangeRate;
    private String baseCurrency;
    private String counterCurrency;
    private Double spread;
}