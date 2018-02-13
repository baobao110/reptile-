package com.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Customer1 implements Runnable {
	String webs=null;
	Document document;
	public void run() {
		// TODO Auto-generated method stub
		synchronized (Container.e) {
			if(Container.size()>0) {
				try {
					Thread.sleep(1500 * 1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				document=Container.get();
				Elements e=document.select("ul.sub-nav-list").select("li").select("a");
				if(null==e) {
					return ;
				}
				for (Element link:e) {
					 webs=link.attr("abs:href");
		            System.out.println("¶þ¼¶Ä¿Â¼"+webs+"\t\t"+link.text());
		            for(int i=0;i<3;i++) {
	                	int j=20*i;
	                	String []x=webs.split("\\?");
	                	 webs=x[0]+"?start="+j+"&sort=hot&promotion_only=False&min_price=None&max_price=None&works_type=None";
                		try {
							document = Jsoup.connect(webs).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36").cookie("Cookie", "bid=dyay6sbdg6I; _pk_id.100001.a7dd=629b2e0acae30fe3.1515644364.4.1515660064.1515653255.; _pk_ses.100001.a7dd=*; _gat=1; _ga=GA1.3.1608148500.1515644364; _gid=GA1.3.410888421.1515644364").referrer("https://book.douban.com/").get();
                		} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                		Container.add(document);
			}
		}
	}
			
			else {
				try {
					Container.e.wait(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	
}
