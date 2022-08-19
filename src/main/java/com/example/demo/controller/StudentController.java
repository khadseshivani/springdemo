package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentService;

@RestController
public class StudentController 
{
	@Autowired
	private StudentService service;
	
	@GetMapping("/getStudents")
	public ResponseEntity<List<Student>> getAllStudents() 
	{
//	    try 
//	    {
	      List<Student> student = new ArrayList<Student>();
//	      if (name == null)
//	      {
	    	  service.findAll().forEach(student::add);
//	      }
//	      else if(student.isEmpty()) 
//	      {
//	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	      }
//	      
	      return new ResponseEntity<>(student, HttpStatus.OK);
//	    } 
//	    catch (Exception e) 
//	    {
//	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
	}
	
	@PostMapping("/addStudent")
	public ResponseEntity<String> addStudent(@RequestBody Student student) 
	{
	      service.save(new Student(student.getId(),student.getName(), student.getAge(), student.getPhone()));
	      return new ResponseEntity<>("Student Details Added Successfully.", HttpStatus.CREATED);
	   
//	      return new ResponseEntity<>("Unable to add student details", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) 
	{
		Student student = service.findById(id);
	    return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<String> updateTutorial(@PathVariable("id") int id, @RequestBody Student student) 
	{
	    Student st = service.findById(id);
	    if (st != null) 
	    {
	      st.setId(id);
	      st.setName(student.getName());
	      st.setAge(student.getAge());
	      st.setPhone(student.getPhone());
	      service.update(st);
	      return new ResponseEntity<>("Tutorial was updated successfully.", HttpStatus.OK);
	    } 
	    else 
	    {
	      return new ResponseEntity<>("Cannot find Tutorial with id=" + id, HttpStatus.NOT_FOUND);
	    }
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteTutorial(@PathVariable("id") int id) 
	{
	      service.deleteById(id);
	      return new ResponseEntity<>("Tutorial was deleted successfully.", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAllStudents() 
	{
	      int numRows = service.deleteAll();
	      return new ResponseEntity<>("Deleted " + numRows + " Tutorial(s) successfully.", HttpStatus.OK);  
	}
	    
}
