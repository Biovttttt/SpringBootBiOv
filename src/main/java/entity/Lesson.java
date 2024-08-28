package entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lesson_gen"
    )@SequenceGenerator(
            name = "lesson_name",
            sequenceName = "lesson_seq",
            allocationSize = 1
    )
    private Long id;
    private String lessonName;

    public Lesson(String lessonName) {
        this.lessonName = lessonName;
    }
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST},fetch = FetchType.EAGER)
    private Course course;

    @OneToMany(mappedBy = "Lesson",cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
  List<Task>tasks;

}
