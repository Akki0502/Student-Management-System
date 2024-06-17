package com.StudentsManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.StudentsManagementSystem.entity.student;
import com.StudentsManagementSystem.service.StudentService;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private StudentService service;
	
	
	@GetMapping("/")
	public String home() {
		
		return "home";
	}
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		
		model.addAttribute("students", service.getAllStudents());
		return "students";	
	}
	
	@GetMapping("students/new")
	public String createStudentForm(Model model) {
		student student = new student();
		model.addAttribute("student", student);
		return "create-student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") student student) {
		
		
		service.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		model.addAttribute("student", service.getById(id));
		
		return "edit_student";
		
	}
	
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") student student) {
		student ExistingStudent=service.getById(id);
		ExistingStudent.setFirstName(student.getFirstName());
		ExistingStudent.setLastName(student.getLastName());
		ExistingStudent.setEmail(student.getEmail());
		
		service.saveStudent(ExistingStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String  deleteById(@PathVariable int id) {
		
		
		service.deleteById(id);
		
		return "redirect:/students";
	}
	
	
	
	
	
	
	

}
