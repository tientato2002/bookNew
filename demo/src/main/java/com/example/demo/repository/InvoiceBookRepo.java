package com.example.demo.repository;

import com.example.demo.entity.InvoiceBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceBookRepo extends JpaRepository<InvoiceBook,Integer> {
}
