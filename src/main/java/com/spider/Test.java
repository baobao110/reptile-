package com.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.domain.Catalog;
import com.service.CatalogService;
import com.util.ApiConnector;
import com.util.BeanUtils;
import com.util.SleepUtils;

public class Test {
	
	public static void main(String[] args) {
//		getCatalog ();//这个方法是遍历一二级目录
		doTask();//这里是为了爬虫内容
	}
	
	public static void getCatalog () {
		String host = "https://read.douban.com";
		String url = "/kind/100";
		
		CatalogService catalogService = BeanUtils.getBean(CatalogService.class);
		String htmlDocument = ApiConnector.get(host + url);
		Elements eles = Jsoup.parse(htmlDocument).select("ul").select("li.nav-item.foldable");//用Jsoup选择器获取一级目录下面是遍历
		
		for (Element el : eles) {
			String parentCatalogName = el.select("a").first().text();
			try {
				Thread.sleep(SleepUtils.getMill());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String parentUrl = el.select("a").first().attr("href");
			String parentCatalogNum = parentUrl.split("\\/")[2];
			
		/*	System.out.println("一级目录" + parentCatalogName + " " + parentCatalogNum);//这里是获取一级目录
*/			
			//保存一级目录
			Catalog parentCatalog = new Catalog();
			parentCatalog.setCatalogName(parentCatalogName);
			parentCatalog.setCatalogNum(parentCatalogNum);
			parentCatalog.setChildNode(0);//0代表有子目录
			parentCatalog.setParentNum("-1");//-1代表没有父目录
			/*catalogService.add(parentCatalog);*/ //数据库添加一级目录
			
			Elements childEles = el.select("li.sub-nav-item");//用Jsoup选择器获取二级目录下面是遍历
			for (Element childEle : childEles) {
				String childCatalogName = childEle.text().split(" ")[0];//获取目录名
				
				String childUrl = childEle.select("a").attr("href");
				String childCatalogNum = childUrl.split("\\/")[2];//获取编号
				
				/*System.out.println("二级目录:" + childCatalogName + "" + childCatalogNum);*/
				
				Catalog childCatalog = new Catalog();
				childCatalog.setCatalogName(childCatalogName);
				childCatalog.setCatalogNum(childCatalogNum);
				childCatalog.setChildNode(1);//1代表该目录为子目录
				childCatalog.setParentNum(parentCatalog.getCatalogNum());//添加该目录的父目录注意因为这里是for
				
				/*catalogService.add(childCatalog);//添加二级目录
*/			}
		}
		
		
		
	}
	
	public static void doTask() {
		CatalogService service = BeanUtils.getBean(CatalogService.class);
		service.queryChildCatalog();
		
	}

}
