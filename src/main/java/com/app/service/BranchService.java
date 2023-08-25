package com.app.service;

import java.util.List;

import com.app.dto.AddBranchDTO;
import com.app.dto.AddEmpRequest;
import com.app.dto.AddEmpResponse;
import com.app.dto.ApiResp;
import com.app.dto.GetAllBranchDTO;
import com.app.dto.GetAllEmpDto;
import com.app.dto.GetbranchDTO;
import com.app.dto.UpdateBranchDTO;
import com.app.dto.UpdateEmpDTO;
import com.app.entities.Branch;
import com.app.entities.Emp;

public interface BranchService {

	
	List<GetAllBranchDTO> getAllBranch();
	void addBranch(AddBranchDTO request);
	 UpdateBranchDTO  updateBranch(UpdateBranchDTO request);
	 Branch getBranchDetails(Long branchId);
	 GetbranchDTO getbranchDetailsbyId(Long branchId);
		ApiResp deleteBranchDetails(Long branchId);
		
		List<GetAllEmpDto> getAllEmp(Long branchId);
}
