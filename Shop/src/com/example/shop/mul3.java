package com.example.shop;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
public class mul3 extends Activity {
	private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
	private String uid,uname,id,name,money,intr,goal,now,dead,location,total,smath,new1;
	private int math;
	int n1,n2,n3,tol;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mul3);
		t1=(TextView)findViewById(R.id.textView1);
        t2=(TextView)findViewById(R.id.textView2);
        t3=(TextView)findViewById(R.id.textView3);
        t4=(TextView)findViewById(R.id.textView4);
        t5=(TextView)findViewById(R.id.textView5);
        t6=(TextView)findViewById(R.id.textView6);
        t7=(TextView)findViewById(R.id.textView7);
        t8=(TextView)findViewById(R.id.textView8);
        t9=(TextView)findViewById(R.id.textView9);
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
		math=bundle.getInt("math");
		
		n3=Integer.parseInt(now);
		n3=n3+math;
		new1=Integer.toString(n3);
		
		location=(bundle.getString("location"));
		n1=Integer.parseInt(money);
		n2=math;
		smath=Integer.toString(math);
		tol=n1*n2;
		total=Integer.toString(tol);
		t2.setText(name);
		t4.setText(smath);
		t7.setText(total);
		t9.setText(location);
	}
	public void test(View view){
		new update2(this).execute(uname,name,smath,total,location,"1");
		new upmul(this).execute(name,new1);
		Intent intent=new Intent();
		intent.setClass(mul3.this,success.class);
		Bundle bundle=new Bundle();
		bundle.putString("uid", uid);//uid
		bundle.putString("uname", uname);//uname
		intent.putExtras(bundle);
		startActivity(intent);
	}
	public void back(View view){
		Intent intent=new Intent();
		intent.setClass(mul3.this,mul2.class);
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
    	bundle.putInt("math", math);//math
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