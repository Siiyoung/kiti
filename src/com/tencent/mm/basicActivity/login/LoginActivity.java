package com.tencent.mm.basicActivity.login;

import com.tencent.mm.R;
import com.tencent.mm.basicActivity.mainPage.MainTaskActivity;
import com.tencent.mm.common.PassWordTool;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends ActionBarActivity {
	
	private EditText passWordInput;
	private EditText userNameInput;
	private Button passWordInputIcon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		passWordInputIcon = (Button)findViewById(R.id.loginicon);
		passWordInputIcon.setOnClickListener(new OnClickListener(){
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
						login();
			}
		});
	}
	
public void getusername(){
		
		userNameInput = (EditText)findViewById(R.id.usernameinput);
		passWordInput = (EditText)findViewById(R.id.passwordinput);
		
	}
	
	public void login(){
		getusername();
		//鏍￠獙璐﹀彿瀵嗙爜鍖归厤鍒欒烦杞埌涓讳换鍔￠〉闈�
		if (PassWordTool.checkPassWord(userNameInput.getText().toString(), passWordInput.getText().toString())){
			Intent intent = new Intent() ;
			intent.putExtra("userName", userNameInput.getText().toString());
			intent.putExtra("passWord", passWordInput.getText().toString());
			intent.setClass(LoginActivity.this, MainTaskActivity.class);
			this.startActivity(intent);
		}
		else{
			new AlertDialog.Builder(LoginActivity.this).setMessage("璐﹀彿鎴栧瘑鐮侀敊璇�").show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
