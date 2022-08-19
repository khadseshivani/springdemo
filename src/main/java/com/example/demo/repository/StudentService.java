package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService 
{
	int save(Student student);
	int update(Student student);
	Student findById(int id);
	int deleteById(int id);
	List<Student> findAll();
	int deleteAll();
}
