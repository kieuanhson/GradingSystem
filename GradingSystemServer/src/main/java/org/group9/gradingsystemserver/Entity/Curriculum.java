package org.group9.gradingsystemserver.Entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "curriculum")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curriculum {
    @Id
    @NotNull
    @Column(name = "cur_id")
    private String cur_id;
    @Column(name = "cur_name")
    @NotNull
    private String cur_name;
    @ManyToMany
    @JoinTable(name = "curriculum_course",
            joinColumns = @JoinColumn(name = "cur_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;
}
