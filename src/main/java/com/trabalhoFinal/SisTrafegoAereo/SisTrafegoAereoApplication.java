package com.trabalhoFinal.SisTrafegoAereo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.trabalhoFinal" })
@EntityScan(basePackages = { "com.trabalhoFinal" })
public class SisTrafegoAereoApplication {
	public static void main(String[] args) {
        System.out.println("Hello World");
		SpringApplication.run(SisTrafegoAereoApplication.class, args);
	}
}
