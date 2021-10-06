package com.harsha.FarmerInfo.helpers;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.harsha.FarmerInfo.beans.FarmerInfoRequest;
import com.harsha.FarmerInfo.beans.FarmerInfoResponse;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FarmerHealper {

	@Autowired
	FarmerInfoResponse farmerInfoResponse;

	public FarmerInfoResponse prepareFormerInfoResponse(FarmerInfoRequest farmerInfoRequest) {

		try {
			if (farmerInfoRequest.getName().equals("harsha")) {

				throw new FileNotFoundException();
			}
		} catch (Throwable e) {

		}
		farmerInfoResponse.setDescription("no");
		farmerInfoResponse.setResponseCode("000");

		log.info("Farmer response {}", farmerInfoResponse);
		return farmerInfoResponse;
	}

}
