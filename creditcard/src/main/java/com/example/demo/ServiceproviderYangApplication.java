package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableEurekaClient
@MapperScan("com.example.demo.mapper")
public class ServiceproviderYangApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceproviderYangApplication.class, args);
	}

}
