package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.CustbodyDTO;
import com.multi.frame.MyService;
import com.multi.mapper.CustbodyMapper;

@Service
public class CustbodyService implements MyService<Integer, CustbodyDTO>{
	
	@Autowired
	CustbodyMapper mapper;
	
	@Override
	public void register(CustbodyDTO v) throws Exception {
		// TODO Auto-generated method stub
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		mapper.delete(k);
	}
	
	@Override
	public void modify(CustbodyDTO v) throws Exception {
		// TODO Auto-generated method stub
		mapper.update(v);
	}

	@Override
	public CustbodyDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return mapper.select(k);
	}

	@Override
	public List<CustbodyDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}
	
	
	public List<CustbodyDTO> custbodyall(String custid) throws Exception {
		return mapper.custbodyall(custid);
	}
	
	
	}
