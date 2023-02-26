package com.vicoga.error.app.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {
	
	@ExceptionHandler(ArithmeticException.class)
	public String arithmeticError(Exception ex, Model model) {
		model.addAttribute("error","-=Arithmetic Error=-");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		return"/error/arithmetic";
	}
	@ExceptionHandler(NumberFormatException.class)
	public String numberFormatException(Exception ex, Model model) {
		model.addAttribute("error","-=Number Format Error=-");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		return"/error/number-format";
	}

}
