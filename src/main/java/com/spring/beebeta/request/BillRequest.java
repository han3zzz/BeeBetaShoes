package com.spring.beebeta.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BillRequest {
    private BigDecimal TotalPrice;
    private BigDecimal ShipPrice;
    private BigDecimal TotalPriceLast;
    private String Note;
    private Integer PayType;
    private Integer PayStatus;
    private Integer IdCoupon;
    private Integer IdAddress;
    private Integer IdCustomer;
    private Integer Status;

}
