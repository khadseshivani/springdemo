package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentService;

@Service
public class StudentImpl implements StudentService
{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public StudentImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int save(Student student) 
	{
		return jdbcTemplate.update("INSERT INTO management(id,name,age,phone) VALUES(?,?,?,?)",
		        new Object[] {student.getId() ,student.getName(), student.getAge(), student.getPhone() });
	}

	@Override
	public int update(Student student) 
	{
		return jdbcTemplate.update("UPDATE management SET name=?, age=?, phone=? WHERE id=?",
		        new Object[] { student.getName(), student.getAge(), student.getPhone(), student.getId() });	
		
	}

	@Override
	public Student findById(int id) 
	{
		try 
		{
		      Student student = jdbcTemplate.queryForObject("SELECT * FROM management WHERE id=?",
		          new StudentMapper(), id);
		      return student;
		    } 
		catch (Exception e) {
		      return null;
		    }
	}

	@Override
	public int deleteById(int id) 
	{
	    return jdbcTemplate.update("DELETE FROM management WHERE id=?", id);

	}

	@Override
	public List<Student> findAll() 
	{
	    return jdbcTemplate.query("SELECT * from management", new StudentMapper());

	}

	@Override
	public int deleteAll() 
	{
	    return jdbcTemplate.update("DELETE from management");
	}

	
}
