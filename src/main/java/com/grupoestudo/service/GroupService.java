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
	
	public String saveGroup(GroupModel group) {
		if ( group.getLinkDiscord().isEmpty() || group.getName().isEmpty()) {
			return "Check fields!";
		}
		GP.save(group);		
		return "Group save successful";
	}
	
	public List<GroupModel> listGroup() {
		return GP.findAll();
	}

	public GroupModel getOneById(Long id) {
		return GP.getById(id);
		
	}

	public void delete(Long id) {
		GP.deleteById(id);
		
	}

	public void block(Long id) {
		GroupModel current = GP.getById(id);
		current.setBlock(true);
		GP.save(current);
		
	}
	public void unblock(Long id) {
		GroupModel current = GP.getById(id);
		current.setBlock(false);
		GP.save(current);
		
	}
}
