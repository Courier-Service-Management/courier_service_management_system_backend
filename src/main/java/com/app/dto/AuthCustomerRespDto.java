package com.app.dto;

import com.app.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthCustomerRespDto {
	
	 private Long customerId;
		private String firstName;	
	  
		private String lastName;
	 
	    private String email;
	  
		
		
		private String password;
	
		
		
	
		private String mobile;
		
		private String gender;

}
