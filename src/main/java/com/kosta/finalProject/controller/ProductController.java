package com.kosta.finalProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kosta.finalProject.model.Product;
import com.kosta.finalProject.model.ProductModel;

@Controller
@RequestMapping(value = { "", "product" })
public class ProductController {

    @GetMapping("/bot")
    public String index(Model model) {
        ProductModel productModel = new ProductModel();
        model.addAttribute("products", productModel.findAll());
        for(Product p:productModel.findAll()) {
        	System.out.println("product : "+p.getPhoto());
        }
        
        return "/bot";
    }

}
