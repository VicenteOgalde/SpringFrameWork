package com.vicoga.form.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vicoga.form.app.models.User;

@Component
public class UserValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//User user=(User)target;
		//ValidationUtils.rejectIfEmpty(errors, "name", "NotEmpty.user.name");
		
	}

}
