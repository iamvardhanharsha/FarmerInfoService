package com.harsha.FarmerInfo.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class FarmerInfoRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "applicationId should not be emty")
	private String applicationId;

	@NotBlank(message = "channel should not be emty")
	private String channel;

	@NotBlank(message = "name should not be emty")
	@Size(min = 2, max = 45, message = "size of name should be 2-45")
	private String name;

	@NotBlank(message = "age should be between 28 to 60")
	private String age;

	private Address address;
	@NotBlank(message = "phoneNumber can not be emty")
	private String phoneNumber;
	@NotBlank(message = "email can not be emty")
	private String email;

}
