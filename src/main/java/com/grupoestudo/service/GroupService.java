package com.grupoestudo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoestudo.models.GroupModel;
import com.grupoestudo.repositories.GroupRepositorie;
@Service
public class GroupService {
	
	@Autowired
	GroupRepositorie GP;
	
	public void saveGroup(GroupModel group) {
		GP.save(group);		
	}
	
	public List<GroupModel> listGroup() {
		return GP.findAll();
	}

}
