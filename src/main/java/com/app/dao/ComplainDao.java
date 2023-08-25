package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Complain;

public interface ComplainDao extends JpaRepository<Complain, Long> {

}
