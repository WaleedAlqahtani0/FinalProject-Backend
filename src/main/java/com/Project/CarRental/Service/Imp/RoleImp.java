package com.Project.CarRental.Service.Imp;

import com.Project.CarRental.Repository.RoleRepository;
import com.Project.CarRental.Repository.UserRepository;
import com.Project.CarRental.Service.interfaces.RoleServices;
import com.Project.CarRental.entity.Role;
import com.Project.CarRental.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleImp implements RoleServices {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Role saveRole(Role role) {
        log.info("Saving a new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    }

