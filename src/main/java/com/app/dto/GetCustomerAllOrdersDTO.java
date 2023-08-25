package com.app.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

import com.app.entities.Branch;
import com.app.entities.Customer;
import com.app.entities.Orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetCustomerAllOrdersDTO {
	


	 private Long orderId;

			private double orderWeight;

		private String fromAddress;

		private String toAddress;

		private String orderStatus;
		
			private LocalDate orderedDate;
		   
		
			private LocalDate expectedDeliveryDate;
	
			private double amount;
		   
		
		   private String trackingId;
		   
		 
			private Long customerId;

      
		

		

}
