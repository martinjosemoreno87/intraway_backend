package com.intraway.demo.mapper;

import org.mapstruct.Mapper;

import com.intraway.demo.model.FizzBuzz;
import com.intraway.demo.model.FizzBuzzResponse;

@Mapper(componentModel = "spring")
public interface FizzBuzzMapper {

	FizzBuzzResponse fizzBuzzToFizzBuzzBean(FizzBuzz fizzBuzz);

}
