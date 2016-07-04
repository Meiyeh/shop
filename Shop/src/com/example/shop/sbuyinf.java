package com.example.shop;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class sbuyinf extends Activity {
	private EditText user,pass;
	private TextView t1,t2;
	private String data1,username,s1,s2,s3,s4;
	private ListView lstPrefer;
	String[] Balls= new String[] {"1.","2.","3.","4.","5.","6.","7.","8."};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sbuyinf);
		t1=(TextView) findViewById(R.id.textView1);
		lstPrefer=(ListView) findViewById(R.id.listView1);
		Intent a = this.getIntent();
		Bundle b = a.getExtras();
		data1=(b.getString("id"));
		username=(b.getString("uname"));
		s1=(b.getString("name"));
		s2=(b.getString("many"));
		s3=(b.getString("prize"));
		s4=(b.getString("location"));
		Balls[0]=Balls[0]+s1+",數量:"+s2+",金額:"+s3+",取貨位置:"+s4;
		t1.setText(s1+s2+s3+s4);
        ArrayAdapter<String> adapterBalls=new ArrayAdapter<String>(
        		this,android.R.layout.simple_list_item_1,Balls);
        lstPrefer.setAdapter(adapterBalls);
	}
	public void topersonal(View view){
		Intent intent=new Intent();
		intent.setClass(sbuyinf.this,personal.class);
		Bundle bundle=new Bundle();
		bundle.putString("id", data1);
		bundle.putString("name", username);
		intent.putExtras(bundle);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}