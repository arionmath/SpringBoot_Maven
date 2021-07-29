package com.grupoestudo.controllers;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.grupoestudo.models.GroupModel;
import com.grupoestudo.models.MemberModel;
import com.grupoestudo.service.GroupService;

/**
 * @author Winar
 *
 */
@Controller
public class GroupController {

	@Autowired
	GroupService GS;

//	@GetMapping(value = "/group")
//	public List<GroupModel> listAll() {
//		return GS.listGroup();
//	}
	@GetMapping(value = "/groups")
	public ModelAndView listAll() {
		String page = "allGroups";
		List<GroupModel> listGroup = GS.listGroup();
		ModelAndView mav = new ModelAndView(page);
		mav.addObject("atribute", listGroup);
		return mav;
	}

	@PostMapping(value = "/index")
	public ModelAndView saveGroup(GroupModel group) {

		String result = GS.saveGroup(group);

		ModelAndView mav = new ModelAndView("registerGroup");

		mav.addObject("result", result);

		// return "registerGroup";
		return mav;
	}

	@RequestMapping(value = "/index")
	public String toIndex() {
		return "registerGroup";
	}

	/*
	 * @GetMapping(value = "/teste/{id}") public ModelAndView test(@PathVariable
	 * Long id) { String page = "teste"; ModelAndView mav = new ModelAndView(page);
	 * //GroupModel gp = GS.getOneById(4L); mav.addObject("group",
	 * GS.getOneById(4L)); return mav; }
	 * 
	 * @Re
	 * 
	 * @RequestMapping(value="/teste/{codigo}", method=RequestMethod.GET) public
	 * ModelAndView detalhesEvento(@PathVariable("codigo") long codigo){ //Evento
	 * evento = er.findByCodigo(codigo); GroupModel gp = GS.getOneById(codigo);
	 * ModelAndView mv = new ModelAndView("teste"); mv.addObject("group", gp);
	 * 
	 * return mv; }
	 */

	@GetMapping(value = "/group-{id}")
	public ModelAndView showOne(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("OneGroup");
		mav.addObject("group", GS.getOneById(id));
		return mav;
	}

	/*
	 * @GetMapping(value = "/group/{id}") public ModelAndView showOne(@PathVariable
	 * Long id) { ModelAndView mav = new ModelAndView("OneGroup");
	 * mav.addObject("group", GS.getOneById(id)); return mav; }
	 */
	@GetMapping(value = "/blockGroup/{id}")
	public String blockGroup(@PathVariable Long id) {
		GS.block(id);
		return "redirect:/groups";

	}

	@GetMapping(value = "/unblockGroup/{id}")
	public String unblockGroup(@PathVariable Long id) {
		GS.unblock(id);
		return "redirect:/groups";

	}
}
