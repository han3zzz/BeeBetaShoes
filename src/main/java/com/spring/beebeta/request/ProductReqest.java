package com.spring.beebeta.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ProductReqest {
    @NotBlank(message = "Mã không được bỏ trống !")
    private String Code;
    @NotBlank(message = "Tên không được bỏ trống !")
    private String Name;
    private String Description;
    private String CreateBy;
    private String UpdateBy;
}
