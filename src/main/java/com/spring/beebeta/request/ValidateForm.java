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
    @NotBlank(message = "Giá bán không được bỏ trống !")
    @Pattern(regexp = "^(?!0)([1-9]\\d{0,7}(?:\\.\\d{1,2})?|99999999(?:\\.0{1,2})?)$",message = "Giá bán phải là số lớn hơn 0 và nhỏ hơn 99,999,999 !")
    private String Price;
    @NotBlank(message = "Trọng lượng không được bỏ trống !")
    @Pattern(regexp = "^(?!0+(\\.0{1,2})?$)(3000(\\.0{1,2})?|[1-9]\\d{0,2}(\\.\\d{1,2})?)$",message = "Trọng lượng phải là số lớn hơn 0 và nhỏ hơn 3000 !")
    private String Weight;
    @NotBlank(message = "Giảm giá không được bỏ trống !")
    @Pattern(regexp = "^[0-9]\\d*$",message = "Giảm giá phải là số nguyên dương !")
    @Pattern(regexp = "^(?:100|[0-9]|[1-9]\\d)$",message = "Giảm giá trong khoảng từ 0 đến 100 !")
    private String Discount;
    @Size(max = 255,message = "Mô tả có độ dài nhỏ hơn hoặc bằng 255 kí tự")
    private String Description;

}