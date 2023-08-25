package com.app.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.app.entities.Branch;
import com.app.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;






@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddEmpResponse {
	
	
	  private int empId;
		private String firstName;	
	  
		private String lastName;
	 
	    private String email;
	  
		
		
		private String password;
	
		
		@Enumerated(EnumType.STRING)
		private Role role;
		
	
		private String mobile;
		
		private String gender;
	
	
		private Long branchId;
		
		


}
