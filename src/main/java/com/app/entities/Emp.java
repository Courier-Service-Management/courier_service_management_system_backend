package com.app.entities;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name="emp")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude ="branch")
public class Emp {
	
	 @Id 
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	     @Column(name = "emp_Id")
	 private Long empId;
	 
       @Column(length = 20)
			private String firstName;
       
       @Column (length = 20)
		private String lastName;
       @Column (length = 50)
     		private String email;
       @Column (length = 50)
     		private String mobile;
		   @Column (length = 20)
			private String password;
		   @Column (length = 20)
			private String gender;
		   
		   @Enumerated(EnumType.STRING)
			private Role role;
		   
		   @ManyToOne
		   @JoinColumn (name="branch_id")
			private Branch branch;

}
