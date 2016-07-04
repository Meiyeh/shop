package com.example.shop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class inviteinf2 extends Activity {
	private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16;
	private String uid,uname,name,thing,location,goal,now,deadline,telephone;
	int n1,n2,tol;
	private Button btn_map; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inviteinf2);
		
		btn_map=(Button)findViewById(R.id.btn_map); // mei new
		
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
		thing=(bundle.getString("thing"));
		location=(bundle.getString("location"));
		goal=(bundle.getString("goal"));
		now=(bundle.getString("now"));
		deadline=(bundle.getString("deadline"));
		telephone=(bundle.getString("telephone"));
		
		n1=Integer.parseInt(goal);
		n2=Integer.parseInt(now);
		
		if(n1>n2){
			t16.setText("揪團未完成喔！");
		}
		if(n1<=n2){
			t16.setText("成功揪團！記得在期限內到集合位置集合喔！");
		}
		
		t2.setText(name);
		t4.setText(thing);
		t7.setText(location);
		t9.setText(goal);
		t11.setText(now);
		t13.setText(deadline);
		t15.setText(telephone);
		//t2.setText(name);
		
		btn_map.setOnClickListener(btn_mapListner);
	}
	public void back(View view){
		Intent intent=new Intent();
		intent.setClass(inviteinf2.this,personal.class);
		Bundle bundle=new Bundle();
		bundle.putString("id",uid);//uid
    	bundle.putString("name",uname);//uname
		intent.putExtras(bundle);
		startActivity(intent);
	}
	
	private Button.OnClickListener btn_mapListner=new Button.OnClickListener(){
		public void onClick(View v){
			Intent in1=new Intent();
			in1.setClass(inviteinf2.this, seepeopleInMap.class);
			Bundle bundle=new Bundle();
			bundle.putString("name",name);//uid
	    	bundle.putString("thing",thing);//uname
	    	
	    	bundle.putString("uid",uid);//uid
	    	bundle.putString("uname",uname);//uname
			in1.putExtras(bundle);
			startActivity(in1);
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}