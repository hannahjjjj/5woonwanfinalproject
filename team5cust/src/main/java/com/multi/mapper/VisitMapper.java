package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.VisitDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface VisitMapper extends MyMapper<Integer, VisitDTO>{
	
}
