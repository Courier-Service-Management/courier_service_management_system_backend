package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long customerId;

	@Column(length = 20)
	private String firstName;

	@Column(length = 20)
	private String lastName;

	@Column(length = 50)
	private String email;

	@Column(length = 50)
	private String mobile;

	@Column(length = 20)
	private String password;

	@Column(length = 20)
	private String gender;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Orders> orderlist = new ArrayList<>();

//		   public List<Orders> getList() {
//			   
//			   return orderlist;
//		   }

}
