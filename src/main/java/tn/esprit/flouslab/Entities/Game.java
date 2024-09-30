package tn.esprit.flouslab.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

    public class Game {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idGame;
        private String name;
        private String description;
        private String level;

        @ManyToOne
        @JoinColumn(name = "idContest")
        private Contest contest;
}
