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
@Table(name = "Employee")
public class Employee extends Base{
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
    @ManyToOne
    @JoinColumn(name = "IdRole")
    @JsonBackReference
    private Role role;
    @OneToMany(mappedBy = "employee")
    private Set<Bill> bills = new HashSet<Bill>();
}
