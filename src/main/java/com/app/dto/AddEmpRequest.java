package com.app.dto;


import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddEmpRequest {
	
	
	 @NotBlank(message="first name can't be blank")
		private String firstName;	
	    @Length(message="Invalid length of last name")
		private String lastName;
	    @NotBlank(message = "Email can't be blank or null!!!")
		@Email(message = "Invalid email format !!!!")
	    private String email;
	  
		
		@NotNull
		@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})")
		private String password;
		
		@Enumerated(EnumType.STRING)
		@NotNull
		private Role role;
		
		@NotNull
		private String mobile;
		
		@NotNull
		private String gender;
	
	   @NotNull
	   private  Long branchId;
			
			
}
