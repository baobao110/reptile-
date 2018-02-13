package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CatalogDAO;
import com.domain.Catalog;
import com.task.ChildCatalogTask;
import com.thread.ThreadPools;

@Service
public class CatalogService {
	
	@Autowired
	private CatalogDAO dao;
	
	public void add(Catalog catalog) {
		dao.add(catalog);
	}
	
	public void queryChildCatalog() {
		List<Catalog> lists=dao.listCatalog(1);
		for(Catalog list:lists) {
			/*System.out.println(list);*/
			ThreadPools.childCatalog.execute(new ChildCatalogTask(list));//进入线程池多线程遍历各目录内容
		}
	}

}
