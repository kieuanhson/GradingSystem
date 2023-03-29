package org.group9.gradingsystemserver.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.group9.gradingsystemserver.Entity.Enum.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountAddDTO {
    private String username;
    private String password;
    private Role role;
    private boolean status;
}
