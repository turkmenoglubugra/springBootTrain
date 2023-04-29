package com.tr.springBootTrain.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
}
