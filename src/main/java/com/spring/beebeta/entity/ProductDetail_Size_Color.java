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
@Table(name = "ProductDetail_Color_Size")
public class ProductDetail_Size_Color implements Serializable {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;
    @ManyToOne
    @JoinColumn(name = "IdProductDetail")
    @JsonBackReference
    private ProductDetail productDetail;
    @ManyToOne
    @JoinColumn(name = "IdSize")
    @JsonBackReference
    private Size size;
    @ManyToOne
    @JoinColumn(name = "IdColor")
    @JsonBackReference
    private Color color;
}
