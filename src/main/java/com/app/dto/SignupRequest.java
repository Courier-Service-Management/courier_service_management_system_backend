package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

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
public class SignupRequest {
	
	
	 @NotBlank(message="first name can't be blank")
		private String firstName;	
	    @Length(min = 3, max=20, message="Invalid length of last name")
		private String lastName;
	    @NotBlank(message = "Email can't be blank or null!!!")
		@Email(message = "Invalid email format !!!!")
	    private String email;
	  
		
		@NotNull
		@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})")
		private String password;
		
	
		
		@NotNull
		private String mobile;
		
		@NotNull
		private String gender;

}
