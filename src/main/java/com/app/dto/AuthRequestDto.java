package com.app.dto;

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
public class AuthRequestDto {
	
	// @NotBlank(message = "Email can't be blank or null!!!") // @Email(message = "Invalid email format !!!!")
	 private String email; // @NotBlank(message = "Password required !!!!")
	 // @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Blank or invalid password !!!") private String password;
    private String password;
}
