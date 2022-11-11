package com.batm.Day2.controllers;

import com.batm.Day2.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/category")
public class CategoryController {
    // instance object dari Service
    @Autowired
    private CategoryService categoryService;

    // get all
    @GetMapping
    public String categoryIndex(Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        return "category/category-index";
    }

    // form save
    // save
    // delete
}
