package com.spring.beebeta.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "Product")
public class Product extends Base{
    @Column(name = "Code")
    private String Code;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Description")
    private String Description;
    @OneToMany(mappedBy = "product")
    private Set<ProductImage> productImages = new HashSet<ProductImage>();
    @OneToMany(mappedBy = "product")
    private Set<ProductDetail> productDetails = new HashSet<ProductDetail>();
    @OneToMany(mappedBy = "product")
    private Set<Product_Voucher> product_vouchers = new HashSet<Product_Voucher>();

}
