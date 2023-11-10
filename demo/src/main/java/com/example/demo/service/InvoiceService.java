package com.example.demo.service;


import com.example.demo.dto.InvoiceBookDTO;
import com.example.demo.dto.InvoiceDTO;
import com.example.demo.entity.Book;
import com.example.demo.entity.Invoice;
import com.example.demo.entity.InvoiceBook;
import com.example.demo.entity.User;
import com.example.demo.repository.BookRepo;
import com.example.demo.repository.InvoiceRepo;
import com.example.demo.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;


@Service
public class InvoiceService {
    @Autowired
    BookRepo bookRepo ;
    @Autowired
    UserRepo userRepo ;
    @Autowired
    InvoiceRepo invoiceRepo;
    @Transactional
    public void create(InvoiceDTO invoiceDTO) {
        Invoice invoice  = new Invoice() ;
        User user = userRepo.findById(invoiceDTO.getUser().getId()).orElseThrow(NoResultException::new);
        invoice.setUser(user);
        invoice.setBorrowingDate(invoiceDTO.getBorrowingDate());
        List<InvoiceBook>invoiceBookList  = new ArrayList<>();
        for(InvoiceBookDTO i : invoiceDTO.getInvoiceBookDTOList()){
            InvoiceBook invoiceBook = new InvoiceBook();
            invoiceBook.setBook(bookRepo.findById(i.getBook().getId()).orElseThrow(NoResultException::new));
            invoiceBook.setInvoice(invoice);
            invoiceBook.setStatus(i.getStatus());
            invoiceBook.setDueDate(i.getDuedate());
            invoiceBookList.add(invoiceBook);
        }
        invoice.setInvoiceBook(invoiceBookList);
        invoiceRepo.save(invoice);
    }

}
