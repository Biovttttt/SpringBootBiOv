package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
    @Table(name = "companies")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor

    public class Company {
        @Id
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator= "company_gen"
        )
        @SequenceGenerator(
                name = "company_gen",
                sequenceName = "company_seq",
                allocationSize = 1
        )
        private Long id;
        private String name;
        private String country;
        private String address;
        private int phoneNumber;

        public Company(String name, String country, String address, int phoneNumber) {
            this.name = name;
            this.country = country;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }
        @OneToMany(mappedBy = "company",cascade=CascadeType.ALL)
       private List<Course>courses;
        @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
   private List<Instructor>instructors;

        public void addCourse(Course course) {
            if (courses == null) {
                courses = new ArrayList<Course>();
                courses.add(course);
            }
        }
    }
