package com.format.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.format.modelo.Student;

@RestController
public class StudentController {
	
	@GetMapping("/listar/student")
	public Student listarStudent() {
		Student student = new Student(100,
				Set.of("ESPAÑOL","INGLES","ALEMAN","PORTUGUES"),
				List.of(80,90,70,50),
				new String[]{"1","2","3","4"});
		return student;
	}

}
