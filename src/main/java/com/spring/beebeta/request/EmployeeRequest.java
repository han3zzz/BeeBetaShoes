package com.spring.beebeta.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmployeeRequest {

    private String Code;
    private String Fullname;
    private String Username;
    private String Password;
    private String Image;
    private Boolean Gender;
    private String Phone;
    private String Email;

}
