package com.grupoestudo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.grupoestudo.models.GroupModel;
import com.grupoestudo.service.GroupService;

@Controller
public class GroupController {

	@Autowired
	GroupService GS;

	@GetMapping(value = "/inicio")
	public String toIndex() {
		return "page1";
	}

	@PostMapping(value = "/group")
	public String saveGroup(@RequestBody GroupModel group) {

		GS.saveGroup(group);

		return null;
	}
}
