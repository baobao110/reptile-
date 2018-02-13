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
//		getCatalog ();//��������Ǳ���һ����Ŀ¼
		doTask();//������Ϊ����������
	}
	
	public static void getCatalog () {
		String host = "https://read.douban.com";
		String url = "/kind/100";
		
		CatalogService catalogService = BeanUtils.getBean(CatalogService.class);
		String htmlDocument = ApiConnector.get(host + url);
		Elements eles = Jsoup.parse(htmlDocument).select("ul").select("li.nav-item.foldable");//��Jsoupѡ������ȡһ��Ŀ¼�����Ǳ���
		
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
			
		/*	System.out.println("һ��Ŀ¼" + parentCatalogName + " " + parentCatalogNum);//�����ǻ�ȡһ��Ŀ¼
*/			
			//����һ��Ŀ¼
			Catalog parentCatalog = new Catalog();
			parentCatalog.setCatalogName(parentCatalogName);
			parentCatalog.setCatalogNum(parentCatalogNum);
			parentCatalog.setChildNode(0);//0��������Ŀ¼
			parentCatalog.setParentNum("-1");//-1����û�и�Ŀ¼
			/*catalogService.add(parentCatalog);*/ //���ݿ����һ��Ŀ¼
			
			Elements childEles = el.select("li.sub-nav-item");//��Jsoupѡ������ȡ����Ŀ¼�����Ǳ���
			for (Element childEle : childEles) {
				String childCatalogName = childEle.text().split(" ")[0];//��ȡĿ¼��
				
				String childUrl = childEle.select("a").attr("href");
				String childCatalogNum = childUrl.split("\\/")[2];//��ȡ���
				
				/*System.out.println("����Ŀ¼:" + childCatalogName + "" + childCatalogNum);*/
				
				Catalog childCatalog = new Catalog();
				childCatalog.setCatalogName(childCatalogName);
				childCatalog.setCatalogNum(childCatalogNum);
				childCatalog.setChildNode(1);//1�����Ŀ¼Ϊ��Ŀ¼
				childCatalog.setParentNum(parentCatalog.getCatalogNum());//��Ӹ�Ŀ¼�ĸ�Ŀ¼ע����Ϊ������for
				
				/*catalogService.add(childCatalog);//��Ӷ���Ŀ¼
*/			}
		}
		
		
		
	}
	
	public static void doTask() {
		CatalogService service = BeanUtils.getBean(CatalogService.class);
		service.queryChildCatalog();
		
	}

}
