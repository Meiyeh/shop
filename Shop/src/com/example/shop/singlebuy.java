package com.example.shop;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class singlebuy extends Activity {
	private EditText e1;
	private TextView t1,t2;
	String name,intr;
	private String data1,username;
	int n1,n2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.singlebuy);
		e1=(EditText)findViewById(R.id.editText1);
		t1=(TextView)findViewById(R.id.textView1);
        t2=(TextView)findViewById(R.id.textView2);
        Intent intent1=this.getIntent();
        Bundle bundle=intent1.getExtras();
        n1=bundle.getInt("id");
        n2=bundle.getInt("money");
        name=(bundle.getString("NAME2"));
		intr=(bundle.getString("intr"));
		data1=(bundle.getString("uid"));
		username=(bundle.getString("uname"));
		
	}
	public void go(View view){
		int math1=Integer.parseInt(e1.getText().toString());
		Intent intent=new Intent();
		intent.setClass(singlebuy.this,store.class);
		Bundle bundle=new Bundle();
		bundle.putString("NAME2", name);//cname
		bundle.putString("intr", intr);//cintr
		bundle.putInt("id", n1);//cid
		bundle.putInt("money", n2);//cprize
		bundle.putInt("many", math1);//cmany
		bundle.putString("uid", data1);//uid
		bundle.putString("uname", username);//uname
		intent.putExtras(bundle);
		startActivity(intent);
	}
	public void back(View view){
		Intent intent=new Intent();
		intent.setClass(singlebuy.this,comtest.class);
		Bundle bundle=new Bundle();
		bundle.putString("NAME2", name);//cname
		bundle.putString("intr", intr);//cintr
		bundle.putInt("id", n1);//cid
		bundle.putInt("money", n2);//cprize
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