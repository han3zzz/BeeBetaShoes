package com.spring.beebeta.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RetunExchange")
public class RetunExchange implements Serializable {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;
    @Column(name = "CreateDate")
    private Timestamp CreateDate;
    @Column(name = "UpdateDate")
    private Timestamp UpdateDate;
    @Column(name = "CreateBy")
    private String CreateBy;
    @Column(name = "UpdateBy")
    private String UpdateBy;
    @Column(name = "Status")
    private Integer Status;
    @Column(name = "Code")
    private String Code;
    @Column(name = "Image")
    private String Image;
    @Column(name = "RequestDate")
    private Timestamp RequestDate;
    @Column(name = "ProcessingDate")
    private Timestamp ProcessingDate;
    @Column(name = "IsReturnExchange")
    private Boolean IsReturnExchange;
    @ManyToOne
    @JoinColumn(name = "IdCustomer")
    @JsonBackReference
    private Customer customer;

}
