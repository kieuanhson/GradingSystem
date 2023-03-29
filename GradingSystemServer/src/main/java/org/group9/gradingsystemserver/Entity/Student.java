package org.group9.gradingsystemserver.Entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @Column(name = "acc_id")
    private UUID id;
    @Column(name = "student_code")
    @NotNull
    private String studentCode;
    @OneToOne
    @JoinColumn(name = "cur_id", referencedColumnName = "cur_id")
    private Curriculum curriculum;
    @OneToOne
    @MapsId
    @JoinColumn(name = "acc_id")
    private Account acc;
    @ManyToMany(mappedBy = "students")
    private Set<Class> classes;
    @OneToMany
    @JoinColumn(name = "student_id", referencedColumnName = "acc_id")
    private Set<Assessment> assessments;
}
