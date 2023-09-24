package com.spring.beebeta.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "ProductImage")
public class ProductImage extends Base{
    @Column(name = "Url")
   private String Url;
    @Column(name = "MainImage")
   private Boolean MainImage;
    @ManyToOne
    @JoinColumn(name = "IdProduct")
    @JsonBackReference
    private Product product;

}
