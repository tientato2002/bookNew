package com.example.demo.service;

import com.example.demo.dto.PunishDTO;
import com.example.demo.entity.Book;
import com.example.demo.entity.Punish;
import com.example.demo.entity.User;
import com.example.demo.repository.BookRepo;
import com.example.demo.repository.PunishRepo;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PunishService {

    @Autowired
    PunishRepo punishRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    BookRepo bookRepo;
    public void  createPunish(PunishDTO punishDTO){
        User user = userRepo.findById(punishDTO.getUid()).orElseThrow(() ->new RuntimeException("user is valid"));
        Book book = bookRepo.findById(punishDTO.getBookIdl()).orElseThrow(() ->new RuntimeException("Book is valid"));
        Punish punish  = new Punish();
        punish.setTotalFine(punishDTO.getTotalFine());
        punish.setPayDate(punishDTO.getPayDate());
        punish.setUser(user);
        punish.setBook(book);
        punishRepo.save(punish);
    }
}
