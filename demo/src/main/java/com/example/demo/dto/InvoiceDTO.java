package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class InvoiceDTO {
    private UserDTO user;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "Asia/Ho_Chi_Minh")
    private Date borrowingDate ;
    private List<InvoiceBookDTO> invoiceBookDTOList;
}
