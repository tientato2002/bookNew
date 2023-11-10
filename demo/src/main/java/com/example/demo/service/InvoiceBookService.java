package com.example.demo.service;
import com.example.demo.dto.InvoiceBookDTO;
import com.example.demo.entity.InvoiceBook;
import com.example.demo.repository.InvoiceBookRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceBookService {
    @Autowired
    InvoiceBookRepo invoiceBookRepo;
    public void create(InvoiceBookDTO invoiceBookDTO) {
        System.out.println(invoiceBookDTO);
        InvoiceBook invoiceBook = new ModelMapper().map(invoiceBookDTO, InvoiceBook.class);
      invoiceBookRepo.save(invoiceBook);
    }
}
