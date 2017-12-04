package com.chinaroam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinaroam.service.IRoamService;

@RestController
@RequestMapping("roam")
public class RoamController {

	@Autowired
	private IRoamService roamService;
	
	
}
