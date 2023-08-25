package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.dto.AddEmpRequest;
import com.app.dto.AddEmpResponse;
import com.app.dto.AddOrdersDTO;
import com.app.dto.DeliveryboyDTO;
import com.app.dto.GetAllEmpDto;
import com.app.dto.GetCustomerAllOrdersDTO;
import com.app.dto.PassTrackIdDTO;
import com.app.dto.TrackOrderDTO;
import com.app.entities.Orders;

public interface OrdersService {

	void addOrders(AddOrdersDTO request);

	List<DeliveryboyDTO> getAllOrdersDetails(Long branchId);
	
	     public void setOrderStatus(Long orderId);
	     
	     public void cancelOrderStatus(Long orderId);
	     TrackOrderDTO trackOrders(PassTrackIdDTO trackingId);
	

}
