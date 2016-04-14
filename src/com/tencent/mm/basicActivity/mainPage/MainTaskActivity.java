package com.tencent.mm.basicActivity.mainPage;

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
			
			@Override
			public void onClick(View arg0) {
				new AlertDialog.Builder(MainTaskActivity.this).setMessage("你点击了淘宝按钮").show();
				
			}
		});
		tianmao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				new AlertDialog.Builder(MainTaskActivity.this).setMessage("你点击了天猫按钮").show();
				
			}
		});
		jingdong.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				new AlertDialog.Builder(MainTaskActivity.this).setMessage("你点击了京东按钮").show();
				
			}
		});
		stopTask.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				new AlertDialog.Builder(MainTaskActivity.this).setMessage("你点击了停止任务按钮").show();
				
			}
		});
		changeAccount.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				new AlertDialog.Builder(MainTaskActivity.this).setMessage("你点击了更换账号按钮").show();
				
			}
		});
		quit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				new AlertDialog.Builder(MainTaskActivity.this).setMessage("你点击了退出按钮").show();
				
			}
		});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}

}
