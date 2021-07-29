package com.grupoestudo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.grupoestudo.models.GroupModel;
import com.grupoestudo.models.MemberModel;
import com.grupoestudo.service.GroupService;
import com.grupoestudo.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService MS;
	@Autowired
	GroupService GS;
	
	@GetMapping(value = "/members")
	public List<MemberModel> listAll() {
		return MS.findAll();
	}
	
	@PostMapping(value="/group-{idGroup}")
	public ModelAndView saveMember(@PathVariable Long idGroup, MemberModel member) {

		
		
		GroupModel currentGroup = GS.getOneById(idGroup);
		ModelAndView mav = new ModelAndView("OneGroup");
		String result;
		if (currentGroup.getBlock()) {
			result = "This group is blocked. You can't add members!";
		}else {
			result = MS.save(idGroup,member);
		}
		mav.addObject("result", result);
		mav.addObject("group",currentGroup);
		
		return mav;
	}
}
