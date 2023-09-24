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
@Table(name = "ProductDetail_Material")
public class ProductDetail_Material implements Serializable {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;
    @ManyToOne
    @JoinColumn(name = "IdProductDetail")
    @JsonBackReference
    private ProductDetail productDetail;
    @ManyToOne
    @JoinColumn(name = "IdMaterial")
    @JsonBackReference
    private Material material;
}
