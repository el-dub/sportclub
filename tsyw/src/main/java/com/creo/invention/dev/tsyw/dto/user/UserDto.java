package com.creo.invention.dev.tsyw.dto.user;

import com.creo.invention.dev.tsyw.model.Role;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class UserDto {

    private UUID userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String role;
    private LocalDate birthday;

}
