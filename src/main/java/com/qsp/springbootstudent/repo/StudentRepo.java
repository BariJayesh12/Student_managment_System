package com.qsp.springbootstudent.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springbootstudent.dto.Student;

public interface StudentRepo extends JpaRepository<Student , Integer> {
	
	Student findStudentByEmail(String email);
	Student findStudentByPhone(long phone);
	List<Student> findStudentByGrade(String grade);
	List<Student> findStudentByPercentage(double percentage);
	List<Student> findStudentByPercentageGreaterThan(double percentage);
	List<Student> findStudentByPercentageLessThan(double percentage);
	List<Student> findStudentByAddress(String address);
	List<Student> findStudentByAgeLessThan(int age);
	List<Student> findStudentByAgeGreaterThan(int age);
	
	

}
