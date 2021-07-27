package com.grupoestudo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

}
