package org.group9.gradingsystemserver.Entity.Enum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    Admin(0),
    Teacher(1),
    Student(2);

    private final int id;

}
