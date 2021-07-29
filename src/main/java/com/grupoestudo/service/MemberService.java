package com.grupoestudo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoestudo.models.GroupModel;
import com.grupoestudo.models.MemberModel;
import com.grupoestudo.repositories.MemberRepositorie;
@Service
public class MemberService {

	@Autowired
	MemberRepositorie MR;
	public List<MemberModel> findAll() {
		return MR.findAll();
	}
	public String save(Long idGroup, MemberModel member) {
		if(member.getName().isEmpty()||member.getPhone().isEmpty()) {
			return "Check fields!";
		}
		
		member.setGroup(  new GroupModel(idGroup,null,null,null,null)  );
		MR.save(member);
		return "Member save successful";
		
	}

}
