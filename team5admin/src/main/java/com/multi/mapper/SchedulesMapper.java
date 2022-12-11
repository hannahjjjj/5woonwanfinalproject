package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.SchedulesDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface SchedulesMapper extends MyMapper<Integer,SchedulesDTO>{
	public List<SchedulesDTO> selectdayadmin(String selectday,String aid) throws Exception;
	
	public List<SchedulesDTO> selectdayins(String selectday,String instructorid) throws Exception;
	
	public List<SchedulesDTO> myschedulelist(String aid) throws Exception;

	public List<SchedulesDTO> insschedulelist(String instructorid) throws Exception;
}