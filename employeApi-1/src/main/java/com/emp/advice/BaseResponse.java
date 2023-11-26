package com.emp.advice;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class BaseResponse<T> {

	String message;
	String status;
	Map<String, Object> respMap;
	
}