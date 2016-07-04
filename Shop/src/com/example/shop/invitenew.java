package com.example.shop;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
public class invitenew extends Activity {
	private TextView t1;
	private EditText e1,e2,e3,e4,e5,e6;
	private String uid,uname,thing,location,goal,now,dead,tel,ip01,ip02;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.invitenew);
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		e3=(EditText)findViewById(R.id.editText3);
		e4=(EditText)findViewById(R.id.editText4);
		e5=(EditText)findViewById(R.id.editText5);
		e6=(EditText)findViewById(R.id.editText6);
		t1=(TextView)findViewById(R.id.textView1);
		Intent intent1=this.getIntent();
        Bundle bundle=intent1.getExtras();
        uid=(bundle.getString("uid"));
		uname=(bundle.getString("uname"));
		ip01=(bundle.getString("ip1"));
		ip02=(bundle.getString("ip2"));
	}
	public void go(View view){
		thing=e1.getText().toString();
		location=e2.getText().toString();
		goal=e3.getText().toString();
		now=e4.getText().toString();
		dead=e5.getText().toString();
		tel=e6.getText().toString();
		new updatejoin(this).execute(uname,thing,location,goal,now,dead,tel,ip01,ip02);
		new updatejoin2(this).execute(uname,uname,thing,location,goal,now,dead,tel,ip01,ip02);
		Intent intent=new Intent();
		intent.setClass(invitenew.this,invite.class);
		Bundle bundle=new Bundle();
		bundle.putString("id",uid);//uid
    	bundle.putString("name",uname);//uname
    	//bundle.putString("thing",thing);//thing
    	//bundle.putString("location",location);//location
    	//bundle.putString("goal",goal);//goalpeople
    	//bundle.putString("now",now);//nowpeople
    	//bundle.putString("dead",dead);//deadline
    	//bundle.putString("tel",tel);//telphone
    	intent.putExtras(bundle);
		startActivity(intent);
	}
	public void back(View view){
		Intent intent=new Intent();
		intent.setClass(invitenew.this,invite.class);
		Bundle bundle=new Bundle();
		bundle.putString("id",uid);//uid
    	bundle.putString("name",uname);//uname
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