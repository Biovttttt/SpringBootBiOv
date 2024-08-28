package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
    @Table(name = "groups")
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor


    public class Group {
        @Id
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "group_gen"
        )
        @SequenceGenerator(
                name = "group_gen",
                sequenceName = "group_seq",
                allocationSize = 1
        )
        private Long id;
        private String groupName;
        private String description;

        public Group(String groupName, String description) {
            this.groupName = groupName;
            this.description = description;
        }
    @ManyToMany(mappedBy = "groups",cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST})
   private List<Course>courses;
    @OneToMany(mappedBy = "group",cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
      private   List<Student>students;
    }
