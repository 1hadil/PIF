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
public class Contest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContest;
    private String name;
    private String description;
    private LocalDate date;
    private String reward;

    @ManyToOne
    @JoinColumn(name = "idCourse")
    private Course course;

    @OneToMany(mappedBy = "contest")
    private List<Game> games;
}
