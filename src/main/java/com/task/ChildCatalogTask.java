package com.task;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.domain.Catalog;
import com.thread.ThreadPools;
import com.util.ApiConnector;
import com.util.SleepUtils;

public class ChildCatalogTask implements Runnable {
	
	private Catalog catalog;
	
	public ChildCatalogTask(Catalog catalog) {
		this.catalog = catalog;
	}
	

	public void run() {
		// TODO Auto-generated method stub
		String host = "https://read.douban.com";
		String url = "/kind/" + catalog.getCatalogNum();
		String query = "";
		
		for (int start = 0; start < 50; start+=20) {
			
			try {
				Thread.sleep(SleepUtils.getMill());//休眠
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			query = "?start=" + start + "sort=hot&promotion_only=False";//遍历循环图书的url地址
			
			String commoditysDocument = ApiConnector.get(host + url + query);
			
			Elements eles = Jsoup.parse(commoditysDocument).select("ul.list-lined.ebook-list.column-list").select("li");
			for (Element el : eles) {
				String bookInfoUrl = el.select("div.info").select("div.title").select("a").first().attr("href");
				/*System.out.println(">>>>>>" + bookInfoUrl);*/
				
				ThreadPools.commodityInfo.execute(new CommontidyTask(bookInfoUrl, catalog));
			}
		}
		
	}

}
