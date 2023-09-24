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
@Table(name = "BillHistory")
public class BillHistory extends Base{
    @Column(name = "Note")
    private String Note;
    @ManyToOne
    @JoinColumn(name = "IdOrder")
    @JsonBackReference
    private Bill bill;
}
