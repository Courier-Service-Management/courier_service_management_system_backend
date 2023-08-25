package com.app.dto;

import com.app.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetAllEmpDto {
	
	  private int empId;
			private String firstName;	
		  
			private String lastName;
		 
		    private String email;
		  
			
			
			private String password;
		
			private Role role;
			
		
			private String mobile;
			
			private String gender;
		
		
			

}
