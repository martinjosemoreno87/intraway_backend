package com.intraway.demo.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intraway.demo.exception.BadRequestException;
import com.intraway.demo.mapper.FizzBuzzMapper;
import com.intraway.demo.model.CommonConstant;
import com.intraway.demo.model.FizzBuzz;
import com.intraway.demo.model.FizzBuzzAction;
import com.intraway.demo.model.FizzBuzzResponse;
import com.intraway.demo.repository.FizzBuzzActionRepository;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

	@Autowired
	private FizzBuzzActionRepository fizzBuzzRepository;

	@Autowired
	private FizzBuzzMapper fizzBuzzMapper;

	@Override
	public FizzBuzzResponse generateCode(Integer min, Integer max) throws BadRequestException {

		if (min > max) {
			throw new BadRequestException(min, max);
		}

		List<String> results = IntStream.rangeClosed(min, max).boxed().map(item -> {

			if ((item % 3 == 0) && (item % 5 == 0)) {
				return CommonConstant.FIZZ_BUZZ;
			} else if (item % 3 == 0) {
				return CommonConstant.FIZZ;
			} else if (item % 5 == 0) {
				return CommonConstant.BUZZ;
			} else {
				return String.valueOf(item);
			}
		}).collect(Collectors.toList());

		FizzBuzz fizzBuzz = generateResonse(results);
		FizzBuzzAction fizzBuzzAction = FizzBuzzAction.builder()
				.min(min)
				.max(max)
				.build();
		
		fizzBuzzRepository.save(fizzBuzzAction);
		
		return fizzBuzzMapper.fizzBuzzToFizzBuzzBean(fizzBuzz);
	}

	private FizzBuzz generateResonse(List<String> results) {

		String description;
		Integer code;

		if (results.contains(CommonConstant.FIZZ_BUZZ)) {
			description = CommonConstant.MULTIPLE_OF_BOTH_MESSAGE;
			code = CommonConstant.MULTIPLE_OF_BOTH_CODE;
		} else if (results.contains(CommonConstant.FIZZ)) {
			description = CommonConstant.MULTIPLE_OF_THREE_MESSAGE;
			code = CommonConstant.MULTIPLE_OF_THREE_CODE;
		} else if (results.contains(CommonConstant.BUZZ)) {
			description = CommonConstant.MULTIPLE_OF_FIVE_MESSAGE;
			code = CommonConstant.MULTIPLE_OF_FIVE_CODE;
		} else {
			description = CommonConstant.NO_MULTIPLE_FOUND_MESSAGE;
			code = CommonConstant.NO_MULTIPLE_FOUND_CODE;
		}

		Date now = new Date();
		String codeFormatted = String.format("%03d", code);
		String list = results.stream()
				.collect(Collectors.joining(","));
		
		return FizzBuzz.builder()
			.timestamp(now.getTime())
			.code(codeFormatted)
			.description(description)
			.list(list)
			.build();
	}

}
