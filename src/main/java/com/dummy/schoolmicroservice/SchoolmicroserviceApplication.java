package com.dummy.schoolmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.dummy.schoolmicroservice.configuration.RibbonConfiguration;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
@RibbonClient(name="student-servers",configuration = RibbonConfiguration.class)
public class SchoolmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolmicroserviceApplication.class, args);
	}

}
