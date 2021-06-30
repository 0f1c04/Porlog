package com.kosta.finalProject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.finalProject.model.Item;
import com.kosta.finalProject.model.ProductModel;

@RestController
@RequestMapping(value = "cart")
public class CartController {
	
    private int isExist(String id, HttpSession session) {
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
    
    //세션과 DB에 같이 저장?
    
    @ResponseBody
    @GetMapping("buy/{id}")
    public List<Item> buy(@PathVariable(value = "id") String id, HttpSession session) {
    	System.out.println("buy들어옴!!! 아이디 : " + id);
        ProductModel productModel = new ProductModel();
        if (session.getAttribute("cart") == null) {
            List<Item> cart = new ArrayList<Item>();
            cart.add(new Item(productModel.find(id), 1));
            session.setAttribute("cart", cart);
        } else {
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int index = this.isExist(id, session);
            if (index != -1) {
                cart.get(index).setQuantity(cart.get(index).getQuantity() + 1);
            }
            else {
                cart.add(new Item(productModel.find(id), 1));
            }
            session.setAttribute("cart", cart);
        }
        return (List<Item>) session.getAttribute("cart");
    }
    
    @ResponseBody
    @GetMapping("delete/{id}")
    public List<Item> delete(@PathVariable(value = "id") String id, HttpSession session) {
    	System.out.println("들어온ID : " + id);
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int index = isExist(id, session);
        cart.remove(index);
        System.out.println(cart);
        session.setAttribute("cart", cart);
        return (List<Item>) session.getAttribute("cart");
    }

}



