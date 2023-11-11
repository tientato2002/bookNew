package com.example.demo.service;


import com.example.demo.dto.InvoiceBookDTO;
import com.example.demo.dto.InvoiceDTO;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
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

    @Autowired
    PunishRepo punishRepo;

//    @Autowired
//    BookRepo bookRepo;

    @Autowired
    InvoiceBookRepo invoiceBookRepo;
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

    public void payBook(InvoiceDTO invoiceDTO){

        // neu muôn lam toi uu thì phai de l set hoac map
        List<Integer> brrowBooks = userRepo.findBookName(invoiceDTO.getUser().getId());
        // kierm tra xem nhung cuon sach may tra co dung nhung cuon sach m con muon dung k ?

        for(InvoiceBookDTO invoiceBookDTO : invoiceDTO.getInvoiceBookDTOList()){
            for(int i = 0 ; i < brrowBooks.size(); i++)
            {
                // neu no tim duoc dung quyen sach da muon
                if(invoiceBookDTO.getBook().getId() == brrowBooks.get(i)){
                   InvoiceBook invoiceBook =new InvoiceBook();
                   invoiceBook.setStatus("trả");
                   invoiceBook.setReturnDate(invoiceBookDTO.getReturnDate());
                   invoiceBookRepo.save(invoiceBook);

                }
            }
        }

    }
}
