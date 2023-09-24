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
@Table(name = "Material")
public class Material extends Base{
    @Column(name = "Name")
    private String Name;
    @Column(name = "Description")
    private String Description;
    @OneToMany(mappedBy = "material")
    private Set<ProductDetail_Material> productDetail_materials = new HashSet<ProductDetail_Material>();
}
