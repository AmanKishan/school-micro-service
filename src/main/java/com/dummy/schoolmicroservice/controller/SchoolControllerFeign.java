package com.dummy.schoolmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.schoolmicroservice.dto.Student;
import com.dummy.schoolmicroservice.feignservice.StudentFeignService;

@RestController
@RequestMapping("/api/feign")
public class SchoolControllerFeign {

	@Autowired
	private StudentFeignService studentFeignService;
	
	@GetMapping("/getSchoolDetails/{schoolName}")
	public ResponseEntity<List<Student>> getStudents(@PathVariable String schoolName) {
		System.out.println("Getting School details for " + schoolName);
		List<Student> response = studentFeignService.getStudents(schoolName);
		
		return new ResponseEntity<>(response,HttpStatus.OK); 
	}
}
