package com.spring.beebeta.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "Product_Voucher")
public class Product_Voucher implements Serializable {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;
    @ManyToOne
    @JoinColumn(name = "IdVoucher")
    @JsonBackReference
    private Voucher voucher;
    @ManyToOne
    @JoinColumn(name = "IdProduct")
    @JsonBackReference
    private Product product;
}
