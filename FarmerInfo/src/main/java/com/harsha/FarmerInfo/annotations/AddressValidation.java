package com.harsha.FarmerInfo.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.harsha.FarmerInfo.validation.AddressValidationImpl;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { AddressValidationImpl.class })
@Documented
public @interface AddressValidation {
	String message() default "Invalid Address";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
