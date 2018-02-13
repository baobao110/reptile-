package com.util;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Productor implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		synchronized (Container.e) {
			if(Container.size()>0) {
				System.out.println("生产者等待");
				try {
					Container.e.wait(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				String URL;
				Document document;
				String webs;
				URL="https://read.douban.com/ebooks/?dcs=book-nav&dcm=douban";
				try {
					document = Jsoup.connect(URL).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36").cookie("Cookie", "bid=dyay6sbdg6I; ps=y; ll=\"118159\"; __utma=30149280.616217514.1515744207.1515744207.1515746105.2; __utmz=30149280.1515744207.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); as=\"https://sec.douban.com/b?r=https%3A%2F%2Fread.douban.com%2Febooks%2F%3Fdcs%3Dbook-nav%26dcm%3Ddouban\"; dbcl2=\"172477001:6iLIhAewGPY\"; ck=St2P; _pk_ref.100001.a7dd=%5B%22%22%2C%22%22%2C1515753562%2C%22https%3A%2F%2Fopen.weixin.qq.com%2Fconnect%2Fqrconnect%3Fappid%3Dwxd9c1c6bbd5d59980%26redirect_uri%3Dhttps%253A%252F%252Fwww.douban.com%252Faccounts%252Fconnect%252Fwechat%252Fcallback%26response_type%3Dcode%26scope%3Dsnsapi_login%26state%3Ddyay6sbdg6I%252523None%252523https%25253A%252F%252Fread.douban.com%252Febooks%252F%25253Fdcs%25253Dbook-nav%252526dcm%25253Ddouban%22%5D; _pk_id.100001.a7dd=629b2e0acae30fe3.1515644364.12.1515753562.1515747980.; _pk_ses.100001.a7dd=*; _gat=1; _ga=GA1.3.1608148500.1515644364; _gid=GA1.3.410888421.1515644364").referrer("https://open.weixin.qq.com/connect/qrconnect?appid=wxd9c1c6bbd5d59980&redirect_uri=https%3A%2F%2Fwww.douban.com%2Faccounts%2Fconnect%2Fwechat%2Fcallback&response_type=code&scope=snsapi_login&state=dyay6sbdg6I%2523None%2523https%253A%2F%2Fread.douban.com%2Febooks%2F%253Fdcs%253Dbook-nav%2526dcm%253Ddouban").get();
					Container.add(document);
					Container.e.notifyAll();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//这里的信息模仿浏览器的方式 
			}
			
		}
		
		
	}
	
	
	
	

}
