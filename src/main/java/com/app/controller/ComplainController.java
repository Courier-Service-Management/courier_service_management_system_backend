package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddComplainDTO;
import com.app.dto.AddEmpRequest;
import com.app.dto.ApiResponse;
import com.app.service.ComplainService;
import com.app.service.EmpService;


@RestController 

@RequestMapping("/complain")
@CrossOrigin(origins = "http://localhost:3000")
public class ComplainController {
	
	@Autowired
	private ComplainService complainService;
	
	@PostMapping("/add")
	public ResponseEntity<?> hireEmployee(@RequestBody @Valid AddComplainDTO request){
		System.out.println("in hire emp"+request);
		//invoke Service layer
		
		complainService.addComplain(request);
		
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ApiResponse(true, "User Registered"));
		
	}

}
