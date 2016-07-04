package com.example.shop;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
public class mview3 extends Activity {
	private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16;
	private String uid,uname,id,name,many,money,intr,goal,now,dead,location,total,smath;
	private int math;
	int n1,n2,tol;
	double stol;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mview3);
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
        t16=(TextView)findViewById(R.id.textView16);
        Intent intent1=this.getIntent();
        Bundle bundle=intent1.getExtras();
        
        uid=(bundle.getString("uid"));
		uname=(bundle.getString("uname"));
		name=(bundle.getString("name"));
		many=(bundle.getString("many"));
		money=(bundle.getString("money"));
		location=(bundle.getString("location"));
		goal=(bundle.getString("goal"));
		now=(bundle.getString("now"));
		dead=(bundle.getString("dead"));
		
		n1=Integer.parseInt(goal);
		n2=Integer.parseInt(now);
		tol=Integer.parseInt(money);
		stol=tol*0.9;
		total=String.valueOf(stol);
		
		t2.setText(name);
		t4.setText(many);
		t7.setText(goal);
		t9.setText(now);
		t13.setText(dead);
		t15.setText(location);
		if(n2>n1){
			t11.setText(total);
		}
		if(n2<n1){
			t11.setText(money);
			t16.setText("");
		}
	}
	public void back(View view){
		Intent intent=new Intent();
		intent.setClass(mview3.this,personal.class);
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