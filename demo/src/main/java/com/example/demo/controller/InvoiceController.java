package com.example.demo.controller;

import com.example.demo.dto.InvoiceDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService ;
    @PostMapping("/")
    public ResponseDTO<Void> createNewJson(@RequestBody @Valid InvoiceDTO invoiceDTO) {
       invoiceService.create(invoiceDTO);
        return ResponseDTO.<Void>builder()
                .status(200)
                .msg("create succesful")
                .build();
    }

}
