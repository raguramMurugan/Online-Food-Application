package com.database.onlinefood.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseOrderDto {
	
	private double totalamount;
	private Integer invoicenumber;
	private String suggestion;
	private Integer orderid;

}
