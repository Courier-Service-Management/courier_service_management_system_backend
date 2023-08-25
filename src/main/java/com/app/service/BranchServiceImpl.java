package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BranchDao;
import com.app.dao.EmpDao;
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

@Service
@Transactional
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchDao branchDao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<GetAllBranchDTO> getAllBranch() {

		List<Branch> branchList = branchDao.findAll();

		List<GetAllBranchDTO> getAllBranchDTOList = new ArrayList<>();
		// System.out.println(empList.get(1).getBranch());
		for (Branch branch : branchList) {

			GetAllBranchDTO branchDTO = mapper.map(branch, GetAllBranchDTO.class);

			getAllBranchDTOList.add(branchDTO);
		}
		return getAllBranchDTOList;

	}
	
	@Override
	public List<GetAllEmpDto> getAllEmp(Long branchId) {

		Branch branch= branchDao.findById(branchId).orElseThrow(null);
      
        List<Emp> empList=  branch.getEmplist();
		return empList.stream().
		map(emp->mapper.map(emp,GetAllEmpDto.class)).
		collect(Collectors.toList());
	}
		     

	@Override
	public void addBranch(AddBranchDTO request) {

		Branch branch = mapper.map(request, Branch.class);

		Branch branch2 = branchDao.save(branch);
		// map entity-> Dao

	}

	@Override
	public UpdateBranchDTO updateBranch(UpdateBranchDTO request) {

		Branch branch = branchDao.findById(request.getBranchId())
				.orElseThrow(() -> new RuntimeException("Branch not found!"));
		branch.setBranchId(request.getBranchId());
		branch.setBranchCode(request.getBranchCode());
		branch.setBranchLocation(request.getBranchLocation());
		branch.setBranchManager(request.getBranchManager());
		branch.setBranchName(request.getBranchName());

		Branch branch2 = branchDao.save(branch);
		return mapper.map(branch, UpdateBranchDTO.class);

	}

	@Override
	public GetbranchDTO getbranchDetailsbyId(Long branchId) {
		Branch branch = branchDao.findById(branchId).orElseThrow(null);
		return mapper.map(branch, GetbranchDTO.class);
	}

	@Override
	public Branch getBranchDetails(Long branchId) {
		// TODO Auto-generated method stub
		return branchDao.findById(branchId).orElseThrow(null);
	}

	@Override
	public ApiResp deleteBranchDetails(Long branchId) {
		Branch branch = getBranchDetails(branchId);

		branchDao.delete(branch);
		return new ApiResp("emp details deleted !");
	}
}
