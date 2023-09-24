package com.spring.beebeta.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

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
@Table(name = "Voucher")
public class Voucher extends Base{
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
