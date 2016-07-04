package com.example.shop;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class major2 extends Activity {
	private TextView t1,t2;
	private EditText e1;
	ListView lstPrefer; 
	int[] resIds = new int[]{ R.drawable.m1, R.drawable.m2, R.drawable.m3,R.drawable.m4,R.drawable.m5};
	String[] Balls= new String[] {"iphone6","ipad","ASUS X550","ACER 4755G","HTC M9"};  
	String[] engNames = { "18000", "12000","30000","25000","20000"};
	String[] intr = { "�K�y", "�n��","���I�Q","kevin lai using","�겣�~��"};
	//String[] Balls= new String[] {"iphone6","ipad","ASUS X550","ACER 4755G","HTC M9"};  
	//String[] engNames = { "18000", "12000","30000","25000","20000"};
	//String[] intr = { "�K�y", "�n��","���I�Q","kevin lai using","�겣�~��"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.major2);
		t1=(TextView) findViewById(R.id.textView1);
		t2=(TextView) findViewById(R.id.textView2);
		e1= (EditText)findViewById(R.id.editText1);
		// ���o�귽���O�ɤ����������� 
        lstPrefer=(ListView)findViewById(R.id.listView1); 
        
		// �إߦۭq�� Adapter
        MyAdapter adapter=new MyAdapter(this);
		
		// �]�w  ListView ����ƨӷ�
		lstPrefer.setAdapter(adapter);
		// �]�w lstPrefer ���� ItemClick �ƥ� listener�� lstPreferListener
        lstPrefer.setOnItemClickListener(lstPreferListener);
		
	}
	public void to(View view){
		Intent intent=new Intent();
		intent.setClass(major2.this,login.class);
		startActivity(intent);
	}
	public void find(View view){
		String s1 = e1.getText().toString();
		Intent intent=new Intent();
		intent.setClass(major2.this,findpage.class);
		Bundle bundle=new Bundle();
		bundle.putString("NAME", s1); 
		intent.putExtras(bundle);
		startActivity(intent);
	}
	public class MyAdapter extends BaseAdapter {           
		private LayoutInflater myInflater; 
		public MyAdapter(Context c){       
			myInflater = LayoutInflater.from(c); 	
		}     
		@Override  
		public int getCount(){    
			return Balls.length; 
		}   
		@Override    
		public Object getItem(int position){        
			return Balls[position];    
		}      
	    @Override    
	    public long getItemId(int position){        
	    	return position;    
	    }      
	    @Override   
	    public View getView(int position,View convertView,ViewGroup parent){   	   
	    	convertView = myInflater.inflate(R.layout.mylayout, null);  
	    	
			// ���o  mylayout.xml �������� 
			ImageView imgLogo = (ImageView) convertView.findViewById(R.id.imgLogo);		
			TextView txtName = ((TextView) convertView.findViewById(R.id.txtName));
			TextView txtengName = ((TextView) convertView.findViewById(R.id.txtengName));	
		
			// �]�w���󤺮e        
			imgLogo.setImageResource(resIds[position]);
			txtName.setText(Balls[position]);     
			txtengName.setText(engNames[position]); 

			return convertView;   
		}    
	}
     //  �w�q  onItemClick ��k
     private ListView.OnItemClickListener lstPreferListener=
    	new ListView.OnItemClickListener(){
		@Override
		public void onItemClick(AdapterView<?> parent, View v,
		 int position, long id) {
			int a=resIds[position];
			int b=Integer.parseInt(engNames[position]);
			String s1 = Balls[position];
			String s2 = intr[position];
			Intent intent=new Intent();
			intent.setClass(major2.this,comtest.class);
			Bundle bundle=new Bundle();
			bundle.putString("NAME2", s1);
			bundle.putString("intr", s2);
			bundle.putInt("id", a);
			bundle.putInt("money", b);
			intent.putExtras(bundle);
			startActivity(intent);
		}
    };

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}