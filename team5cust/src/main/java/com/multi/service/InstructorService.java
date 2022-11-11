package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.InstructorDTO;
import com.multi.frame.MyService;
import com.multi.mapper.InstructorMapper;

@Service
public class InstructorService implements MyService<Integer, InstructorDTO>{
	
	@Autowired
	InstructorMapper mapper;
	
	@Override
	public void register(InstructorDTO v) throws Exception {
		// TODO Auto-generated method stub
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		mapper.delete(k);
	}

	@Override
	public void modify(InstructorDTO v) throws Exception {
		// TODO Auto-generated method stub
		mapper.update(v);
	}

	@Override
	public InstructorDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return mapper.select(k);
	}

	@Override
	public List<InstructorDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}
	public List<InstructorDTO> selectFacilityList(int facilityid) throws Exception{
		return mapper.selectFacilityList(facilityid);
	}
	}
