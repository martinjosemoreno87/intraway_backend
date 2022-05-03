package com.intraway.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.intraway.demo.model.FizzBuzzAction;

public interface FizzBuzzActionRepository extends PagingAndSortingRepository<FizzBuzzAction, Long> {

}
