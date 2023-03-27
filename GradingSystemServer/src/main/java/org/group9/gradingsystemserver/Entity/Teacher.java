package org.group9.gradingsystemserver.Entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.group9.gradingsystemserver.Entity.Enum.Department;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @Column(name = "acc_id")
    private UUID id;
    @Column(name = "teacher_code")
    @NotNull
    private String teacherCode;
    @Column(name = "department")
    @NotNull
    private Department department;
    @JoinColumn(name = "acc_id")
    @OneToOne
    @MapsId
    private Account acc;
    @OneToMany(mappedBy = "teacher")
    private Set<Class> classes;
}
