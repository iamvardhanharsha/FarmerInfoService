package com.harsha.FarmerInfo.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.harsha.FarmerInfo.beans.ErrorResponse;
import com.harsha.FarmerInfo.beans.Errors;
import com.harsha.FarmerInfo.beans.ValidationError;

@RestControllerAdvice
public class CenteralExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> handleValidationExceptions(MethodArgumentNotValidException e) {
		BindingResult bindingResults = e.getBindingResult();

		List<FieldError> fielderror = bindingResults.getFieldErrors();
		List<Errors> errors = new ArrayList<>();
		fielderror.stream().forEach(x -> {

			errors.add(new Errors(x.getField(), x.getDefaultMessage()));
		});
		ValidationError validationError = new ValidationError();

		validationError.setErrors(errors);
		ResponseEntity<ValidationError> responseEntity = new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ErrorResponse> handleValidationExceptions(ApplicationException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatusCode(e.getErrorCode());
		errorResponse.setDescription(e.getMessage() + "  ======" + e.getMessage());
		ResponseEntity<ErrorResponse> responseEntity = new ResponseEntity<ErrorResponse>(errorResponse,
				HttpStatus.INTERNAL_SERVER_ERROR);
		return responseEntity;
	}

}
