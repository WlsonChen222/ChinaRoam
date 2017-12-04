package com.chinaroam.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinaroam.model.Folder;

@RestController
@RequestMapping("roam")
public class RoamController {

	//@Autowired
	//private IRoamService roamService;
	
	public List<Folder> queryFolders(Integer user_id, Integer folder_id){
		return null;
	}

	public List<Folder> queryFiles(Integer folder_id){
		return null;
	}
	
}
