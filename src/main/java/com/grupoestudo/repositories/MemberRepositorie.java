package com.grupoestudo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupoestudo.models.MemberModel;

public interface MemberRepositorie extends JpaRepository<MemberModel, Long> {

}
