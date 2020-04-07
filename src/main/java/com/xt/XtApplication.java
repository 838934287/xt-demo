package com.xt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xt.dao")
public class XtApplication {

	public static void main(String[] args) {
		SpringApplication.run(XtApplication.class, args);
	}

}
