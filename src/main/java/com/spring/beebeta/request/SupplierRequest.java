package com.spring.beebeta.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierRequest {
    private String Name;
    private String Phone;
    private String Address;
    private String Agree;
    private Integer IdProductDetail;
}
