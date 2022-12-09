package com.database.onlinefood.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
	
	private double amount;
	private int invoiceNumber;
	private String date;
	private String description;
	private int orderId;
	
}
