package com.example.shop;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
public class mul1 extends Activity {
	private EditText e1;
	private TextView t1,t2;
	private String uid,uname,id,name,money,intr,goal,now,dead;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mul1);
		e1=(EditText)findViewById(R.id.editText1);
		t1=(TextView)findViewById(R.id.textView1);
        t2=(TextView)findViewById(R.id.textView2);
		Intent intent1=this.getIntent();
        Bundle bundle=intent1.getExtras();
        uid=(bundle.getString("uid"));
		uname=(bundle.getString("uname"));
		id=(bundle.getString("id"));
		name=(bundle.getString("name"));
		money=(bundle.getString("money"));
		intr=(bundle.getString("intr"));
		goal=(bundle.getString("goal"));
		now=(bundle.getString("now"));
		dead=(bundle.getString("dead"));
	}
	public void go(View view){
		int math1=Integer.parseInt(e1.getText().toString());
		Intent intent=new Intent();
		intent.setClass(mul1.this,mul2.class);
		Bundle bundle=new Bundle();
		bundle.putString("uid",uid);//uid
    	bundle.putString("uname",uname);//uname
    	bundle.putString("id",id);//cid
    	bundle.putString("name",name);//cname
    	bundle.putString("money",money);//cmoney
    	bundle.putString("intr",intr);//cintr
    	bundle.putString("goal",goal);//goal
    	bundle.putString("now",now);
    	bundle.putString("dead",dead);
    	bundle.putInt("math", math1);//math
    	intent.putExtras(bundle);
		startActivity(intent);
	}
	public void back(View view){
		Intent intent=new Intent();
		intent.setClass(mul1.this,multibuy.class);
		Bundle bundle=new Bundle();
		bundle.putString("uid",uid);//uid
    	bundle.putString("uname",uname);//uname
    	bundle.putString("id",id);//cid
    	bundle.putString("name",name);//cname
    	bundle.putString("money",money);//cmoney
    	bundle.putString("intr",intr);//cintr
    	bundle.putString("goal",goal);//goal
    	bundle.putString("now",now);
    	bundle.putString("dead",dead);
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