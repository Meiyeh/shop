package com.example.shop;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class personal extends Activity {
	private TextView t1,t2;
	private String data1,username;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personal);
		t1=(TextView) findViewById(R.id.textView1);
		t2=(TextView) findViewById(R.id.textView2);
		Intent a = this.getIntent();
		Bundle b = a.getExtras();
		data1=(b.getString("id"));
		username=(b.getString("name"));
		t2.setText(username);
	}
	public void tomajor(View view){
		Intent intent2=new Intent();
		intent2.setClass(personal.this,major.class);
		Bundle bundle=new Bundle();
		bundle.putString("idd", data1);
		bundle.putString("name2", username);
		intent2.putExtras(bundle);
		startActivity(intent2);
	}
	public void tosbuy(View view){
		//new sbuy(this).execute(data1,username);
		Intent intent2=new Intent();
		intent2.setClass(personal.this,sbuyinf2.class);
		Bundle bundle=new Bundle();
		bundle.putString("id", data1);
		bundle.putString("uname", username);
		intent2.putExtras(bundle);
		startActivity(intent2);
	}
	public void tombuy(View view){
		//new mbuy(this).execute(data1,username);
		Intent intent2=new Intent();
		intent2.setClass(personal.this,mbuyinf2.class);
		Bundle bundle=new Bundle();
		bundle.putString("id", data1);
		bundle.putString("uname", username);
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
