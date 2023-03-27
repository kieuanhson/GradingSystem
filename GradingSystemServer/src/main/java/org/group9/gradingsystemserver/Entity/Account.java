package org.group9.gradingsystemserver.Entity;

import lombok.*;
import org.group9.gradingsystemserver.Entity.Enum.Role;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.UUID;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Type(type = "uuid-char")
    private UUID id;
    @Column(name = "username")
    @NotNull
    @NonNull
    private String userName;
    @Column(name = "password")
    @NotNull
    @NonNull
    private String password;
    @Column(name = "role")
    @NotNull
    @NonNull
    private Role role;
    @Column(name = "status")
    @NotNull
    @NonNull
    private Boolean status;
    @OneToOne
    @JoinColumn(name = "id")
    private AccountDetails accountDetail;
}
