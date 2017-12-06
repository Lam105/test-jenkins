package com.cicd.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cicd.model.Person;

@RestController
@RequestMapping("/test")
public class TestService {
	@GetMapping("/abc")
	public Person getAbc() {
		return new Person("Bob", 12);
	}
	
	@GetMapping("/def")
	public Person getDef() {
		return new Person("Dod", 22);
	}
}
