package com.Project.CarRental.Service.interfaces;


import com.Project.CarRental.DTO.JwtAuthenticationRequest;
import com.Project.CarRental.DTO.SignInRequest;
import com.Project.CarRental.DTO.SignUpRequest;
import com.Project.CarRental.entity.User;

public interface AuthenticationService {
    public User signUp(SignUpRequest signUpRequest);
    public JwtAuthenticationRequest signIn(SignInRequest signInRequest);
}
