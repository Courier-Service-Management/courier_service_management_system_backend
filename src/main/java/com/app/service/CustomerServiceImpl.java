package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dao.CustomerDao;
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
import com.app.entities.Branch;
import com.app.entities.Customer;
import com.app.entities.Emp;
import com.app.entities.Orders;




@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	




	@Override
	public void addCustomer(SignupRequest request) {
	
		Customer customer=mapper.map(request, Customer.class);
	
		Customer customer1= customerDao.save(customer);

		
	}
	

	
	
	@Override
	public List<GetCustomerAllOrdersDTO> getCustomerOrders(Long cust_id){
		
		Customer customer = customerDao.findById(cust_id).orElse(null);
		
		List<Orders> ordersList = customer.getOrderlist();
		
		

		
		return ordersList.stream().map(order -> mapper.map(order, GetCustomerAllOrdersDTO.class)).collect(Collectors.toList());
		
	}
	
	@Override
	public AuthCustomerRespDto logInUser(AuthCustomerRequestDto req) {
		AuthCustomerRespDto respUser = null;
		Customer customer = customerDao.findByEmail(req.getEmail()).orElseThrow(null);
		AuthCustomerRespDto response= mapper.map(customer,AuthCustomerRespDto.class);
		return response;
//		if (customer != null) {
//			boolean flag = passwordEncoder.matches(req.getPassword(), customer.getPassword());
//			if (flag) {
//				 respUser = mapper.map(customer, AuthCustomerRespDto.class);
//			}
//		}
//		return respUser;
//	}


	}
	
	@Override
	public AuthCustomerRespDto getCustomerDetailsbyId(Long customerId) {
		Customer customer = customerDao.findById(customerId).orElseThrow(null);
		AuthCustomerRespDto response = mapper.map(customer, AuthCustomerRespDto.class);
		
		return response;
	}


	@Override
	public AuthCustomerRespDto updateCustomer(AuthCustomerRespDto request) {

		Customer customer = customerDao.findById(request.getCustomerId()).orElseThrow(() -> new RuntimeException("customer not found!"));
		customer.setCustomerId(request.getCustomerId());
		customer.setFirstName(request.getFirstName());
		customer.setLastName(request.getLastName());
		customer.setEmail(request.getEmail());
		customer.setMobile(request.getMobile());
		customer.setPassword(request.getPassword());
		customer.setGender(request.getGender());
		
		

		Customer customerRes = customerDao.save(customer);
		return mapper.map(customerRes, AuthCustomerRespDto.class);

	}

}
