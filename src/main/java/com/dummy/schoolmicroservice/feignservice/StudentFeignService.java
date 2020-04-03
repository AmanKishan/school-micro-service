package com.dummy.schoolmicroservice.feignservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dummy.schoolmicroservice.configuration.FeignConfiguration;
import com.dummy.schoolmicroservice.dto.Student;


@FeignClient(name ="student-microservice",configuration = FeignConfiguration.class )
//@FeignClient("student-microservice")
/**
 * we can also do this also,
 * configuration = FeignConfiguration.class give full control
 * of feign features like logging, Contract, RequestInterceptor 
 * retryer, errorDecoder, connectTimeout, readTimeout,encoder
 * decoder etc
 */
public interface StudentFeignService {
	
	@GetMapping(value = "api/getStudentDetailsForSchool/{schoolname}")
    public List<Student> getStudents(@PathVariable String schoolname);
	
}
