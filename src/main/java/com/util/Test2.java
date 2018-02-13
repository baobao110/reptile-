package com.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test2 {
	
	public static void main(String[] args) {
		String URL;
		Document document;
		String webs;
		try {
			URL="https://read.douban.com/ebooks/?dcs=book-nav&dcm=douban";
			document = Jsoup.connect(URL).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36").cookie("Cookie", "bid=dyay6sbdg6I; _pk_id.100001.a7dd=629b2e0acae30fe3.1515644364.4.1515660064.1515653255.; _pk_ses.100001.a7dd=*; _gat=1; _ga=GA1.3.1608148500.1515644364; _gid=GA1.3.410888421.1515644364").referrer("https://book.douban.com/").get();//这里的信息模仿浏览器的方式 
			Elements test=document.select("ul.list.kinds-list.tab-panel").select("li").select("a");//"."代表class
			/*for (Element link:test) {
				try {
					Thread.sleep(1000 * 1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
              webs=link.attr("abs:href");
              System.out.println(webs+"\t\t"+link.text());
          }
			System.out.println();
			for (Element link:test) {
				try {
					Thread.sleep(1000 * 1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				URL=link.attr("abs:href");
				document = Jsoup.connect(URL).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36").cookie("Cookie", "bid=dyay6sbdg6I; _pk_id.100001.a7dd=629b2e0acae30fe3.1515644364.4.1515660064.1515653255.; _pk_ses.100001.a7dd=*; _gat=1; _ga=GA1.3.1608148500.1515644364; _gid=GA1.3.410888421.1515644364").referrer("https://book.douban.com/").get();
				Elements lists=document.select("ul.sub-nav-list").select("li").select("a");
				for (Element list:lists) {
	                webs=list.attr("abs:href");
	                System.out.println(webs+"\t\t"+list.text());
	            }
				System.out.println(); 
			}*/
			
			for (Element link:test) {
				try {
					Thread.sleep(1000 * 1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				URL=link.attr("abs:href");
				document = Jsoup.connect(URL).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36").cookie("Cookie", "bid=dyay6sbdg6I; _pk_id.100001.a7dd=629b2e0acae30fe3.1515644364.4.1515660064.1515653255.; _pk_ses.100001.a7dd=*; _gat=1; _ga=GA1.3.1608148500.1515644364; _gid=GA1.3.410888421.1515644364").referrer("https://book.douban.com/").get();
				Elements lists=document.select("ul.sub-nav-list").select("li").select("a");//
				for (Element list:lists) {
					try {
						Thread.sleep(1000 * 1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	                webs=list.attr("abs:href");
	                System.out.println(webs);
	                for(int i=0;i<3;i++) {
	                	int j=20*i;
	                	String []x=webs.split("\\?");
	                	URL=x[0]+"?start="+j+"&sort=hot&promotion_only=False&min_price=None&max_price=None&works_type=None";
                		document = Jsoup.connect(URL).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36").cookie("Cookie", "bid=dyay6sbdg6I; _pk_id.100001.a7dd=629b2e0acae30fe3.1515644364.4.1515660064.1515653255.; _pk_ses.100001.a7dd=*; _gat=1; _ga=GA1.3.1608148500.1515644364; _gid=GA1.3.410888421.1515644364").referrer("https://book.douban.com/").get();
                		Elements flows=document.select("div.title").select("a");
                		for (Element flow:flows) {
                			try {
            					Thread.sleep(1000 * 1);
            				} catch (InterruptedException e) {
            					e.printStackTrace();
            				}
        	                webs=flow.attr("abs:href");
        	                System.out.println(webs);
        	                document = Jsoup.connect( webs).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36").cookie("Cookie", "bid=dyay6sbdg6I; _pk_id.100001.a7dd=629b2e0acae30fe3.1515644364.4.1515660064.1515653255.; _pk_ses.100001.a7dd=*; _gat=1; _ga=GA1.3.1608148500.1515644364; _gid=GA1.3.410888421.1515644364").referrer("https://book.douban.com/").get();
        	                Elements images=document.select("div.cover.shadow-cover").select("img");
        	                for (Element image:images) {
        	                	 webs=image.attr("src");
        	                	 System.out.println(webs+image.text()+"二级目录"+list.text()+"一级目录"+link.text());
        	                }
        	            }
                		System.out.println();
	      
	                }
	                	/*document = Jsoup.connect(webs).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36").cookie("Cookie", "bid=dyay6sbdg6I; _pk_id.100001.a7dd=629b2e0acae30fe3.1515644364.4.1515660064.1515653255.; _pk_ses.100001.a7dd=*; _gat=1; _ga=GA1.3.1608148500.1515644364; _gid=GA1.3.410888421.1515644364").referrer("https://book.douban.com/").get();*/
	            } 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
