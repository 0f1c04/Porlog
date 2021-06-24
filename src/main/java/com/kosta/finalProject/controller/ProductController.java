package com.kosta.finalProject.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kosta.finalProject.model.Product;
import com.kosta.finalProject.model.ProductModel;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

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
