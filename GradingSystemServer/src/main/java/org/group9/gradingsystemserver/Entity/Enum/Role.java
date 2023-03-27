package org.group9.gradingsystemserver.Entity.Enum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    Teacher(1),
    Student(0);

    private final int id;

}
