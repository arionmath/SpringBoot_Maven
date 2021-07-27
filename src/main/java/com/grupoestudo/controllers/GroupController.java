package com.grupoestudo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.grupoestudo.models.GroupModel;
import com.grupoestudo.service.GroupService;

@Controller
public class GroupController {

	@Autowired
	GroupService GS;

//	@GetMapping(value = "/group")
//	public List<GroupModel> listAll() {
//		return GS.listGroup();
//	}
	@GetMapping(value = "/group")
	public ModelAndView listAll() {
		String page = "allGroups";
		List<GroupModel> listGroup = GS.listGroup();	
		ModelAndView mav = new ModelAndView(page);
		mav.addObject("atribute", listGroup);
		return mav;
	}

	@PostMapping(value = "/index")
	public String saveGroup(GroupModel group) {

		GS.saveGroup(group);

		return  "registerGroup";
	}
	
	@RequestMapping(value = "/index")
	public String toIndex() {
		return"registerGroup";
	}
}
