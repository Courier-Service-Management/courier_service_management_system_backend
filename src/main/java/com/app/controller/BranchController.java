package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.*;
import com.app.dto.AddBranchDTO;
import com.app.dto.AddEmpRequest;
import com.app.dto.ApiResp;
import com.app.dto.ApiResponse;
import com.app.dto.GetAllBranchDTO;
import com.app.dto.GetAllEmpDto;
import com.app.dto.GetbranchDTO;
import com.app.dto.UpdateBranchDTO;
import com.app.dto.UpdateEmpDTO;
import com.app.service.BranchService;
import com.app.service.EmpService;

@RestController

@RequestMapping("/branch")

@CrossOrigin(origins = "http://localhost:3000")
public class BranchController {

	@Autowired
	private BranchService branchService;

	@GetMapping("/all")
	public ResponseEntity<?> getAllBranch() {

		List<GetAllBranchDTO> getAllBranchDTOList = branchService.getAllBranch();

		if (getAllBranchDTOList == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "Data not found!"));
		}

		return ResponseEntity.status(HttpStatus.OK).body(getAllBranchDTOList);
	}
	
	
  @GetMapping("/branchemp/{branchId}")
  public ResponseEntity<?> getAllEmp(@PathVariable Long branchId) {

      List<GetAllEmpDto> getAllEmpDTOList = branchService.getAllEmp( branchId);

      if (getAllEmpDTOList == null) {

          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "Data not found!"));
      }

      return ResponseEntity.status(HttpStatus.OK).body(getAllEmpDTOList);
  }


	@PostMapping("/add")
	public ResponseEntity<?> hireEmployee(@RequestBody @Valid AddBranchDTO request) {

		branchService.addBranch(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, "User Registered"));

	}

	@GetMapping("/{branchId}")
	public ResponseEntity<?> getBranchDetails(@PathVariable Long branchId) {

		GetbranchDTO branchDTO = branchService.getbranchDetailsbyId(branchId);

		if (branchDTO == null) {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse(false, "branch not found!"));
		}

		return ResponseEntity.status(HttpStatus.OK).body(branchDTO);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateBranch(@RequestBody UpdateBranchDTO request) {

		branchService.updateBranch(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, "User update"));
	}

	@DeleteMapping("/delete/{branchId}")

	public ApiResp deleteEmpDetails(@PathVariable Long branchId) {

		return branchService.deleteBranchDetails(branchId);
	}

}
