package com.spring.beebeta.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "BillDetail")
public class BillDetail implements Serializable {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;
    @Column(name = "UnitPrice")
    private BigDecimal UnitPrice;
    @Column(name = "Quantity")
    private Integer Quantity;
    @Column(name = "IdColor")
    private Integer IdColor;
    @Column(name = "IdSize")
    private Integer IdSize;
    @ManyToOne
    @JoinColumn(name = "IdOrder")
    @JsonBackReference
    private Bill bill;
    @ManyToOne
    @JoinColumn(name = "IdProductDetail")
    @JsonBackReference
    private ProductDetail productDetail;
}
