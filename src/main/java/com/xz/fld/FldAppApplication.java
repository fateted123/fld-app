package com.xz.fld;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan("com.xz.fld.mapper")
public class FldAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FldAppApplication.class, args);
	}
}
