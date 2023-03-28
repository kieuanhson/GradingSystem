package org.group9.gradingsystemserver.Entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    @NotNull
    private int courseId;
    @Column(name = "course_name")
    @NotNull
    private String courseName;
    @Column(name = "course_credits")
    @NotNull
    private int courseCredits;
    @OneToMany(mappedBy = "course")
    private Set<Class> classes;
    @ManyToMany(mappedBy = "courses")
    private Set<Curriculum> curriculum;
}
