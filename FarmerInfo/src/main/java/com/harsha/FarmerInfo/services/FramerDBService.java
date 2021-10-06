package com.harsha.FarmerInfo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harsha.FarmerInfo.beans.FarmerInfoRequest;
import com.harsha.FarmerInfo.entity.FarmerInfoEntity;
import com.harsha.FarmerInfo.repository.FarmerInfoRepository;

@Service
public class FramerDBService {
	@Autowired
	private FarmerInfoRepository farmerInfoRepository;

	public boolean saveFarmerDetails(FarmerInfoRequest farmerInfoRequest) {

		FarmerInfoEntity entity = new FarmerInfoEntity();
		entity.setName(farmerInfoRequest.getName());
		entity.setState(farmerInfoRequest.getAge());

		FarmerInfoEntity resEntity = farmerInfoRepository.saveAndFlush(entity);

		return resEntity != null ? true : false;

	}

	public List<FarmerInfoEntity> getAll() {
		List<FarmerInfoEntity> entities = farmerInfoRepository.findAll();
		return entities;

	}
}
