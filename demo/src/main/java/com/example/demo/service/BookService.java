package com.example.demo.service;

import com.example.demo.dto.BookDTO;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;
    @Transactional
    public void create(BookDTO bookDTO) {
        System.out.println(bookDTO);
        Book book = new ModelMapper().map(bookDTO, Book.class);
        System.out.println(book);
        bookRepo.save(book);
        }
    }


