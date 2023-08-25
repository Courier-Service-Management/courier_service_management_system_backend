package com.app.service;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.dao.BranchDao;
import com.app.dao.CustomerDao;
import com.app.dao.EmpDao;
import com.app.dao.OrdersDao;
import com.app.dto.AddEmpRequest;
import com.app.dto.AddEmpResponse;
import com.app.dto.AddOrdersDTO;
import com.app.dto.DeliveryboyDTO;
import com.app.dto.GetAllEmpDto;
import com.app.dto.GetCustomerAllOrdersDTO;
import com.app.dto.PassTrackIdDTO;
import com.app.dto.TrackOrderDTO;
import com.app.entities.Branch;
import com.app.entities.Customer;
import com.app.entities.Emp;
import com.app.entities.Orders;


@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
	

	@Autowired
	private OrdersDao ordersDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private BranchDao branchDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	 private AtomicLong counter = new AtomicLong(0);

	    public String uniqueValue() {
	        long timestamp = System.currentTimeMillis();
	        long uniqueCounter = counter.getAndIncrement();
	        return timestamp + "_"+uniqueCounter;
	    }
	      
	       


	      @Override
	     public void addOrders(AddOrdersDTO request) {
	    	  
	    	  OrdersServiceImpl generator = new OrdersServiceImpl();

		Orders orders = mapper.map(request, Orders.class);
		Branch branch = branchDao.getReferenceById(request.getBranchId());
		orders.setBranchs(branch);
		Customer customer = customerDao.getReferenceById(request.getCustomerId());
		orders.setCustomer(customer);
		orders.setOrderedDate(LocalDate.now());
		orders.setAmount(orders.getOrderWeight() * 5);
		orders.setExpectedDeliveryDate(LocalDate.now().plusDays(7));
		orders.setOrderStatus("pending");
		//orders.setTrackingId(new Date()+"ab$?"+new Date());
		orders.setTrackingId(generator.uniqueValue());
		

		Orders orders2 = ordersDao.save(orders);

		
	}



	public List<DeliveryboyDTO> getAllOrdersDetails(Long branchId) {

		Branch branch = branchDao.findById(branchId).orElse(null);

		List<Orders> orderList = branch.getOrderlist();

		List<DeliveryboyDTO> listDTO = new ArrayList<>();

		for (Orders order : orderList) {

			DeliveryboyDTO dto = mapper.map(order, DeliveryboyDTO.class);

			dto.setFirstName(order.getCustomer().getFirstName());
			dto.setLastName(order.getCustomer().getLastName());
			dto.setEmail(order.getCustomer().getEmail());
			dto.setMobile(order.getCustomer().getMobile());
            
			listDTO.add(dto);

		}

		return listDTO;
	}
	
	public void  setOrderStatus(Long orderId) {
		Orders order = ordersDao.findById(orderId).orElseThrow(null);
	    order.setOrderStatus("Delivered");
		
	}
	
	public void  cancelOrderStatus(Long orderId) {
		Orders order = ordersDao.findById(orderId).orElseThrow(null);
	    order.setOrderStatus("Cancel");
		
	}
	public  TrackOrderDTO trackOrders(PassTrackIdDTO trackingId){
		Orders orders= ordersDao.fetchOrdersbyTrackingId(trackingId.getTrackingId());
		
		
		TrackOrderDTO trackOrderDTO = mapper.map(orders, TrackOrderDTO.class);
		
		return trackOrderDTO;
		
	}
}

