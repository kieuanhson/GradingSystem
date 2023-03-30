package org.group9.gradingsystemserver.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "account_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetails {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "acc_id")
    @NotNull
    private UUID acc_id;
    @Column(name = "first_name")
    @NotNull
    private String firstName;
    @Column(name = "middle_name")
    @NotNull
    private String middleName;
    @Column(name = "last_name")
    @NotNull
    private String lastName;
    @Column(name = "birth_date")
    @NotNull
    private LocalDate birthDate;
    @Column(name = "gender")
    @NotNull
    private String gender;

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }
}
