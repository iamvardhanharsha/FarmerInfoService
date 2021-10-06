package com.harsha.FarmerInfo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;

import com.harsha.FarmerInfo.annotations.AddressValidation;

public class AddressValidationImpl implements ConstraintValidator<AddressValidation, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isBlank(value)) {
			return false;
		}
		return true;
	}

}
