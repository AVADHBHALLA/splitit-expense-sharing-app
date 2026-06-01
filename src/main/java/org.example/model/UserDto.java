package org.example.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @NonNull
    private String name;

    @NonNull
    private String email;
}
