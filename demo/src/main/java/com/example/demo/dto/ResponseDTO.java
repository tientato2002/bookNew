package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> {
    private int status;
    private String msg;
    private T data;
    public ResponseDTO(int status, String msg) {
        super();
        this.status = status;
        this.msg = msg;
    }

}