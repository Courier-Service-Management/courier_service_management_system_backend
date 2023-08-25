package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddEmpRequest;
import com.app.dto.AddEmpResponse;
import com.app.dto.ApiResponse;
import com.app.dto.AuthCustomerRequestDto;
import com.app.dto.AuthCustomerRespDto;
import com.app.dto.AuthRequestDto;
import com.app.dto.AuthRespDto;
import com.app.dto.GetCustomerAllOrdersDTO;
import com.app.dto.SignupRequest;
import com.app.dto.SignupResponse;
import com.app.dto.TrackOrderDTO;
import com.app.dto.UpdateEmpDTO;
import com.app.entities.Orders;
import com.app.service.CustomerService;
import com.app.service.EmpService;
import com.app.service.OrdersService;

import io.swagger.v3.oas.annotations.Parameter;

@RestController

@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private OrdersService ordersService;

	@GetMapping("/{Id}")
	public ResponseEntity<?> getCustomerOrders(@PathVariable Long Id) {

		List<GetCustomerAllOrdersDTO> getCustomerAllOrdersDTOList = customerService.getCustomerOrders(Id);

		if (getCustomerAllOrdersDTOList == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "Data not found!"));
		}

		return ResponseEntity.status(HttpStatus.OK).body(getCustomerAllOrdersDTOList);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> hireEmployee(@RequestBody @Valid SignupRequest request) {
		System.out.println("in hire emp" + request);
		// invoke Service layer
		customerService.addCustomer(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, "customer Registered"));

	}
	


	@PostMapping("/signIn")
	public ResponseEntity<?> logInUser(@RequestBody AuthCustomerRequestDto request) {
		System.out.println("in sign in " + request);

		AuthCustomerRespDto authRespDto = null;
		authRespDto = customerService.logInUser(request);

		if (authRespDto != null) {
			return ResponseEntity.status(HttpStatus.OK).body(authRespDto);
		}
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(false, "customer Not Found"));
	}
	

	@GetMapping("/customerdetails/{customerId}")
	public ResponseEntity<?> getCustomeretails(@PathVariable Long customerId) {

		AuthCustomerRespDto customerDTO = customerService.getCustomerDetailsbyId(customerId);

		if (customerDTO == null) {

			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(false, "customer not found!"));
		}

		return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateEmp(@RequestBody AuthCustomerRespDto  request) {

		customerService.updateCustomer(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, "Customer update"));
	}
	
	

}
