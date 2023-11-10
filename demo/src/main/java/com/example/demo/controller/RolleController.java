package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.RoleDTO;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/role")
public class RolleController {
    @Autowired
    RoleService roleService;
    @PostMapping("/")
    public ResponseDTO<Void> createNewJson(@RequestBody @Valid RoleDTO roleDTO) {
        roleService.create(roleDTO);

        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("create succesful")
                .build();
    }
}
