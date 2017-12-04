package com.chinaroam.application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeApplication {
	@RequestMapping	("/")
	String home() {
		return "Hello boot!";
	}
}
