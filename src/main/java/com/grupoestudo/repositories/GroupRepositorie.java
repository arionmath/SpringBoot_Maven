package com.grupoestudo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupoestudo.models.GroupModel;

public interface GroupRepositorie extends JpaRepository<GroupModel, Long> {

}
