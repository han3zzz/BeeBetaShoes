package com.spring.beebeta.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Voucher")
public class Voucher implements Serializable {
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
    @Column(name = "TypeVoucher")
    private Boolean TypeVoucher;
    @Column(name = "IsVoucher")
    private Boolean IsVoucher;
    @Column(name = "Discount")
    private Integer Discount;
    @Column(name = "Cash")
    private BigDecimal Cash;
    @Column(name = "StartDate")
    private Timestamp StartDate;
    @Column(name = "EndDate")
    private Timestamp EndDate;
    @OneToMany(mappedBy = "voucher")
    private Set<Product_Voucher> product_vouchers = new HashSet<Product_Voucher>();
    @OneToMany(mappedBy = "voucher")
    private Set<Bill> bills = new HashSet<Bill>();
}
