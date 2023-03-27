package org.group9.gradingsystemserver.Entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "assessment_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assessment_info_id")
    private int id;
    @Column(name = "assessment_name")
    private String assessmentName;
    @Column(name = "assessment_percentage")
    private float assessmentPercentage;
}
