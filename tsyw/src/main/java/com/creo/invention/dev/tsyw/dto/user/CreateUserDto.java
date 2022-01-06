package com.creo.invention.dev.tsyw.dto.user;

import lombok.Data;

@Data
public class CreateUserDto {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String birthday;
    private String password;


}
