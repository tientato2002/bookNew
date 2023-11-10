package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService ;
    @PostMapping("/")
    public ResponseDTO<Void> newUser(
            @ModelAttribute @Valid UserDTO userDTO)
            throws IllegalStateException, IOException {

        if (!userDTO.getFile().isEmpty()) {
            // ten file upload
            String filename = userDTO.getFile().getOriginalFilename();
            // luu lai file vao o cung may chu
            File saveFile = new File("F:/" + filename);
            userDTO.getFile().transferTo(saveFile);
            // lay ten file luu xuong database
            userDTO.setAvatarURL(filename);
        }
        userService.create(userDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("create succesful")
                .build();
    }
    @GetMapping("/get")
    public void get (){
        userService.findName();
    }
}
