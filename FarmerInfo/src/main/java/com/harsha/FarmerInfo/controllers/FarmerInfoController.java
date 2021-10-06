package com.harsha.FarmerInfo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsha.FarmerInfo.beans.FarmerInfoRequest;
import com.harsha.FarmerInfo.beans.FarmerInfoResponse;
import com.harsha.FarmerInfo.entity.FarmerInfoEntity;
import com.harsha.FarmerInfo.helpers.FarmerHealper;
import com.harsha.FarmerInfo.services.FramerDBService;

@RestController
@RequestMapping(path = "/FarmerInfo")
@CrossOrigin

public class FarmerInfoController {

	@Autowired
	private FarmerHealper farmerHealper;
	@Autowired
	private FramerDBService farmerDbService;

	@GetMapping(path = "/HealthCheck")
	public ResponseEntity<String> healthCheck() {

		return new ResponseEntity<String>("health check is up", HttpStatus.OK);

	}

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<FarmerInfoEntity>> getAll() {
		List<FarmerInfoEntity> entitys = farmerDbService.getAll();
		return new ResponseEntity<List<FarmerInfoEntity>>(entitys, HttpStatus.OK);

	}

	@GetMapping(path = "/welcome/{message}")
	public ResponseEntity<String> healthCheck(@PathVariable String message) {
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

	@PostMapping(path = "/SaveFarmerInfo")
	public ResponseEntity<FarmerInfoResponse> saveFarmerInfo(@Valid @RequestBody FarmerInfoRequest farmerInfoRequest)
			throws Exception {

		farmerDbService.saveFarmerDetails(farmerInfoRequest);

		FarmerInfoResponse farmerInfoResponse = farmerHealper.prepareFormerInfoResponse(farmerInfoRequest);
		ResponseEntity<FarmerInfoResponse> responseEntity = new ResponseEntity<>(farmerInfoResponse, HttpStatus.OK);

		return responseEntity;

	}

}
