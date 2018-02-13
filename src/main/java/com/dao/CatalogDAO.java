package com.dao;

import java.util.List;

import com.domain.Catalog;

public interface  CatalogDAO {
		
		int add(Catalog catalog);
		
		List<Catalog> listCatalog(Integer childNode);
		
	}
