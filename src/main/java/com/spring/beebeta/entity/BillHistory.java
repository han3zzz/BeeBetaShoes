package com.spring.beebeta.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BillHistory")
public class BillHistory implements Serializable {
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
    @Column(name = "Note")
    private String Note;
    @ManyToOne
    @JoinColumn(name = "IdOrder")
    @JsonBackReference
    private Bill bill;
}
