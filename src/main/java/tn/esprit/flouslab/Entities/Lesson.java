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
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLesson;
    private String name;
    private String description;
    private String time;
    private LocalDate startDate;
    private LocalDate endDate;
    private String duree;

    @ManyToOne
    @JoinColumn(name = "idCourse")
    private Course course;
}
