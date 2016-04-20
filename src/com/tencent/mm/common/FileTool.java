package com.tencent.mm.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StreamTokenizer;

import org.apache.http.client.methods.CloseableHttpResponse;

public class FileTool {
	
	//储存文件到本地指定位置
	public boolean saveFileToLocal(String url , String filePath , String fileName){
		CloseableHttpResponse response = HttpTool.doGet(url);
		boolean result = false;
		InputStream is = null ;
		try {
			is = response.getEntity().getContent();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}   
        File dir = new File(filePath); 
        File file = new File(dir,fileName);
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
