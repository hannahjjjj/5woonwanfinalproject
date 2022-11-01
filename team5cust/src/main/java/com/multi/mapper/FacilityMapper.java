package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.FacilityDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface FacilityMapper extends MyMapper<Integer,FacilityDTO>{
}