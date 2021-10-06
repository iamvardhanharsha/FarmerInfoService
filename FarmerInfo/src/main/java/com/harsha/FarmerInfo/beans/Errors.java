package com.harsha.FarmerInfo.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Errors {
	private String errorfield;
	private String errorMessage;
}
