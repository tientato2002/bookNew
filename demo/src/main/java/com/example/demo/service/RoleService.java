package com.example.demo.service;

import com.example.demo.dto.RoleDTO;
import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class RoleService {
    @Autowired
    RoleRepo roleRepo;
    @Transactional
    public void create(RoleDTO roleDTO) {
        Role role = new ModelMapper().map(roleDTO, Role.class);
        roleRepo.save(role);
    }
}
