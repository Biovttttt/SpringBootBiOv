package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "instructors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Instructor {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "instructor_gen"
    )
    @SequenceGenerator(
            name = "instructor_gen",
            sequenceName = "instructor_seq",
            allocationSize = 1
    )
    private Long id;
    private String firstname;
    private String lastname;
    private int phoneNumber;
    private String specialization;

    public Instructor(String firstname, String lastname, int phoneNumber, String specialization) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
    }
    @ManyToMany(mappedBy = "instructors",cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST},fetch = FetchType.LAZY)
    List<Company>companies;
    @OneToMany(mappedBy = "instructor",cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    List<Course>courses;
}
