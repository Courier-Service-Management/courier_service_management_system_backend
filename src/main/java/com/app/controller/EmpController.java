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
import com.app.service.EmpService;

@RestController 

@RequestMapping("/emps")
@CrossOrigin(origins = "http://localhost:3000")
public class EmpController {

	@Autowired
	private EmpService empService;
	

@PostMapping("/signIn") 
 public ResponseEntity<?> logInUser(@RequestBody AuthRequestDto request) { 
  System.out.println("in sign in " + request); 
      
  AuthRespDto authRespDto = null; 
  authRespDto = empService.logInUser(request); 
 
 
   if(authRespDto != null){ 
            return ResponseEntity.status(HttpStatus.OK).body(authRespDto); 
        } 
   return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(false,"User Not Found")); 
 }
	

	
	@PostMapping("/add")
	public ResponseEntity<?> hireEmployee(@RequestBody  AddEmpRequest request){
		
		System.out.println("in hire emp"+request.getFirstName()+request.getBranchId());
		
		empService.addEmp(request);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ApiResponse(true, "User Registered"));
		
		
	}
	
	
	@GetMapping("/empdetails/{empId}")
	public ResponseEntity<?> getEmpetails(@PathVariable Long empId) {

		AddEmpResponse empDTO = empService.getEmpDetailsbyId(empId);

		if (empDTO == null) {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse(false, "emp not found!"));
		}

		return ResponseEntity.status(HttpStatus.OK).body(empDTO);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateEmp(@RequestBody UpdateEmpDTO request) {

		empService.updateEmp(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, "User update"));
	}
	

	
	
	@DeleteMapping("/{empId}")
	public ApiResp deleteEmpDetails(@PathVariable Long empId) {
		
		return empService.deleteEmpDetails(empId);
	}
	
	
	
}
