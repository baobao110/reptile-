package com.util;

import java.util.LinkedList;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Container {
	public static final LinkedList<Document> list=new LinkedList<Document>();
	
	public static Document e=new Document("");
	
	public static void add(Document e) {
		list.add(e);
	}
	
	public static Document get() {
		return list.removeFirst();
	}
	
	public static int size() {
		return list.size();
	}
}//消费者和生产者用于多线程爬虫的自己的方法(本项目用老师的方法)