package com.intraway.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intraway.demo.model.BadRequest;
import com.intraway.demo.model.CommonConstant;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler
	@ResponseBody
	public ResponseEntity<BadRequest> handleBadRequesttException(BadRequestException e) {
		
		Date now = new Date();
		
		BadRequest badRequest = BadRequest.builder()
			.timestamp(now.getTime())
			.status(400)
			.error("Bad Request")
			.exception("com.intraway.exceptions.badrequest")
			.message(CommonConstant.WRONG_RANGE_MESSAGE)
			.path("/intraway/api/fizzbuzz/" + e.getMin() + "/" + e.getMax())
			.build();
		
		return new ResponseEntity<>(badRequest, HttpStatus.BAD_REQUEST);
	}
}