package com.fpoly.lab3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.lab3.DAO.StudentsDAO;
import com.fpoly.lab3.model.StudentMAP;
import com.fpoly.lab3.model.Students;

@Controller
public class StudentController3 {
	@Autowired
	StudentsDAO dao;
	
	@RequestMapping("/student/index")
	public String index(Model model) {
		Students student = new Students("", "", 0.0, true, "VN");
		model.addAttribute("form", student);
		StudentMAP map = dao.findAll();
		model.addAttribute("items", map);
		return "rest/index";
	}
	
	@RequestMapping("/student/edit/{key}")
	public String edit(Model model, @PathVariable("key") String key) {
		model.addAttribute("key", key);
		Students student = dao.findByKey(key);
		model.addAttribute("form", student);
		StudentMAP map = dao.findAll();
		model.addAttribute("items", map);
		return "rest/index";
	}
	
	@RequestMapping("/student/create")
	public String create(Students student) {
		dao.create(student);
		return "redirect:/student/index";
	}
	
	@RequestMapping("/student/update/{key}")
	public String update(@PathVariable("key") String key, Students student) {
		dao.update(key, student);
		return "redirect:/student/edit/" + key;
	}
	
	@RequestMapping("/student/delete/{key}")
	public String delete(@PathVariable("key") String key) {
		dao.delete(key);
		return "redirect:/student/index";
	}
}
