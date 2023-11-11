package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PunishDTO {

    private Long id;
    private Date payDate;
    private Double totalFine;
    private Integer uid;
    private Integer bookIdl;

}
