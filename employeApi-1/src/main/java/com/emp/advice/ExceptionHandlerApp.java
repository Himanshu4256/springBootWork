package com.emp.advice;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionHandlerApp {
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ApiResponse handleConstraintViolation(ConstraintViolationException ex) {
		String errMsg = ex.getMessage();
		ResponseEntity<String> b = ResponseEntity.internalServerError().body(ex.getMessage());
		
		
		ApiResponse api = new ApiResponse();
		//api.setMessage(ex);
		return api;
		
		
	//	String s = ex.getMessage();
		
		
		// return ResponseEntity.internalServerError().body(ex.getMessage());
		// return new ResponseEntity<>(errMsg,HttpStatus.BAD_REQUEST);
		
	}

	
	
	
	
	
//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<?> handleMethodArgsNotValidException(ConstraintViolationException ex){
//		BaseResponse<?> resp = new BaseResponse<>();
//		resp.setMessage("Sorry, An MethodArgumentNotValidException exception occured while processing the request: "+ ex);
//		resp.setStatus("500");
//		
//		Map<String, Object> respMap = new HashMap<>();
//		respMap.put("Exception: ", ex);
//		resp.setRespMap(respMap);
//		
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
//	}
		
	
	
	
	
	
//		@ExceptionHandler(ConstraintViolationException.class)
//		public ResponseEntity<String> handleConstraintViolation2(ConstraintViolationException ex) {
//			
//			return ResponseEntity.internalServerError().body(ex.getMessage());
//		}
}