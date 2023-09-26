package com.spring.beebeta.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class ProductDetailRequest {
    private Double Weight;
    private BigDecimal Price;
    private Integer Discount;
    private String Description;
    private String CreateBy;
    private String UpdateBy;
    private Integer IdProduct;
    private Integer IdBrand;
    private Integer IdToe;
    private Integer IdCategory;
    private Integer IdSole;
    private Integer IdHeelcushion;
    private Integer IdDesign;
    private Integer IdShoelace;
}
