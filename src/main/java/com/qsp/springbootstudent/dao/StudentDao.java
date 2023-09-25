package com.qsp.springbootstudent.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springbootstudent.dto.Student;
import com.qsp.springbootstudent.repo.StudentRepo;

@Repository
public class StudentDao {
	
	@Autowired
	private StudentRepo repo;
	
	
	public Student saveStudent(Student student) {
		
		return repo.save(student);
		
	}
	
	public Student findStudent(int id) {
		
		Optional<Student> optional=repo.findById(id);
		if(optional.isPresent()) {
			
			return optional.get();
			
		}
		return null;
		
	}
	public List<Student> findAllStudent() {
		return repo.findAll();
	}
	
	public Student deleteStudent(int id) {
		Optional<Student> optional=repo.findById(id);
		if(optional.isPresent()) {
			repo.deleteById(id);
			return optional.get();
		}
		return null;
		
	}
	
	public Student updateStudent(int id, Student student) {
		Optional<Student> optional=repo.findById(id);
		if(optional.isPresent()) {
			student.setId(id);
			return repo.save(student);
			
		}
		else {
			return null;
		}
		
	}
	
	public Student findByEmail(String email) {
		return repo.findStudentByEmail(email);
	}
	
	public Student findByPhone(long phone) {
		return repo.findStudentByPhone(phone);
	}
	
	public List<Student> findByGrade(String grade){
		return repo.findStudentByGrade(grade);
		
	}
	public List<Student> findByPercentage(double percentage){
		return repo.findStudentByPercentage(percentage);
	}
	public List<Student> findByAddress(String address){
		return repo.findStudentByAddress(address);
	}
	public List<Student> findGreaterThanPercentage(double percentage){
		return repo.findStudentByPercentageGreaterThan(percentage);
	}
	public List<Student> findLessThanPercentage(double percentage){
		return repo.findStudentByPercentageLessThan(percentage);
	}

	public List<Student> findGreaterThanage(int age){
		return repo.findStudentByAgeGreaterThan(age);
	}
	public List<Student> findLessThanage(int age){
		
		return repo.findStudentByAgeLessThan(age);
	}

}
