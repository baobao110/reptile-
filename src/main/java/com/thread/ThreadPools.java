package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPools {
	
	//����Ŀ¼�̳߳�
		public static final ExecutorService childCatalog = Executors.newSingleThreadExecutor();
		
		//��Ʒ�����̳߳�
		public static final ExecutorService commodityInfo = Executors.newSingleThreadExecutor();
		
		//ͼƬ�̳߳�
		public static final ExecutorService pictureInfo = Executors.newSingleThreadExecutor();
		
}
