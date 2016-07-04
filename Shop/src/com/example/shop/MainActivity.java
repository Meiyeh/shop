package com.example.shop;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	public void login1(View view){
		Intent intent=new Intent();
		intent.setClass(MainActivity.this,login.class);
		startActivity(intent);
	}
	public void tomajor(View view){
		Intent intent2=new Intent();
		intent2.setClass(MainActivity.this,major2.class);
		startActivity(intent2);
	}
	public void test(View view){
		Intent intent3=new Intent();
		intent3.setClass(MainActivity.this,commodity.class);
		startActivity(intent3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
