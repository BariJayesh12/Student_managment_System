package com.qsp.springbootstudent.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.qsp.springbootstudent.dao.StudentDao;
import com.qsp.springbootstudent.dto.Student;
import com.qsp.springbootstudent.service.StudentService;
import com.qsp.springbootstudent.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class StudentController {

	// @Autowired
	// private StudentDao dao;

	@Autowired
	private StudentService service;

	@PostMapping("/save")
	@ApiOperation(value = "Save Student", notes = "This Api Is Used to Save the Student data in Database")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Data Saved Successfull") })
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@Valid @RequestBody Student student) {
		return service.saveStudent(student);
	}

	@GetMapping("/find")
	@ApiOperation(value = "Find Student", notes = "This Api Is Used to Find the Student data in Database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Data Found Successfull") })
	public ResponseEntity<ResponseStructure<Student>> findStudent(@RequestParam int id) {
		return service.findStudent(id);
	}

	@GetMapping("/findall")
	@ApiOperation(value = "Find All Student ", notes = "This Api Is Used to Find the All Student data in Database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Data Found Successfull") })
	public ResponseEntity<ResponseStructure<List<Student>>> findAllStudent() {
		return service.findAllStudent();
	}

	@DeleteMapping("/delete")
	@ApiOperation(value = "Delete Student", notes = "This Api Is Used to Delete the Student data in Database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Data Deleted Successfull") })
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@RequestParam int id) {
		return service.deleteStudent(id);
	}

	@PutMapping("/update")
	@ApiOperation(value = "Update Student", notes = "This Api Is Used to update the Student data in Database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Data Updated Successfull") })
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestParam int id,
			@RequestBody Student student) {
		return service.updateStudent(id, student);
	}

	@PatchMapping("/updateemail/{id}")
	@ApiOperation(value = "update Email", notes = "This Api Is Used to Update the Student email in Database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Email Updated Successfull") })
	public ResponseEntity<ResponseStructure<Student>> updateEmail(@PathVariable int id, @RequestParam String email) {
		return service.updateEmail(id, email);
	}

	@PatchMapping("/updateaddress/{id}")
	@ApiOperation(value = "Update Student email", notes = "This Api Is Used to Update the Address of Student data in Database")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Email Updated Successfull") })
	public ResponseEntity<ResponseStructure<Student>> updateAddress(@PathVariable int id,
			@RequestParam String address) {
		return service.updateAddress(id, address);
	}

	@PatchMapping("/updatesecuredmarks/{id}")
	@ApiOperation(value = "Update Secured Marks", notes = "This Api Is Used to Update the Student Secured marks in Database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Marks Updated Successfull") })
	public ResponseEntity<ResponseStructure<Student>> updateSecuredMarks(@PathVariable int id,
			@RequestParam int securedmarks) {
		return service.updateSecuredMarks(id, securedmarks);
	}

	@PatchMapping("/updatephone/{id}")
	@ApiOperation(value = "Update Phone", notes = "This Api Is Used to Update the Student phone in Database")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Phone Updated Successfull") })
	public ResponseEntity<ResponseStructure<Student>> updatePhone(@PathVariable int id, @RequestParam long phone) {
		return service.updatePhone(id, phone);
	}

	@GetMapping("/findbyemail")
	@ApiOperation(value = "Find Student By Email", notes = "This Api Is Used to Find the Student data in Database using Email")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Data Found Successfull") })
	public ResponseEntity<ResponseStructure<Student>> findByEmail(@RequestParam String email) {
		return service.findByEmail(email);
	}

	@GetMapping("/findbyphone")
	@ApiOperation(value = "Find Student By phone", notes = "This Api Is Used to Find the Student data in Database using Phone")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Data Found Successfull") })
	public ResponseEntity<ResponseStructure<Student>> findByPhone(@RequestParam long phone) {
		return service.findByPhone(phone);
	}

	@GetMapping("/findbygrade")
	@ApiOperation(value = "Find Student By grade", notes = "This Api Is Used to Find the Student data in Database using Grade")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Data Found Successfull") })
	public ResponseEntity<ResponseStructure<List<Student>>> findByGrade(@RequestParam String grade) {
		return service.findByGrade(grade);
	}

	@GetMapping("/findbypercentage")
	@ApiOperation(value = "Find Student By Percentege", notes = "This Api Is Used to Find the Student data in Database using Percentage")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Data Found Successfull") })
	public ResponseEntity<ResponseStructure<List<Student>>> findByPercentage(@RequestParam double percentage) {
		return service.findByPercentage(percentage);
	}

	@GetMapping("/findbyaddress")
	@ApiOperation(value = "Find Student By Address", notes = "This Api Is Used to Find the Student data in Database using Address")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Data Found Successfull") })
	public ResponseEntity<ResponseStructure<List<Student>>> findByAddress(@RequestParam String address) {
		return service.findByAddress(address);
	}

	@GetMapping("/lessthan")
	@ApiOperation(value = "Find Student By less than Marks", notes = "This Api Is Used to Find the Student data in Database with has low Percentage")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Data Found Successfull") })
	public ResponseEntity<ResponseStructure<List<Student>>> findpercentageLessThan(@RequestParam double percentage) {
		return service.findPercentageLessThan(percentage);
	}

	@GetMapping("/greaterthan")
	@ApiOperation(value = "Find Student By less than Percentage", notes = "This Api Is Used to Find the Student data in Database with has more Percentage")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Data Found Successfull") })
	public ResponseEntity<ResponseStructure<List<Student>>> findpercentageGreaterThan(@RequestParam double percentage) {
		return service.findPercentageGraterThan(percentage);
	}

	@GetMapping("/greaterthanage")
	@ApiOperation(value = "Find Student By small Age", notes = "This Api Is Used to Find the Student data in Database with has Small age")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Data Found Successfull") })
	public ResponseEntity<ResponseStructure<List<Student>>> findAgeGreaterThan(@RequestParam int age) {
		return service.findAgeGraterThan(age);
	}

	@GetMapping("/lessthanage")
	@ApiOperation(value = "Find Student By Big", notes = "This Api Is Used to Find the Student data in Database with has big age")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Data Found Successfull") })
	public ResponseEntity<ResponseStructure<List<Student>>> findAgeLessThan(@RequestParam int age) {
		return service.findAgeLessThan(age);
	}

}
