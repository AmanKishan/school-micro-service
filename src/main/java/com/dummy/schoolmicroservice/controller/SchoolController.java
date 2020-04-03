package com.dummy.schoolmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class SchoolController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/getSchoolDetails/{schoolName}")
	public String getStudents(@PathVariable String schoolName) {
		System.out.println("Getting School details for " + schoolName);
		ResponseEntity<String> response = restTemplate.exchange("http://STUDENT-MICROSERVICE/api/getStudentDetailsForSchool/{schoolname}", HttpMethod.GET,
				 null, new ParameterizedTypeReference<String>() {}, schoolName	);
		
		return "School Name -  " + schoolName + " \n Student Details " + response.getBody(); 
	}
	
	 @Bean
	    @LoadBalanced
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
}
