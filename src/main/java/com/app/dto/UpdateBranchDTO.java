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
public class UpdateBranchDTO {

	private Long branchId;
	
	private String branchName;

	private String branchLocation;

	private String branchCode;

	private String branchManager;

}
