package org.group9.gradingsystemserver.Entity.Enum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public enum Department {
    SE(1),
    AI(2),
    IA(3);
    private final int Id;
}
