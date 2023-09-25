package com.spring.beebeta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/admin/products")
public class SanPhamController {
    @GetMapping("/view")
    public String index(){
            return "admin/sanpham/index.html";
        }
    @GetMapping("/add")
    public String add(){
        return "admin/sanpham/add.html";
    }
    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") Integer id){
        model.addAttribute("id",id);
        return "admin/sanpham/update.html";
    }


}
