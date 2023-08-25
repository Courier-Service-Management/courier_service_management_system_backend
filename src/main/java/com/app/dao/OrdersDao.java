package com.app.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.dto.DeliveryboyDTO;
import com.app.dto.PassTrackIdDTO;
import com.app.entities.Orders;

public interface OrdersDao extends JpaRepository<Orders, Long> {

	@Query("select new com.app.entities.Orders(fromAddress,toAddress,expectedDeliveryDate, orderedDate) from Orders o where o.trackingId=?1")
	Orders fetchOrdersbyTrackingId(String trackingId);
}




