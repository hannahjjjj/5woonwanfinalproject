package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.dto.ItemDTO;
import com.multi.frame.MyMapper;

@Repository
@Mapper
public interface ItemMapper extends MyMapper<Integer, ItemDTO>{
	public List<ItemDTO> selecttype1() throws Exception;
	public List<ItemDTO> selecttype2() throws Exception;
	public List<ItemDTO> selecttype3() throws Exception;
	public List<ItemDTO> selecttype4() throws Exception;
	public List<ItemDTO> selectItemList(int instructorid) throws Exception;
}
