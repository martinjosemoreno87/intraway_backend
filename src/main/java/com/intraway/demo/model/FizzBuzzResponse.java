package com.intraway.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FizzBuzzResponse {

	private Long timestamp;
	
	private String code;
	
	private String description;
	
	private String list;

}
