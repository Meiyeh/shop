package com.example.shop;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
public class invitecheck3 extends Activity {
	private EditText e1;
	private TextView t1;
	private String uid,uname,name,thing,money,goal,now,deadline,location,total,smath,tel,mytel,ip01,ip02;
    int n1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.invitecheck3);
		e1=(EditText)findViewById(R.id.editText1);
		t1=(TextView)findViewById(R.id.textView1);
		
		Intent intent1=this.getIntent();
        Bundle bundle=intent1.getExtras();
        uid=(bundle.getString("uid"));
		uname=(bundle.getString("uname"));
		name=(bundle.getString("name"));
		thing=(bundle.getString("thing"));
		location=(bundle.getString("location"));
		goal=(bundle.getString("goal"));
		now=(bundle.getString("now"));
		deadline=(bundle.getString("deadline"));
		tel=(bundle.getString("tel"));
		ip01=(bundle.getString("ip01"));
		ip02=(bundle.getString("ip02"));
		
		n1=Integer.parseInt(now);
		n1++;
		now=Integer.toString(n1);
		
	}
	public void go(View view){
		mytel=e1.getText().toString();
		new invitejoin(this).execute(uid,uname,name,thing,location,goal,now,deadline,tel,ip01,ip02,mytel);
		new invitejoin2(this).execute(uid,uname,name,thing,now);
		new invitejoin1(this).execute(uid,uname,name,thing,now);
	}
	public void back(View view){
		Intent intent=new Intent();
		intent.setClass(invitecheck3.this,personal.class);
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