package com.app.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;
	
	@Column
	private double orderWeight;
	
	@Column(length = 50)
	private String fromAddress;
	
	@Column(length = 50)
	private String toAddress;
	
	@Column(length = 50)
	private String orderStatus;
	
	@Column(length = 20)
	private LocalDate orderedDate;

	@Column(length = 20)
	private LocalDate expectedDeliveryDate;
	
	@Column
	private double amount;

     @Column
	private String trackingId;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "branch_id")
	private Branch branchs;
	
	
	   public Orders(String fromAddress, String toAddress, LocalDate expectedDeliveryDate, LocalDate orderedDate) {
	        this.fromAddress = fromAddress;
	        this.toAddress = toAddress;
	        this.expectedDeliveryDate = expectedDeliveryDate;
	        this.orderedDate = orderedDate;
	    }
}
