package com.example.shop;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
public class invitecheck2 extends Activity {
	private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
	private String uid,uname,name,thing,money,goal,now,deadline,location,total,smath,tel;
	private int math;
	int n1,n2,tol;
	double stol;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.invitecheck2);
		t1=(TextView)findViewById(R.id.textView1);
        t2=(TextView)findViewById(R.id.textView2);
        t3=(TextView)findViewById(R.id.textView3);
        t4=(TextView)findViewById(R.id.textView4);
        t5=(TextView)findViewById(R.id.textView5);
        t6=(TextView)findViewById(R.id.textView6);
        t7=(TextView)findViewById(R.id.textView7);
        t8=(TextView)findViewById(R.id.textView8);
        t9=(TextView)findViewById(R.id.textView9);
        t10=(TextView)findViewById(R.id.textView10);
        t11=(TextView)findViewById(R.id.textView11);
        t12=(TextView)findViewById(R.id.textView12);
        t13=(TextView)findViewById(R.id.textView13);
        t14=(TextView)findViewById(R.id.textView14);
        t15=(TextView)findViewById(R.id.textView15);
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
		
		t2.setText(name);
		t4.setText(thing);
		t7.setText(location);
		t9.setText(goal);
		t11.setText(now);
		t13.setText(deadline);
		t15.setText(tel);
	}
	public void back(View view){
		Intent intent=new Intent();
		intent.setClass(invitecheck2.this,personal.class);
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