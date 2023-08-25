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
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddOrdersDTO;
import com.app.dto.ApiResp;
import com.app.dto.ApiResponse;
import com.app.dto.DeliveryboyDTO;
import com.app.dto.GetAllEmpDto;
import com.app.dto.GetCustomerAllOrdersDTO;
import com.app.dto.PassTrackIdDTO;
import com.app.dto.TrackOrderDTO;
import com.app.service.OrdersService;

@RestController

@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@PostMapping("/add")
	public ResponseEntity<?> hireEmployee(@RequestBody @Valid AddOrdersDTO request) {
		ordersService.addOrders(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, "User Registered"));

	}
	
	@GetMapping("/all/{branchId}")
	public ResponseEntity<?> getOrdersDetails(@PathVariable Long branchId) {

		List<DeliveryboyDTO> getAllDTOList = ordersService.getAllOrdersDetails(branchId);

		if (getAllDTOList == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "Data not found!"));
		}

		return ResponseEntity.status(HttpStatus.OK).body(getAllDTOList);
	}
	
	@PutMapping("delivered/{orderId}")
	public void changeOrderStatus(@PathVariable Long orderId){
	
	 ordersService.setOrderStatus(orderId);
	}
	
	@PutMapping("cancel/{orderId}")
	public void cancelOrderStatus(@PathVariable Long orderId){
	
	 ordersService. cancelOrderStatus(orderId);
	}
	
	@PostMapping("/track")
	public ResponseEntity<?> trackOrders(@RequestBody PassTrackIdDTO trackingId) {
		
		 //String trackId = String.valueOf(trackingId);

		TrackOrderDTO trackOrders = ordersService.trackOrders(trackingId);

		if (trackOrders == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "Data not found!"));
		}

		return ResponseEntity.status(HttpStatus.OK).body(trackOrders);
	}
	
}
