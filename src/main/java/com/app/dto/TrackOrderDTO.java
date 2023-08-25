package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Issue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TrackOrderDTO {
	
	 private String fromAddress;

	 private String toAddress;

	 private LocalDate expectedDeliveryDate;

	 private LocalDate orderedDate;

}
