package com.harsha.FarmerInfo.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApplicationException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private String errorCode;

	public ApplicationException(String errorMessage, String errorCode) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

}
