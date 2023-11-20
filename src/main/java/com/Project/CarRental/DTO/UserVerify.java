package com.Project.CarRental.DTO;


import com.Project.CarRental.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVerify {
    private int id;
    private String username;
    private Role roles;
}
