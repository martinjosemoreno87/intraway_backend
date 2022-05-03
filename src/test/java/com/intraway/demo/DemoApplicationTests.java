package com.intraway.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.intraway.demo.exception.BadRequestException;
import com.intraway.demo.model.CommonConstant;
import com.intraway.demo.model.FizzBuzzAction;
import com.intraway.demo.model.FizzBuzzResponse;
import com.intraway.demo.repository.FizzBuzzActionRepository;
import com.intraway.demo.service.FizzBuzzService;

@SpringBootTest
class DemoApplicationTests {

	@Mock
	FizzBuzzActionRepository fizzBuzzActionRepository;
	
	@Autowired
	FizzBuzzService fizzBuzzService;
	
	@Test
	void testMultipleOfBoth() throws BadRequestException {
		
		// Setup
		Integer min = 1;
		Integer max = 15;
		Date now = new Date();
		
		FizzBuzzResponse expectedResponse = FizzBuzzResponse.builder()
				.timestamp(now.getTime())
				.code(String.format("%03d", CommonConstant.MULTIPLE_OF_BOTH_CODE))
				.description(CommonConstant.MULTIPLE_OF_BOTH_MESSAGE)
				.build();
		
		FizzBuzzAction fizzBuzzAction = FizzBuzzAction.builder()
				.min(min)
				.max(max)
				.build();
		
		// when
		when(fizzBuzzActionRepository.save(any())).thenReturn(fizzBuzzAction);
		
		// then
		FizzBuzzResponse actualResponse = fizzBuzzService.generateCode(min, max);
		Assertions.assertEquals(expectedResponse.getCode(), actualResponse.getCode());
	}
	
	@Test
	void testMultipleOfThree() throws BadRequestException {
		
		// Setup
		Integer min = 3;
		Integer max = 5;
		Date now = new Date();
		
		FizzBuzzResponse expectedResponse = FizzBuzzResponse.builder()
				.timestamp(now.getTime())
				.code(String.format("%03d", CommonConstant.MULTIPLE_OF_THREE_CODE))
				.description(CommonConstant.MULTIPLE_OF_THREE_MESSAGE)
				.build();
		
		FizzBuzzAction fizzBuzzAction = FizzBuzzAction.builder()
				.min(min)
				.max(max)
				.build();
		
		// when
		when(fizzBuzzActionRepository.save(any())).thenReturn(fizzBuzzAction);
		
		// then
		FizzBuzzResponse actualResponse = fizzBuzzService.generateCode(min, max);
		Assertions.assertEquals(expectedResponse.getCode(), actualResponse.getCode());
	}
	
	@Test
	void testMultipleOfFive() throws BadRequestException {
		
		// Setup
		Integer min = 4;
		Integer max = 5;
		Date now = new Date();
		
		FizzBuzzResponse expectedResponse = FizzBuzzResponse.builder()
				.timestamp(now.getTime())
				.code(String.format("%03d", CommonConstant.MULTIPLE_OF_FIVE_CODE))
				.description(CommonConstant.MULTIPLE_OF_FIVE_MESSAGE)
				.build();
		
		FizzBuzzAction fizzBuzzAction = FizzBuzzAction.builder()
				.min(min)
				.max(max)
				.build();
		
		// when
		when(fizzBuzzActionRepository.save(any())).thenReturn(fizzBuzzAction);
		
		// then
		FizzBuzzResponse actualResponse = fizzBuzzService.generateCode(min, max);
		Assertions.assertEquals(expectedResponse.getCode(), actualResponse.getCode());
	}
	
	@Test
	void testNoMultipleFound() throws BadRequestException {
		
		// Setup
		Integer min = 1;
		Integer max = 2;
		Date now = new Date();
		
		FizzBuzzResponse expectedResponse = FizzBuzzResponse.builder()
				.timestamp(now.getTime())
				.code(String.format("%03d", CommonConstant.NO_MULTIPLE_FOUND_CODE))
				.description(CommonConstant.NO_MULTIPLE_FOUND_MESSAGE)
				.build();
		
		FizzBuzzAction fizzBuzzAction = FizzBuzzAction.builder()
				.min(min)
				.max(max)
				.build();
		
		// when
		when(fizzBuzzActionRepository.save(any())).thenReturn(fizzBuzzAction);
		
		// then
		FizzBuzzResponse actualResponse = fizzBuzzService.generateCode(min, max);
		Assertions.assertEquals(expectedResponse.getCode(), actualResponse.getCode());
	}
	
	@Test
	void testWrongRange() throws BadRequestException {
		
		// Setup
		Integer min = 6;
		Integer max = 2;
		
		Assertions.assertThrows(BadRequestException.class, () -> fizzBuzzService.generateCode(min, max));
	}
	
}
