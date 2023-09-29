package com.spring.beebeta.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class ValidateForm {
    @NotBlank(message = "Mã không được bỏ trống !")
    @Size(max = 30,message = "Mã có độ dài nhỏ hơn hoặc bằng 30 kí tự")
    private String Code;
    @NotBlank(message = "Tên không được bỏ trống !")
    @Size(max = 100,message = "Tên có độ dài nhỏ hơn hoặc bằng 100 kí tự")
    private String Name;
    @NotBlank(message = "Giá không được bỏ trống !")
    private String Price;
    @NotBlank(message = "Trọng lượng không được bỏ trống !")
    private String Weight;
    @NotBlank(message = "Giảm giá không được bỏ trống !")
    @Pattern(regexp = "^[0-9]\\d*$",message = "Giảm giá phải là số nguyên dương !")
    @Pattern(regexp = "^(?:100|[0-9]|[1-9]\\d)$",message = "Giảm giá trong khoảng từ 0 đến 100 !")
    private String Discount;
    @Size(max = 255,message = "Mô tả có độ dài nhỏ hơn hoặc bằng 255 kí tự")
    private String Description;

}
