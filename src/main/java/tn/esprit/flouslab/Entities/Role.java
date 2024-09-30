package tn.esprit.flouslab.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

@EntityListeners(AuditingEntityListener.class)
public class Role {

    @Id
    @GeneratedValue
    private int id ;
    @Column(unique = true)
    private String name ;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<User> users;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;


    public String getname() {
        return name;
    }
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;

}
