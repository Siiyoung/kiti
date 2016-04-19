package com.tencent.mm.common;

import java.util.HashMap;
import java.util.Map;

public class PassWordTool {
	
	public static boolean checkPassWord(String userName , String PassWord){
		return true;
	}
	
	public static Map<String, String> getAccountFromService(){
		Map<String, String> accountInfo = new HashMap<>();
		accountInfo.put("userName", "12345678");
		accountInfo.put("passWord", "12345678");
		return accountInfo;
	}

}
