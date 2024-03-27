package com.fpoly.lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fpoly.lab3.model.Students2;

@Controller
public class StudentController2 {
    @GetMapping("/validateForm/form")
    public String validate(Model model) {
        Students2 student = new Students2();
        model.addAttribute("sv", student);
        return "validate/form";
    }

    @PostMapping("/validateForm/validate")
    public String save(Model model, @Validated @ModelAttribute("sv") Students2 form, Errors errors) {
        if (errors.hasErrors()) {
            System.out.println("abc");
            model.addAttribute("message", "Không hợp lệ");
            return "validate/form";
        }
        return "validate/success";
    }
}
