package com.example.demo.controller;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService ;
    @PostMapping("/")
    public ResponseDTO<Void> newUser(
            @ModelAttribute @Valid BookDTO bookDTO)
            throws IllegalStateException, IOException {

        if (!bookDTO.getFile().isEmpty()) {
            // ten file upload
            String filename = bookDTO.getFile().getOriginalFilename();
            // luu lai file vao o cung may chu
            File saveFile = new File("F:/" + filename);
            bookDTO.getFile().transferTo(saveFile);
            // lay ten file luu xuong database
            bookDTO.setAvatar(filename);
        }
        bookService.create(bookDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("create succesful")
                .build();
    }
}
