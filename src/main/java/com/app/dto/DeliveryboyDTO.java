package com.app.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//c.first_name, c.last_name, c.email, c.mobile, o.order_weight, o.expected_delivery_date_date, o.ordered_date, o.order_status, o.from_address, o.to_address, o.amount
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryboyDTO {
	
	// customer properties
   private Long empId;
	private String firstName;

	private String lastName;

	private String email;
	
	private String mobile;
	
	// order properties
    private int orderId;
    
	private double orderWeight;

	private LocalDate expectedDeliveryDate;

	private LocalDate orderedDate;

	private String orderStatus;

	private String fromAddress;

	private String toAddress;

	private double amount;

}
