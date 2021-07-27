package com.grupoestudo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grupoestudo.models.GroupModel;
import com.grupoestudo.service.GroupService;

@Controller
public class GroupController {

	@Autowired
	GroupService GS;

	@GetMapping(value = "/group")
	public String toIndex() {
		return "page1";
	}

	@PostMapping(value = "/group")
	public String saveGroup(GroupModel group) {

		GS.saveGroup(group);

		return  "page1";
	}
}
