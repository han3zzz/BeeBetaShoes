package com.spring.beebeta.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "Bill")
public class Bill implements Serializable {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;
    @Column(name = "Code")
    private String Code;
    @Column(name = "PurchaseDate")
    private Timestamp PurchaseDate;
    @Column(name = "EstimatedDate")
    private Timestamp EstimatedDate;
    @Column(name = "PaymentDate")
    private Timestamp PaymentDate;
    @Column(name = "DelyveryDate")
    private Timestamp DelyveryDate;
    @Column(name = "TotalPrice")
    private BigDecimal TotalPrice;
    @Column(name = "ShipPrice")
    private BigDecimal ShipPrice;
    @Column(name = "TotalPriceLast")
    private BigDecimal TotalPriceLast;
    @Column(name = "Note")
    private String Note;
    @Column(name = "PayType")
    private Integer PayType;
    @Column(name = "PayStatus")
    private Integer PayStatus;
    @Column(name = "CodeGHN")
    private String CodeGHN;
    @Column(name = "IdCoupon")
    private Integer IdCoupon;
    @ManyToOne
    @JoinColumn(name = "IdAddress")
    @JsonBackReference
    private Address address;
    @ManyToOne
    @JoinColumn(name = "IdCustomer")
    @JsonBackReference
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "IdEmployee")
    @JsonBackReference
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "IdVoucher")
    @JsonBackReference
    private Voucher voucher;
    @OneToMany(mappedBy = "bill")
    private Set<BillDetail> billDetails = new HashSet<BillDetail>();
    @OneToMany(mappedBy = "bill")
    private Set<BillHistory> billHistories = new HashSet<BillHistory>();

}
