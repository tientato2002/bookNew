package com.example.demo.service;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Transactional
    public void create(UserDTO userDTO) {
        User user = new ModelMapper().map(userDTO, User.class);
        userRepo.save(user);
    }
    @Transactional
    public void findName() {
        List <String> stringList = userRepo.findRoleName();
        System.out.println(stringList);
    }
}
