package com.Project.CarRental.DTO;

import lombok.Data;

@Data
public class SignInRequest {
    private String username;
    private String password;
    private String email;
}
