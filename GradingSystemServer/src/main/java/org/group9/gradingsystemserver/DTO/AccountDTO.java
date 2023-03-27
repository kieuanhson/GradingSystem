package org.group9.gradingsystemserver.DTO;

import lombok.Getter;
import lombok.Setter;
import org.group9.gradingsystemserver.Entity.Enum.Role;

@Getter
@Setter
public class AccountDTO {
    private String username;
    private String password;
    private Role role;
    private boolean status;
}
