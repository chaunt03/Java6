package com.fpoly.lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.lab3.model.Students;
import com.fpoly.lab3.model.Students2;

@Controller
public class StrudentController {

    @RequestMapping("/student/form")
    public String form(Model model) {
        Students student = new Students();
        model.addAttribute("sv", student);
        return "student/form";
    }

    @RequestMapping("/student/save")
    public String save(@ModelAttribute("sv") Students form) {
        return "student/success";
    }

}
