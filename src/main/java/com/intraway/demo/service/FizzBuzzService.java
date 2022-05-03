package com.intraway.demo.service;

import com.intraway.demo.exception.BadRequestException;
import com.intraway.demo.model.FizzBuzzResponse;

public interface FizzBuzzService {

	FizzBuzzResponse generateCode(Integer min, Integer max) throws BadRequestException;

}
