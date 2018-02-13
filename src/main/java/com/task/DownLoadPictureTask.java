package com.task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.util.SleepUtils;


public class DownLoadPictureTask implements Runnable{

		private String url;
		private String picName;

		public DownLoadPictureTask(String url, String picName) {
			this.url = url;
			this.picName = picName;
		}

		public void run() {
			InputStream is = null;
			FileOutputStream fos = null;
			URLConnection conn = null;
			try {
				
				Thread.sleep(SleepUtils.getMill());
				URL picUrl = new URL(url);
				conn = picUrl.openConnection();
				is = conn.getInputStream();//����д������������ڳ���
				String PictureUrl="D:"+File.separator+"book-img1"+File.separator+picName;
				fos = new FileOutputStream(PictureUrl);
				byte[] data = new byte[1024];
				int length = -1;
				while (-1 != (length = is.read(data))) {
					fos.write(data, 0, length);
					fos.flush();
				}

				System.out.println(">>>>>" + picName + "���سɹ�");
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (null != fos) {
						fos.close();
					}

					if (null != is) {
						is.close();
					}

				} catch (IOException e) {
				}
			}
		}

	}
