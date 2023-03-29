package org.group9.homeschooling.DTO;

import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountLoginDTO {
    private String username;
    private String password;
}
