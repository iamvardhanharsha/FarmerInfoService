package com.harsha.FarmerInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harsha.FarmerInfo.entity.FarmerInfoEntity;

@Repository
public interface FarmerInfoRepository extends JpaRepository<FarmerInfoEntity, Integer> {

}
