package com.multi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.dto.FacilityDTO;
import com.multi.frame.MyService;
import com.multi.mapper.FacilityMapper;

@Service
public class FacilityService implements MyService<Integer, FacilityDTO>{
	
	@Autowired
	FacilityMapper mapper;

	@Override
	public void register(FacilityDTO v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(FacilityDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public FacilityDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<FacilityDTO> get() throws Exception {
		return mapper.selectAll();
	}
	public List<FacilityDTO> selectFacilityAll(int cateid) throws Exception {
		return mapper.selectFacilityAll(cateid);
	}
	
	public List<FacilityDTO> viewFacilityName(int instructorid) throws Exception {
		return mapper.viewFacilityName(instructorid);
	}
	public List<FacilityDTO> searchFacility(String txt) throws Exception {
		return mapper.searchFacility(txt);
	}
	public FacilityDTO selectaddr(String addr) throws Exception {
		return mapper.selectaddr(addr);
	}

}
	
