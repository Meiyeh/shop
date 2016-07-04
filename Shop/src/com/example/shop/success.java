package com.example.shop;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
public class success extends Activity {
	private String data1,username;
	private TextView t1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.success);
		t1=(TextView) findViewById(R.id.textView1);
		Intent a = this.getIntent();
		Bundle b = a.getExtras();
		data1=(b.getString("uid"));
		username=(b.getString("uname"));
	}
	public void to1(View view){
		Intent intent2=new Intent();
		intent2.setClass(success.this,personal.class);
		Bundle bundle=new Bundle();
		bundle.putString("id", data1);
		bundle.putString("name", username);
		intent2.putExtras(bundle);
		startActivity(intent2);
	}
	public void tomajor(View view){
		Intent intent2=new Intent();
		intent2.setClass(success.this,major.class);
		Bundle bundle=new Bundle();
		bundle.putString("idd", data1);
		bundle.putString("name2", username);
		intent2.putExtras(bundle);
		startActivity(intent2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}