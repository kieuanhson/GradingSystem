package org.group9.gradingsystemserver.Entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "class")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Class {
    @Id
    @NotNull
    private String classCode;
    @Column(name = "class_name")
    @NotNull
    private String className;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @ManyToMany
    @JoinTable(name = "class_assessment_group",
            joinColumns = @JoinColumn(name = "class_code"),
            inverseJoinColumns = @JoinColumn(name = "assessment_group_code"))
    private Set<AssessmentGroup> assessmentGroups;
    @ManyToMany
    @JoinTable(name = "student_class",
            joinColumns = @JoinColumn(name = "class_code"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> students;
}
