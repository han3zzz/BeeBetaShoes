package com.spring.beebeta.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "Address")
public class Address extends Base{
    private String Fullname;
    private String Phone;
    private String Address;
    private String CityName;
    private String DistrictName;
    private String WardName;
    private Integer CityId;
    private Integer DistrictId;
    private Integer WardId;
    @ManyToOne
    @JoinColumn(name = "IdCustomer")
    @JsonBackReference
    private Customer customer;
    @OneToMany(mappedBy = "address")
    private Set<Bill> bills = new HashSet<Bill>();
}
