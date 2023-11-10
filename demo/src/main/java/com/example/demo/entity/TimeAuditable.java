package com.example.demo.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.util.Date;

public class TimeAuditable {

    @CreatedDate // auto gen new date
    @Column(updatable = false)
    private Date createdAt;// java.util

    @LastModifiedDate
    private Date updatedAt;
}
