package com.example.shop;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
public class mview1 extends Activity {
	private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
	private String uid,uname,id,name,many,money,intr,goal,now,dead,location,total,smath;
	private int math;
	int n1,n2,tol;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mview1);
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
		name=(bundle.getString("name"));
		many=(bundle.getString("many"));
		money=(bundle.getString("prize"));
		location=(bundle.getString("location"));
		
		t2.setText(name);
		t4.setText(many);
		t7.setText(money);
		t9.setText(location);
	}
	public void to(View view){
		new mtest(this).execute(uid,uname,name,many,money,location);
	}
	public void back(View view){
		Intent intent=new Intent();
		intent.setClass(mview1.this,mbuyinf.class);
		Bundle bundle=new Bundle();
		bundle.putString("id",uid);//uid
    	bundle.putString("uname",uname);//uname
    	bundle.putString("name",name);//cname
    	bundle.putString("prize",money);//cmoney
    	bundle.putString("many",many);//cintr
    	bundle.putString("location",location);
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