package org.group9.gradingsystemserver.Entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "assessment_group")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentGroup {
    @Id
    @Column(name = "assessment_group_code")
    private String assessmentGroupCode;
    @Column(name = "assessment_group_name")
    private String assessmentGroupName;
    @OneToMany
    @JoinColumn(name = "assessment_group", referencedColumnName = "assessment_group_code")
    private Set<Assessment> assessment;
}
