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
}//�����ߺ����������ڶ��߳�������Լ��ķ���(����Ŀ����ʦ�ķ���)