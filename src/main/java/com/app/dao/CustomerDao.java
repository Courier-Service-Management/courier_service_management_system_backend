package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Customer;
import com.app.entities.Emp;

public interface CustomerDao extends JpaRepository<Customer, Long> {

	Optional<Customer> findByEmail(String email);
}
