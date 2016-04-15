package com.tencent.mm.basicActivity.mainPage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.tencent.mm.R;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainTaskActivity extends ActionBarActivity {
	
	private TextView userNameTextView ;
	private Button taobao ;
	private Button tianmao ;
	private Button jingdong ;
	private Button stopTask ;
	private Button changeAccount ;
	private Button quit ;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maintask);
		Intent intent = getIntent();
		String userName = intent.getStringExtra("userName");
		String passWord = intent.getStringExtra("passWord");
		userNameTextView = (TextView) findViewById(R.id.mainpage_username);
		userNameTextView.setText(userName);
		taobao= (Button) findViewById(R.id.taobao);
		tianmao= (Button) findViewById(R.id.tianmao);
		jingdong= (Button) findViewById(R.id.jingdong);
		stopTask= (Button) findViewById(R.id.stopTask);
		changeAccount= (Button) findViewById(R.id.changeAccount);
		quit= (Button) findViewById(R.id.quit);
		taobao.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				new AlertDialog.Builder(MainTaskActivity.this).setMessage("你点击了淘宝按钮").show();
				
			}
		});
		tianmao.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "即将开始做淘宝任务", Toast.LENGTH_SHORT).show();
//				Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.taobao.taobao");  
//				startActivity(LaunchIntent); 
				Process rt;
				try {
					rt = Runtime.getRuntime().exec("su");
					DataOutputStream os = new DataOutputStream(rt.getOutputStream());
					
					os.writeBytes("uiautomator runtest /data/local/tmp/TestTaobao.jar -c com.test.taobao.TestTaobaoByKeyword" + "\n");
					os.flush();
					os.writeBytes("exit\n");
					
				} catch (IOException e1) {
					Toast.makeText(getApplicationContext(), "启动任务失败，请检查手机配置！", Toast.LENGTH_SHORT).show();
					e1.printStackTrace();
				}
				
			}
		});
		
		jingdong.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "即将开始做京东任务", Toast.LENGTH_SHORT).show();
				
			}
		});
		stopTask.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				new AlertDialog.Builder(MainTaskActivity.this).setMessage("你点击了停止任务按钮").show();
				
			}
		});
		changeAccount.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				new AlertDialog.Builder(MainTaskActivity.this).setMessage("你点击了更换账号按钮").show();
				
			}
		});
		quit.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				new AlertDialog.Builder(MainTaskActivity.this).setMessage("你点击了退出按钮").show();
				
			}
		});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}

}
