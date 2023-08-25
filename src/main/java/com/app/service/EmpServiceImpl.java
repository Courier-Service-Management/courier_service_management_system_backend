package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dao.BranchDao;
import com.app.dao.EmpDao;
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
import com.app.entities.Branch;
import com.app.entities.Emp;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDao empDao;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private BranchDao branchDao;
	@Autowired
	private PasswordEncoder passwordEncoder;



	@Override
	public void addEmp(AddEmpRequest request) {

		Emp emp = mapper.map(request, Emp.class);
		Branch branch = branchDao.getReferenceById(request.getBranchId());
		emp.setBranch(branch);
		Emp emp2 = empDao.save(emp);
		// map entity-> Dao
		
	}
	
	@Override
	public AddEmpResponse getEmpDetailsbyId(Long empId) {
		Emp emp = empDao.findById(empId).orElseThrow(null);
		AddEmpResponse response = mapper.map(emp, AddEmpResponse.class);
		response.setBranchId(emp.getBranch().getBranchId());
		return response;
	}


	@Override
	public UpdateEmpDTO updateEmp(UpdateEmpDTO request) {

		Emp emp = empDao.findById(request.getEmpId()).orElseThrow(() -> new RuntimeException("emp not found!"));
		emp.setEmpId(request.getEmpId());
		emp.setFirstName(request.getFirstName());
		emp.setLastName(request.getLastName());
		emp.setEmail(request.getEmail());
		emp.setMobile(request.getMobile());
		emp.setPassword(request.getPassword());
		emp.setGender(request.getGender());
		emp.setRole(request.getRole());
		

		Emp empRes = empDao.save(emp);
		return mapper.map(empRes, UpdateEmpDTO.class);

	}
	

	@Override
	public AuthRespDto logInUser(AuthRequestDto req) {
		//AuthRespDto respUser = null;
		Emp emp = empDao.findByEmail(req.getEmail()).orElseThrow(null);
		
		AuthRespDto response = mapper.map(emp, AuthRespDto.class);
		response.setBranchId(emp.getBranch().getBranchId());
		return response;
				
//		if (emp != null) {
//			//boolean flag = passwordEncoder.matches(req.getPassword(), emp.getPassword());
//			//if (flag) {
//				respUser = mapper.map(emp, AuthRespDto.class);
//			}
//		//}
//		return respUser;
	}

	@Override
	public Emp getEmpDetails(Long empId) {
		// TODO Auto-generated method stub
		return empDao.findById(empId).orElseThrow(null);
	}
	@Override
	public ApiResp deleteEmpDetails(Long empId) {
		Emp emp = getEmpDetails(empId);
		// => emp id valid
		empDao.delete(emp); 
		return new ApiResp("emp details deleted !");
	}

}
