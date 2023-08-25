package com.app.service;

import java.util.List;

import com.app.dto.AddEmpRequest;
import com.app.dto.AddEmpResponse;
import com.app.dto.ApiResp;
import com.app.dto.ApiResponse;
import com.app.dto.AuthRequestDto;
import com.app.dto.AuthRespDto;
import com.app.dto.GetAllEmpDto;
import com.app.dto.GetbranchDTO;
import com.app.dto.UpdateBranchDTO;
import com.app.dto.UpdateEmpDTO;
import com.app.entities.Emp;

public interface EmpService {
	
	void addEmp(AddEmpRequest request);
	Emp getEmpDetails(Long empId);
	ApiResp deleteEmpDetails(Long empId);
	 UpdateEmpDTO updateEmp(UpdateEmpDTO request);
	AuthRespDto logInUser(AuthRequestDto req);
	
	 AddEmpResponse getEmpDetailsbyId(Long empId);
	 
	
	
}
