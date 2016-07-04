package com.example.shop;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class mbuyinf extends Activity {
	private String data1,username,s1,s2,s3,s4;
	private ListView lstPrefer;
	String[] Balls= new String[] {"1.","2.","3.","4.","5.","6.","7.","8."};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mbuyinf);
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
        ArrayAdapter<String> adapterBalls=new ArrayAdapter<String>(
        		this,android.R.layout.simple_list_item_1,Balls);
        lstPrefer.setAdapter(adapterBalls);
        // 設定 lstPrefer 元件 ItemClick 事件的 listener為 lstPreferListener
        lstPrefer.setOnItemClickListener(lstPreferListener);
	}
	public void topersonal(View view){
		Intent intent=new Intent();
		intent.setClass(mbuyinf.this,personal.class);
		Bundle bundle=new Bundle();
		bundle.putString("id", data1);
		bundle.putString("name", username);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	private ListView.OnItemClickListener lstPreferListener=
	    	new ListView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
			 int position, long id) {
				//new mtest(this).execute(data1,username);
				Intent intent=new Intent();
				intent.setClass(mbuyinf.this,mview1.class);
				Bundle bundle=new Bundle();
				bundle.putString("uid",data1);
		    	bundle.putString("uname",username);
		    	bundle.putString("name",s1);
		    	bundle.putString("many",s2);
		    	bundle.putString("prize",s3);
		    	bundle.putString("location",s4);
				intent.putExtras(bundle);
				startActivity(intent);
			}
	    };

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}