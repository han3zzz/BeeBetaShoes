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
@Table(name = "Role")
public class Role extends Base{
    @Column(name = "Name")
    private String Name;
    @OneToMany(mappedBy = "role")
    private Set<Employee> employees = new HashSet<Employee>();
}
