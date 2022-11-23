package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.OrdersDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface OrdersMapper extends MyMapper<Integer, OrdersDTO> {

	public List<OrdersDTO> orderall(String custid) throws Exception;
	public List<OrdersDTO> mymembership(String custid) throws Exception;
}
