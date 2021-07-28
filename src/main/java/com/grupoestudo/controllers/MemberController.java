package com.grupoestudo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.grupoestudo.models.MemberModel;
import com.grupoestudo.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService MS;
	
	@GetMapping(value = "/members")
	public List<MemberModel> listAll() {
		return MS.findAll();
	}
	
	@PostMapping(value="/group/{idGroup}")
	public String saveMember(@PathVariable Long idGroup, MemberModel member) {
		MS.save(idGroup,member);
//		ModelAndView mav = new ModelAndView("OneGroup");
//		mav.getView()
		return "redirect:"+idGroup;
	}
}
