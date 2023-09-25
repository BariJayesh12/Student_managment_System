package com.qsp.springbootstudent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springbootstudent.Exception.EmailNotFound;
import com.qsp.springbootstudent.Exception.EmptyListFound;
import com.qsp.springbootstudent.Exception.IdNotFound;
import com.qsp.springbootstudent.Exception.MaxSecuredMarksFound;
import com.qsp.springbootstudent.Exception.PhoneNotFound;
import com.qsp.springbootstudent.dao.StudentDao;
import com.qsp.springbootstudent.dto.Student;
import com.qsp.springbootstudent.util.ResponseStructure;

@Service
public class StudentService {

	@Autowired
	private StudentDao dao;

	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student) {
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		int totalmarks = student.getTotalmarks();
		int securedmarks = student.getSecuredmarks();
		if (totalmarks > securedmarks) {

			double percentage1 = ((double) securedmarks / totalmarks) * 100;
			student.setPercentage(percentage1);

			if (percentage1 < 35) {
				student.setGrade("Fail");
			} else if (percentage1 >= 35 && percentage1 < 50) {
				student.setGrade("Pass");
			} else if (percentage1 >= 50 && percentage1 < 65) {
				student.setGrade("Second Class");
			} else if (percentage1 >= 65 && percentage1 < 90) {
				student.setGrade("first Class");
			} else {
				student.setGrade("Distinction");
			}

			structure.setMessage("Saved Successfull");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.saveStudent(student));

			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.CREATED);

		} else {
			throw new MaxSecuredMarksFound("Secured Marks Are Greater then total Marks");
		}

		// return structure;
	}

	public ResponseEntity<ResponseStructure<Student>> updateStudent(int id, Student student) {

		Student student1 = dao.findStudent(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (student1 != null) {

			int totalmarks = student.getTotalmarks();
			int securedmarks = student.getSecuredmarks();
			if (totalmarks > securedmarks) {

				double percentage1 = ((double) securedmarks / totalmarks) * 100;
				student.setPercentage(percentage1);

				if (percentage1 < 35) {
					student.setGrade("Fail");
				} else if (percentage1 >= 35 && percentage1 < 50) {
					student.setGrade("Pass");
				} else if (percentage1 >= 50 && percentage1 < 65) {
					student.setGrade("Second Class");
				} else if (percentage1 >= 65 && percentage1 < 90) {
					student.setGrade("first Class");
				} else {
					student.setGrade("Distinction");
				}

				structure.setMessage("Update Successfull");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(dao.updateStudent(id, student));
				return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);
				
			} else {
				throw new MaxSecuredMarksFound("Secured Marks Are Greater then total Marks");
			}

		} else {
			throw new IdNotFound("Id Not Found");
		}
		
	}

	public ResponseEntity<ResponseStructure<Student>> findStudent(int id) {

		Student student = dao.findStudent(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (student != null) {

			structure.setMessage("Found Successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.findStudent(id));
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);

		} else {
			throw new IdNotFound("Id Not Found");
		}
	
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findAllStudent() {

		List<Student> list = dao.findAllStudent();

		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();

		if (list.isEmpty()) {
			throw new EmptyListFound("Data is Not Present In the List ");

		} else {

			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.FOUND);
		}

	
	}

	public ResponseEntity<ResponseStructure<Student>> deleteStudent(int id) {

		Student student = dao.findStudent(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (student != null) {

			structure.setMessage("Delete Successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.deleteStudent(id));
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);

		} else {
			throw new IdNotFound("Id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Student>> updateEmail(int id, String email) {

		Student student = dao.findStudent(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (student != null) {
			student.setEmail(email);
			structure.setMessage("email Updated");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.updateStudent(id, student));
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);

		} else {
			throw new IdNotFound("Id Not Found");
		}
		
	}

	public ResponseEntity<ResponseStructure<Student>> updateAddress(int id, String address) {

		Student student = dao.findStudent(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (student != null) {
			student.setAddress(address);
			structure.setMessage("Address Updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateStudent(id, student));
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);

		} else {
			throw new IdNotFound("Id Not Found");
		}
		

	}

	public ResponseEntity<ResponseStructure<Student>> updateSecuredMarks(int id, int securedmarks) {

		Student student = dao.findStudent(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (student != null) {

			// int securedmarks1=student.getSecuredmarks();

			if (600 > securedmarks) {
				student.setSecuredmarks(securedmarks);
				double percentage1 = ((double) securedmarks / 600) * 100;
				student.setPercentage(percentage1);

				if (percentage1 < 35) {
					student.setGrade("Fail");
				} else if (percentage1 >= 35 && percentage1 < 50) {
					student.setGrade("Pass");
				} else if (percentage1 >= 50 && percentage1 < 65) {
					student.setGrade("Second Class");
				} else if (percentage1 >= 65 && percentage1 < 90) {
					student.setGrade("first Class");
				} else {
					student.setGrade("Distinction");
				}
				structure.setMessage("Secured marks Update Successfull");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dao.updateStudent(id, student));
				return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);

			} else {
				throw new MaxSecuredMarksFound("Secured Marks Are Greater then total Marks");
			}

		} else {
			throw new IdNotFound("Id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Student>> updatePhone(int id, long phone) {

		Student student = dao.findStudent(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (student != null) {
			student.setPhone(phone);
			structure.setMessage("phone updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateStudent(id, student));
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Id Not Found");
		}

		
	}

	public ResponseEntity<ResponseStructure<Student>> findByEmail(String email) {
		Student student = dao.findByEmail(email);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (student != null) {

			structure.setMessage("Found Successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.findByEmail(email));
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);

		} else {
			throw new EmailNotFound("Email Not Found");
		}
		

	}

	public ResponseEntity<ResponseStructure<Student>> findByPhone(long phone) {
		Student student = dao.findByPhone(phone);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (student != null) {

			structure.setMessage("Found Successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.findByPhone(phone));
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);

		} else {
			throw new PhoneNotFound("Phone Not Found");
		}
		

	}

	public ResponseEntity<ResponseStructure<List<Student>>> findByGrade(String grade) {

		List<Student> list = dao.findByGrade(grade);
		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();

		if (list.isEmpty()) {
			throw new EmptyListFound("Data is Not Present In the List ");

		} else {

			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.FOUND);
		}

		

	}

	public ResponseEntity<ResponseStructure<List<Student>>> findByPercentage(double percentage) {

		List<Student> list = dao.findByPercentage(percentage);
		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();

		if (list.isEmpty()) {
			throw new EmptyListFound("Data is Not Present In the List ");

		} else {

			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.FOUND);
		}

		

	}

	public ResponseEntity<ResponseStructure<List<Student>>> findByAddress(String address) {

		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		List<Student> list = dao.findByAddress(address);
		if (list.isEmpty()) {
			throw new EmptyListFound("Data is Not Present In the List ");

		} else {

			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.FOUND);
		}

		
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findPercentageLessThan(double percentage) {

		List<Student> list = dao.findLessThanPercentage(percentage);
		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();

		if (list.isEmpty()) {
			throw new EmptyListFound("Data is Not Present In the List ");

		} else {

			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.FOUND);
		}

		
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findPercentageGraterThan(double percentage) {

		List<Student> list = dao.findGreaterThanPercentage(percentage);
		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();

		if (list.isEmpty()) {
			throw new EmptyListFound("Data is Not Present In the List ");

		} else {

			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.FOUND);
		}

	
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findAgeGraterThan(int age) {

		List<Student> list = dao.findGreaterThanage(age);
		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();

		if (list.isEmpty()) {
			throw new EmptyListFound("Data is Not Present In the List ");
		} else {

			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.FOUND);
		}

		
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findAgeLessThan(int age) {

		List<Student> list = dao.findLessThanage(age);
		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();

		if (list.isEmpty()) {
			throw new EmptyListFound("Data is Not Present In the List ");

		} else {

			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.FOUND);
		}

		
	}

}
