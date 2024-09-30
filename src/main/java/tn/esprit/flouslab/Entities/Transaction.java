package tn.esprit.flouslab.Entities;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.flouslab.Entities.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.time.LocalDate;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Transaction {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaction;
    private String type;
    private LocalDate date;
    private String amount;
    private String transactionStatus;
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;
    @OneToOne(mappedBy = "transaction", cascade = CascadeType.ALL)
    private Complaint complaint;


}
