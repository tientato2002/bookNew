package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class InvoiceBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer item_id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Invoice invoice;

     private String status ;
    @Temporal(TemporalType.DATE)
    private Date returnDate ;

    @Temporal(TemporalType.DATE)
    private Date dueDate ;

}
