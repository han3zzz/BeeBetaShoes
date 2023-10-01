package com.spring.beebeta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/category")
public class DanhMucController {

    @GetMapping("/view")
    public String index(){
        return "admin/danhmuc/index.html";
    }
}
