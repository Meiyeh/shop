package com.example.shop;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
public class multibuy extends Activity {
	private TextView t1,t2,t3,t4,t5,t6,t7;
	private String uid,uname,id,name,money,intr,goal,now,dead;
	private int n1,n2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.multibuy);
		t1=(TextView)findViewById(R.id.textView1);
        t2=(TextView)findViewById(R.id.textView2);
        t3=(TextView)findViewById(R.id.textView3);
        t4=(TextView)findViewById(R.id.textView4);
        t5=(TextView)findViewById(R.id.textView5);
        t6=(TextView)findViewById(R.id.textView6);
        t7=(TextView)findViewById(R.id.textView7);
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
		n1=Integer.parseInt(id);
		n2=Integer.parseInt(money);
		t1.setText(name);
		t3.setText(goal);
		t5.setText(now);
		t7.setText(dead);
	}
	public void back(View view){
		Intent intent=new Intent();
		intent.setClass(multibuy.this,comtest.class);
		Bundle bundle=new Bundle();
		bundle.putString("NAME2", name);//cname
		bundle.putString("intr", intr);//cintr
		bundle.putInt("id", n1);//cid
		bundle.putInt("money", n2);//cprize
		bundle.putString("uid", uid);//uid
		bundle.putString("uname", uname);//uname
		intent.putExtras(bundle);
		startActivity(intent);
	}
	public void go(View view){
		Intent intent=new Intent();
		intent.setClass(multibuy.this,mul1.class);
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