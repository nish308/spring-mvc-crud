package com.jsp.studentController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.student.Student;
import com.jsp.studentService.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/createstudent")
	public ModelAndView createStudent() {
		ModelAndView modelAndView = new ModelAndView("studentform.jsp");
		modelAndView.addObject("student1", new Student());
		return modelAndView;
	}
	
	@RequestMapping("/studentadd")
	public ModelAndView studentAdd(@ModelAttribute Student student) {
		ModelAndView modelAndView = new ModelAndView("home.jsp");
		studentService.saveStudent(student);
		modelAndView.addObject("saved", student.getName()+" has been saved");
		return modelAndView;
	}
	
	@RequestMapping("/viewall")
	public ModelAndView getAllStudents() {
		ModelAndView modelAndView = new ModelAndView("viewall.jsp");
		List<Student> students = studentService.getAllStudents();
		modelAndView.addObject("students", students);
		return modelAndView;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteStudentById(@RequestParam(name = "id") int id) {
		ModelAndView modelAndView = new ModelAndView("home.jsp");
		boolean res = studentService.deleteStudentById(id);
		modelAndView.addObject("saved", "Student Deleted " +id);
		return modelAndView;
	}
	
	@RequestMapping("/update")
	public ModelAndView updateById() {
		ModelAndView modelAndView = new ModelAndView("updateform.jsp");
		modelAndView.addObject("studentupdate", new Student());
		return modelAndView;		
	}
	
	@RequestMapping("/updateStudent")
	public ModelAndView finalUpdate(@ModelAttribute Student student) {
		ModelAndView modelAndView = new ModelAndView("home.jsp");
		studentService.updateById(student.getId(), student);
		modelAndView.addObject("saved", student.getId()+ " has been updated");
		return modelAndView;
	}
}
