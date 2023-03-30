package org.group9.homeschooling.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountLoginSessionDTO {
    private String id;
    private String role;
    private String displayName;
}
