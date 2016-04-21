package com.tencent.mm.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;



public class FileTool {
	
	//储存文件到本地指定位置
	public static boolean saveFileToLocal(String url , String filePath , String fileName){
		HttpClient httpclient = new DefaultHttpClient();
		HttpResponse response = null;
		HttpGet httpGet = new HttpGet(url);
		try {
			response = httpclient.execute(httpGet);
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean result = false;
		InputStream is = null;
		try {
			HttpEntity entity = response.getEntity();
			is = entity.getContent();
			//is = response.getEntity().getContentType();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File dir = new File(filePath);
		File file = new File(dir, fileName);
		file.getParentFile().mkdirs();
		try {

			if (!file.exists() || file.delete()) {
				FileOutputStream out = new FileOutputStream(file);
				try {
					out.write(is.read());
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				result = true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

}