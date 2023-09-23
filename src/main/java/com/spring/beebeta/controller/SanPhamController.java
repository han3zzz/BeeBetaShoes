package com.spring.beebeta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/product")
public class SanPhamController {
    @GetMapping()
    public String index(){
        return "admin/sanpham/index.html";
    }
}
