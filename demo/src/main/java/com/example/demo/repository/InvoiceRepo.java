package com.example.demo.repository;

import com.example.demo.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepo extends JpaRepository<Invoice,Integer> {
}
