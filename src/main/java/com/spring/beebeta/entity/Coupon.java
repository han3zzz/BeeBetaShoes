package com.spring.beebeta.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "Coupon")
public class Coupon extends Base{
    @Column(name = "Code")
    private String Code;
    @Column(name = "Name")
    private String Name;
    @Column(name = "IsType")
    private Integer IsType;
    @Column(name = "Discount")
    private Integer Discount;
    @Column(name = "Cash")
    private BigDecimal Cash;
    @ManyToOne
    @JoinColumn(name = "IdCustomer")
    @JsonBackReference
    private Customer customer;

}
