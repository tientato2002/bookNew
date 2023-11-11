package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    private String avatar;
    private String author;
    @Column(unique = true)
    private String code ;
    private int amount ;
    private boolean status;
    @OneToMany(mappedBy = "book")
    private List<InvoiceBook> invoiceBookList ;

    @OneToOne(mappedBy = "book")
    private Punish punish;
}
