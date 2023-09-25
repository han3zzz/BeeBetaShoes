package com.spring.beebeta.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Customer")
public class Customer implements Serializable {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;
    @Column(name = "CreateDate")
    private Timestamp CreateDate;
    @Column(name = "UpdateDate")
    private Timestamp UpdateDate;
    @Column(name = "CreateBy")
    private String CreateBy;
    @Column(name = "UpdateBy")
    private String UpdateBy;
    @Column(name = "Status")
    private Integer Status;
    @Column(name = "Code")
    private String Code;
    @Column(name = "Fullname")
    private String Fullname;
    @Column(name = "Username")
    private String Username;
    @Column(name = "Password")
    private String Password;
    @Column(name = "Image")
    private String Image;
    @Column(name = "Gender")
    private Boolean Gender;
    @Column(name = "Phone")
    private String Phone;
    @Column(name = "Email")
    private String Email;
    @OneToMany(mappedBy = "customer")
    private Set<Coupon> coupons = new HashSet<Coupon>();
    @OneToMany(mappedBy = "customer")
    private Set<Address> addresses = new HashSet<Address>();
    @OneToMany(mappedBy = "customer")
    private Set<Bill> bills = new HashSet<Bill>();
    @OneToMany(mappedBy = "customer")
    private Set<RetunExchange> retunExchanges = new HashSet<RetunExchange>();

}
