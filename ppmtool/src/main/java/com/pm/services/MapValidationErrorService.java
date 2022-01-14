package com.pm.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Service
public class MapValidationErrorService {

	public ResponseEntity<Map<String,String>> getErrorMapMessage(BindingResult result){
		if(result.hasErrors()) {
			Map<String, String> erroMsgMap = new HashMap<>();
			for(FieldError fieldError : result.getFieldErrors()) {
				erroMsgMap.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return new ResponseEntity<Map<String,String>>(erroMsgMap,HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
