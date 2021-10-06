package com.harsha.FarmerInfo.beans;

import java.util.List;

import lombok.Data;

@Data
public class ValidationError {
	private List<Errors> errors;

}
