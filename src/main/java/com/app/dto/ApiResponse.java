package com.app.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class ApiResponse {
	
	 public boolean status;
	    public String message;

	    public ApiResponse() {
	        status = false;
	        message = "";
	    }

	    public ApiResponse(boolean status, String message) {
	        this.status = status;
	        this.message = message;
	    }
}
