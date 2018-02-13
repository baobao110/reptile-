package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPools {
	
	//二级目录线程池
		public static final ExecutorService childCatalog = Executors.newSingleThreadExecutor();
		
		//商品详情线程池
		public static final ExecutorService commodityInfo = Executors.newSingleThreadExecutor();
		
		//图片线程池
		public static final ExecutorService pictureInfo = Executors.newSingleThreadExecutor();
		
}
