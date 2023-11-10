package com.example.demo.dto;

import com.example.demo.entity.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
@Data
public class UserDTO {
    private Integer id;

    private String address;
    @NotBlank
    private String phone;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;

    private String avatarURL;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "Asia/Ho_Chi_Minh")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthdate;
    @JsonIgnore
    private MultipartFile file;
    private List<RoleDTO> roles;
}
