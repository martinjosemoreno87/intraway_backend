package com.intraway.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intraway.demo.exception.BadRequestException;
import com.intraway.demo.model.FizzBuzzResponse;
import com.intraway.demo.service.FizzBuzzService;

@RestController
@RequestMapping("/intraway/api/fizzbuzz/")
@CrossOrigin(origins = "http://localhost:4200")
public class FizzBuzzController {
    
	@Autowired
	private FizzBuzzService fizzBuzzService;
	
	@GetMapping("/{min}/{max}")
    public FizzBuzzResponse generateCode(@PathVariable Integer min, @PathVariable Integer max) throws BadRequestException{
		return fizzBuzzService.generateCode(min, max);
    }
}
