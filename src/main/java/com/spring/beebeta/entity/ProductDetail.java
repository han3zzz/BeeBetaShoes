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
@Table(name = "ProductDetail")
public class ProductDetail extends Base{
    @Column(name = "EntryPrice")
    private BigDecimal EntryPrice;
    @Column(name = "Price")
    private BigDecimal Price;
    @Column(name = "Discount")
    private Integer Discount;
    @Column(name = "Description")
    private String Description;
    @ManyToOne
    @JoinColumn(name = "IdProduct")
    @JsonBackReference
    private Product product;
    @ManyToOne
    @JoinColumn(name = "IdBrand")
    @JsonBackReference
    private Brand brand;
    @ManyToOne
    @JoinColumn(name = "IdToe")
    @JsonBackReference
    private Toe toe;
    @ManyToOne
    @JoinColumn(name = "IdShoelace")
    @JsonBackReference
    private Shoelace shoelace;
    @ManyToOne
    @JoinColumn(name = "IdCategory")
    @JsonBackReference
    private Category category;
    @ManyToOne
    @JoinColumn(name = "IdHeelcushion")
    @JsonBackReference
    private Heelcushion heelcushion;
    @ManyToOne
    @JoinColumn(name = "IdSole")
    @JsonBackReference
    private Sole sole;
    @ManyToOne
    @JoinColumn(name = "IdDesign")
    @JsonBackReference
    private Design design;
    @OneToMany(mappedBy = "productDetail")
    private Set<ProductFault> productFaults = new HashSet<ProductFault>();
    @OneToMany(mappedBy = "productDetail")
    private Set<ProductDetail_Material> productDetail_materials = new HashSet<ProductDetail_Material>();
    @OneToMany(mappedBy = "productDetail")
    private Set<ProductDetail_Size_Color> productDetail_size_colors = new HashSet<ProductDetail_Size_Color>();
    @OneToMany(mappedBy = "productDetail")
    private Set<BillDetail> billDetails = new HashSet<BillDetail>();
    @OneToMany(mappedBy = "productDetail")
    private Set<CartDetail> cartDetails = new HashSet<CartDetail>();

}
