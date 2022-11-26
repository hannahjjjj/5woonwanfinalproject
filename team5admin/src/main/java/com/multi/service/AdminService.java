package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.AdminDTO;
import com.multi.frame.MyService;
import com.multi.mapper.AdminMapper;

@Service
public class AdminService implements MyService<String,AdminDTO>{
	
	@Autowired
	AdminMapper mapper;

	@Override
	public void register(AdminDTO v) throws Exception {
		// TODO Auto-generated method stub
		mapper.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		// TODO Auto-generated method stub
		mapper.delete(k);
	}

	@Override
	public void modify(AdminDTO v) throws Exception {
		// TODO Auto-generated method stub
		mapper.update(v);
	}

	@Override
	public AdminDTO get(String k) throws Exception {
		// TODO Auto-generated method stub
		return mapper.select(k);
	}

	@Override
	public List<AdminDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}
	
	/*
	 * public AdminDTO selectkakkoid(String kakkoid) throws Exception{ return
	 * mapper.selectkakkoid(kakkoid); }
	 */

}
	
