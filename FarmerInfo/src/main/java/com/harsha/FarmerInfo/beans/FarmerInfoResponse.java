package com.harsha.FarmerInfo.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
public class FarmerInfoResponse {
	String responseCode;
	String description;

}
