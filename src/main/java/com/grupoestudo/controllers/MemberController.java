package com.grupoestudo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.grupoestudo.models.GroupModel;
import com.grupoestudo.models.MemberModel;
import com.grupoestudo.service.GroupService;
import com.grupoestudo.service.MemberService;

import javassist.expr.NewArray;

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

	@PostMapping(value = "/group-{idGroup}")
	public ModelAndView saveMember(@PathVariable Long idGroup, @Valid MemberModel member, BindingResult bindingResult) {

		GroupModel currentGroup = GS.getOneById(idGroup);
		ModelAndView mav = new ModelAndView("OneGroup");
		mav.addObject("group", currentGroup);
		String result;
		if (currentGroup.getBlock()) {
			result = "This group is blocked. You can't add members!";
		} else if (bindingResult.hasErrors()) {
			List<ObjectError> listErros = bindingResult.getAllErrors();
			List<String> listErrosString = new ArrayList<String>();
			for (ObjectError objectError : listErros) {
				listErrosString.add(objectError.getDefaultMessage());
			}
			mav.addObject("warning", listErrosString);
			mav.addObject("currentMember", member);
			return mav;

		} else {
			result = MS.save(idGroup, member);
		}
		
		mav.addObject("currentMember", new MemberModel(null," "," ",null));
		mav.addObject("result", result);

		return mav;
	}
}
