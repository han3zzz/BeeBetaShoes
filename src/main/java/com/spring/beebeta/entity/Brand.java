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
@Table(name = "Brand")
public class Brand extends Base{
    @Column(name = "Name")
    private String Name;
    @Column(name = "Description")
    private String Description;
    @OneToMany(mappedBy = "brand")
    private Set<ProductDetail> productDetails = new HashSet<ProductDetail>();
}
