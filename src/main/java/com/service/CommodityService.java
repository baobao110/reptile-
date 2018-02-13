package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CommodityDAO;
import com.domain.Commodity;

@Service
public class CommodityService {
	
	@Autowired
	private CommodityDAO dao;
	
	public void save(Commodity commo) {
			dao.add(commo);
	}
}