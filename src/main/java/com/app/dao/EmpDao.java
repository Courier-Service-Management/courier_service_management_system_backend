package com.app.dao;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Emp;

public interface EmpDao extends JpaRepository<Emp, Long> {
	
	Optional<Emp> findByEmail(String email);
	


}
