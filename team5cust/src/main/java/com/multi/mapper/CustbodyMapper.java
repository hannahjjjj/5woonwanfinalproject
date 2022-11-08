package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.CartDTO;
import com.multi.dto.CustbodyDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface CustbodyMapper extends MyMapper<Integer,CustbodyDTO>{

	List<CustbodyDTO> custbodyall(String custid);

}