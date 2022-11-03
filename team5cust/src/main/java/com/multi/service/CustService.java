package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.CustDTO;
import com.multi.dto.FacilityDTO;
import com.multi.frame.MyService;
import com.multi.mapper.CustMapper;

@Service
public class CustService implements MyService<String,CustDTO>{
	
	@Autowired
	CustMapper mapper;

	@Override
	public void register(CustDTO v) throws Exception {
		// TODO Auto-generated method stub
		mapper.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		// TODO Auto-generated method stub
		mapper.delete(k);
	}

	@Override
	public void modify(CustDTO v) throws Exception {
		// TODO Auto-generated method stub
		mapper.update(v);
	}

	@Override
	public CustDTO get(String k) throws Exception {
		// TODO Auto-generated method stub
		return mapper.select(k);
	}

	@Override
	public List<CustDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

}
	
