package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class BookDTO {

    private Integer id;

    private String name;

    private String avatar;

    private String author;

    private String code ;

    @JsonIgnore
    private MultipartFile file;
    private int amount ;
}
