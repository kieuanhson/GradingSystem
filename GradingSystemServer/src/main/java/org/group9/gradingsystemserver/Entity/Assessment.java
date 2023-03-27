package org.group9.gradingsystemserver.Entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "assessment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Assessment {
    @Id
    @Column(name = "assessment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "assessment_value")
    private float assessmentValue;
    @Column(name = "assessment_comment")
    private String assessmentComment;
    @ManyToOne
    @JoinColumn(name = "assessment_group")
    private AssessmentGroup assessmentGroup;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
