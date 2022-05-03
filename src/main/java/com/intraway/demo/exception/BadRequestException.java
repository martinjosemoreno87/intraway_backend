package com.intraway.demo.exception;

public class BadRequestException extends Exception {

	private static final long serialVersionUID = 8635620827291173184L;

	private Integer min;
	private Integer max;

	public BadRequestException(Integer min, Integer max) {
		this.min = min;
		this.max = max;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getMin() {
		return min;
	}

	public Integer getMax() {
		return max;
	}

}
