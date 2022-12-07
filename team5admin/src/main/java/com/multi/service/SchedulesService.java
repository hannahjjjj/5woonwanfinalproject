package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.SchedulesDTO;
import com.multi.frame.MyService;
import com.multi.mapper.SchedulesMapper;

@Service
public class SchedulesService implements MyService<Integer, SchedulesDTO>{
	@Autowired
	SchedulesMapper mapper;

	@Override
	public void register(SchedulesDTO v) throws Exception {
		// TODO Auto-generated method stub
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		mapper.delete(k);
	}

	@Override
	public void modify(SchedulesDTO v) throws Exception {
		// TODO Auto-generated method stub
		mapper.update(v);
	}

	@Override
	public SchedulesDTO get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return mapper.select(k);
	}

	@Override
	public List<SchedulesDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}
	
	public List<SchedulesDTO> selectday(String selectday,String insid) throws Exception{
		return mapper.selectday(selectday,insid);
	}
	
	public List<SchedulesDTO> myschedulelist(String selectday) throws Exception{
		return mapper.myschedulelist(selectday);
	}
	
}
