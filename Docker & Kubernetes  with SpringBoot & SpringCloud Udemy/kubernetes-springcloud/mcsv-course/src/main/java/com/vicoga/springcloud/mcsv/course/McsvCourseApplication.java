package com.vicoga.springcloud.mcsv.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class McsvCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(McsvCourseApplication.class, args);
	}

}
