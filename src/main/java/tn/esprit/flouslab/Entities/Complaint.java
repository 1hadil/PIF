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

public class Complaint {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComplaint;
    private LocalDate date;
    private String subject;
    private String description;
    private String status;

    @OneToOne
    @JoinColumn(name = "idTransaction")
    private Transaction transaction;
}
