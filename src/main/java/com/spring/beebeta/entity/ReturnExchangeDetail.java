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
@Table(name = "ReturnExchangeDetail")
public class ReturnExchangeDetail {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;
    @ManyToOne
    @JoinColumn(name = "IdReturnExchange")
    @JsonBackReference
    private RetunExchange retunExchange;
    @ManyToOne
    @JoinColumn(name = "IdOrderDetail")
    @JsonBackReference
    private BillDetail billDetail;
}
