package com.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.app.entities.Branch;
import com.app.entities.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddOrdersDTO {

	
	
	 

	    private double orderWeight;

		private String fromAddress;

		private String toAddress;

		private Long customerId;

      private Long branchId;
}
