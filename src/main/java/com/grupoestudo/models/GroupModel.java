package com.grupoestudo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class GroupModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String linkDiscord;
	private Boolean block;
	
	public GroupModel(Long id, String name, String linkDiscord, Boolean block, List<MemberModel> members) {
		super();
		this.id = id;
		this.name = name;
		this.linkDiscord = linkDiscord;
		this.block = false;
		this.members = members;
	}

	@OneToMany(mappedBy = "group")
	private List<MemberModel> members;

}
