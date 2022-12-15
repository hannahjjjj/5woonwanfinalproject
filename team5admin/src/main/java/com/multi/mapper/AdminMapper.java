package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.AdminDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface AdminMapper extends MyMapper<String,AdminDTO>{
	public List<AdminDTO> myprofit(String id) throws Exception;
	public List<AdminDTO> newcust(String id) throws Exception;
	public List<AdminDTO> genderratio(String id) throws Exception;
	public List<AdminDTO> insnewcust(String id) throws Exception;
	public List<AdminDTO> insgenderratio(String id) throws Exception;
	public AdminDTO deleteins(int instructorid) throws Exception;
}