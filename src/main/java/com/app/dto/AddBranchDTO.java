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
public class AddBranchDTO {
	
	 private Long branchId;
		private String branchName;	
	  
		private String branchLocation;
	 
	    private String branchCode;
	  
		
		
		private String  branchManager;

}
