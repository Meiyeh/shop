package com.example.shop;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class comtest extends Activity {
	private TextView t1,t2;
	private ImageView i1;
	int n1,n2;
	String name,intr,id,money;
	private String data1,username;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comtest);
		t1=(TextView) findViewById(R.id.textView1);
		t2=(TextView) findViewById(R.id.textView2);
		i1=(ImageView) findViewById(R.id.imageView1);
		// 取得  bundle 
        Intent intent1=this.getIntent();
        Bundle bundle=intent1.getExtras();
        n1=bundle.getInt("id");
        id=Integer.toString(n1);
        n2=bundle.getInt("money");
        money=Integer.toString(n2);
        name=(bundle.getString("NAME2"));
		intr=(bundle.getString("intr"));
		t1.setText(name);
		i1.setImageResource(n1);
		data1=(bundle.getString("uid"));
		username=(bundle.getString("uname"));
	}
	public void tomajor(View view){
		Intent intent2=new Intent();
		intent2.setClass(comtest.this,major.class);
		Bundle bundle=new Bundle();
		bundle.putString("idd", data1);
		bundle.putString("name2", username);
		intent2.putExtras(bundle);
		startActivity(intent2);
	}
	public void say(View view){
		t2.setText(intr);
	}
	public void mbuy(View view){
		new mulcheck(this).execute(data1,username,id,name,money,intr);
	}
	
	public void gomview(){
		new mulcheck(this).execute(data1,username,id,name,money,intr);
	}
	public void buy(View view){
		new AlertDialog.Builder(comtest.this)
		.setTitle("確認視窗")
		.setIcon(R.drawable.ic_launcher)
		.setMessage("選擇購買方式")
		.setPositiveButton("單人購買", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialoginterface, int i)
			{
				Intent intent=new Intent();
				intent.setClass(comtest.this,singlebuy.class);
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
		})
		.setNeutralButton("多人團購", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialoginterface, int i)
			{
				//Intent intent2=new Intent();
				//intent2.setClass(comtest.this,multibuy.class);
				//startActivity(intent2);
				gomview();
			}
		})
		.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialoginterface, int i)
			{	
			}
		})
  		.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}