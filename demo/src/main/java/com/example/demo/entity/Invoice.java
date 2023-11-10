package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private User user;
    @Temporal(TemporalType.DATE)
    private Date borrowingDate ;
    @OneToMany(mappedBy = "invoice",cascade = CascadeType.ALL )
    private List<InvoiceBook> invoiceBook ;
}
