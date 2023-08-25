package com.app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="complain")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Complain {
	 @Id 
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	     @Column(name = "complain_id")
	 private Long complainId;
	 @Enumerated(EnumType.STRING)
	 @Column (length=50)
	 private Issue issue;
	 @Column (length=50)
	 private String description;
	@OneToOne
	@JoinColumn (name= "order_id")
	 private Orders orders;
	
}

