package com.example.taxes.controller;

import com.example.taxes.model.Product;
import com.example.taxes.model.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class MvcController {

    @RequestMapping("/")
    public String showIndex(Model model, HttpSession session) {

        ArrayList<Product> products = ProductRepository.getInstance().getProducts();
        session.setAttribute("products", products);

        Product product = new Product();
        model.addAttribute("newproduct", product);

        return "index";
    }

    @PostMapping("/addnew")
    public String addnew(@ModelAttribute("newproduct") Product product, HttpSession session) {
        ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");
        products.add(product);

        return "index";
    }

}