package com.pack.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pack.model.Account;
import com.pack.vo.AccountVO;


public class AccountValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return AccountVO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "role.required");
		
	}

}
