package com.example.demo.dto;

import com.example.demo.entity.Book;
import com.example.demo.entity.Invoice;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class InvoiceBookDTO {
    private int itemId ;
    private BookDTO book ;
    private InvoiceDTO invoice ;
    private String status ;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "Asia/Ho_Chi_Minh")
    private Date duedate ;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "Asia/Ho_Chi_Minh")
    private Date returnDate ;
}
