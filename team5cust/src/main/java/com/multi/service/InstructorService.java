package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.InstructorDTO;
import com.multi.frame.MyService;

@Service
public class InstructorService implements MyService<Integer, InstructorDTO>{
	
	@Autowired
	InstructorDTO mapper;
	
	@Override
	public void register(InstructorDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(InstructorDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InstructorDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InstructorDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	}
