package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.VisitDTO;
import com.multi.frame.MyService;
import com.multi.mapper.VisitMapper;

@Service
public class VisitService implements MyService<Integer, VisitDTO> {

	@Autowired
	VisitMapper mapper;

	@Override
	public void register(VisitDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(VisitDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public VisitDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<VisitDTO> get() throws Exception {
		return mapper.selectAll();
	}


}
