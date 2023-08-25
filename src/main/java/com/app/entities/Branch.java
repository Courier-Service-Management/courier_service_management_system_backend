package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "branch")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "branch_id")
	private Long branchId;

	@Column(length = 20)
	private String branchName;

	@Column(length = 20)
	private String branchLocation;

	@Column(length = 50)
	private String branchCode;

	@Column(length = 50)
	private String branchManager;

	@OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Emp> emplist = new ArrayList<>();

	@OneToMany(mappedBy = "branchs", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Orders> orderlist = new ArrayList<>();

}
