package tn.esprit.flouslab.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String level;
    @JsonIgnore
    @ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL)
    private List<User> user;
    @JsonIgnore
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Lesson> lessons;
    @JsonIgnore
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Contest> contests;
}
