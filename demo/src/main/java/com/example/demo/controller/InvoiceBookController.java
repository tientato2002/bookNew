package com.example.demo.controller;

import com.example.demo.dto.InvoiceBookDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.RoleDTO;
import com.example.demo.service.InvoiceBookService;
import com.example.demo.service.InvoiceService;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/invoiceBook")
public class InvoiceBookController {
    @Autowired
    InvoiceBookService invoiceBookService ;
    @PostMapping("/")
    public ResponseDTO<Void> createNewJson(@RequestBody @Valid InvoiceBookDTO invoiceBookDTO) {
        invoiceBookService.create(invoiceBookDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("create succesful")
                .build();
    }
}
