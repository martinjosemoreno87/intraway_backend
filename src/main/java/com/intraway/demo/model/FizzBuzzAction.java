package com.intraway.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fizz_buzz_actions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FizzBuzzAction {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer min;
	
	private Integer max;
	
	@CreatedDate
    private LocalDateTime createdDate;
	
}
