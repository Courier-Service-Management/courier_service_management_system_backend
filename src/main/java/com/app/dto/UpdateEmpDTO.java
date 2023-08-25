package com.app.dto;

import com.app.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UpdateEmpDTO {
	
	
	  private Long empId;
		private String firstName;	
	  
		private String lastName;
	 
	    private String email;
	  
		
		
		private String password;
	
		private Role role;
		
	
		private String mobile;
		
		private String gender;
		 private Long branchId;

}
