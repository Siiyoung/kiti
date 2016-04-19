package com.tencent.mm.common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpTool {


	public static String doPost(String url, List<NameValuePair> formparams) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpRequest = new HttpPost(url);
		String resultString = "";
		try {
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httpRequest.setEntity(uefEntity);
			CloseableHttpResponse response = httpclient.execute(httpRequest);
			try {
				HttpEntity entity = response.getEntity();
				resultString = EntityUtils.toString(entity);
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return resultString;

	}
	
	public static CloseableHttpResponse doGet(String url){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		HttpGet httpGet = new HttpGet(url);
		try{
			try {
				response = httpclient.execute(httpGet);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}finally{
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return response;
	}

}
