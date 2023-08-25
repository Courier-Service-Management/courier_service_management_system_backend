package com.app.service;

import java.util.List;

import com.app.dto.AddEmpRequest;
import com.app.dto.AddEmpResponse;
import com.app.dto.AuthCustomerRequestDto;
import com.app.dto.AuthCustomerRespDto;
import com.app.dto.AuthRequestDto;
import com.app.dto.AuthRespDto;
import com.app.dto.GetAllEmpDto;
import com.app.dto.GetCustomerAllOrdersDTO;
import com.app.dto.SignupRequest;
import com.app.dto.SignupResponse;
import com.app.dto.UpdateEmpDTO;
import com.app.entities.Orders;

public interface CustomerService {
	

	void addCustomer(SignupRequest request);
	
	
	List<GetCustomerAllOrdersDTO> getCustomerOrders(Long cust_id);
	AuthCustomerRespDto logInUser(AuthCustomerRequestDto req);
	
	AuthCustomerRespDto updateCustomer(AuthCustomerRespDto request);
		
		
	AuthCustomerRespDto getCustomerDetailsbyId(Long customerId);
}
