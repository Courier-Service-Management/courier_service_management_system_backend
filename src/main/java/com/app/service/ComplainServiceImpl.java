package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BranchDao;
import com.app.dao.ComplainDao;
import com.app.dao.OrdersDao;
import com.app.dto.AddBranchDTO;
import com.app.dto.AddComplainDTO;
import com.app.dto.AddEmpResponse;
import com.app.entities.Branch;
import com.app.entities.Complain;
import com.app.entities.Emp;
import com.app.entities.Orders;


@Service
@Transactional
public class ComplainServiceImpl implements ComplainService {
	
	
	@Autowired
	private ComplainDao complainDao;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private OrdersDao ordersDao;
	
	@Override
	public AddComplainDTO addComplain(AddComplainDTO request) {
	
		Complain complain = mapper.map(request, Complain.class);
		Orders orders= ordersDao.getReferenceById(request.getOrderId());
		complain.setOrders(orders);
		Complain complain2 = complainDao.save(complain);
		// map entity-> Dao
		return mapper.map(complain2, AddComplainDTO.class);
	}

}
