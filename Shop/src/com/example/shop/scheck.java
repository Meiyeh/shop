package com.example.shop;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class scheck extends Activity {
	private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
	private EditText e1;
	String name,intr,location;
	private String data1,username,many,total;
	int n1,n2,n3,tol;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scheck);
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
        n1=bundle.getInt("id");
        n2=bundle.getInt("money");
        n3=bundle.getInt("many");
        many=Integer.toString(n3);
        tol=n2*n3;
        total=Integer.toString(tol);
        name=(bundle.getString("NAME2"));
		intr=(bundle.getString("intr"));
		data1=(bundle.getString("uid"));
		username=(bundle.getString("uname"));
		location=(bundle.getString("location"));
		t2.setText(name);
		t4.setText(many);
		t7.setText(total);
		t9.setText(location);
	}
	public void test(View view){
		new updates(this).execute(username,name,many,total,location);
		Intent intent=new Intent();
		intent.setClass(scheck.this,success.class);
		Bundle bundle=new Bundle();
		bundle.putString("uid", data1);//uid
		bundle.putString("uname", username);//uname
		intent.putExtras(bundle);
		startActivity(intent);
	}
	public void go(View view){
		Intent intent=new Intent();
		intent.setClass(scheck.this,success.class);
		Bundle bundle=new Bundle();
		bundle.putString("NAME2", name);//cname
		bundle.putInt("money", n2);//allcprize
		bundle.putInt("many", n3);//cmany
		bundle.putString("uid", data1);//uid
		bundle.putString("uname", username);//uname
		bundle.putString("location", location);//location
		intent.putExtras(bundle);
		startActivity(intent);
	}
	public void back(View view){
		Intent intent=new Intent();
		intent.setClass(scheck.this,store.class);
		Bundle bundle=new Bundle();
		bundle.putString("NAME2", name);//cname
		bundle.putString("intr", intr);//cintr
		bundle.putInt("id", n1);//cid
		bundle.putInt("money", n2);//cprize
		bundle.putInt("many", n3);//cmany
		bundle.putString("uid", data1);//uid
		bundle.putString("uname", username);//uname
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