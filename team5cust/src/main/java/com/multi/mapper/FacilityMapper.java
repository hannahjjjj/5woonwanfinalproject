package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.FacilityDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface FacilityMapper extends MyMapper<Integer,FacilityDTO>{
	public List<FacilityDTO> selectFacilityAll(int facilityid) throws Exception;
}