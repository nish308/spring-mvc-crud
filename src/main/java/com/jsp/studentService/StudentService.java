package com.jsp.studentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.student.Student;
import com.jsp.studentDao.StudentDao;

@Component
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}
	
	public List<Student> getAllStudents(){
		return studentDao.getAllStudents();
	}
	
	public boolean deleteStudentById(int id) {
		return studentDao.deleteStudentById(id);
	}
	
	public Student updateById(int id, Student student) {
		Student s = studentDao.getStudentById(id);
		s.setName(student.getName());
		s.setEmail(student.getEmail());
		return studentDao.updateById(s);
	}
}
