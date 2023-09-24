package com.spring.beebeta.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "RetunExchange")
public class RetunExchange extends Base {
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
