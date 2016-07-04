package com.example.shop;

import com.example.shop.major2.MyAdapter;

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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class findpage extends Activity {
	int[] resIds = new int[]{ R.drawable.m1, R.drawable.m2, R.drawable.m3,R.drawable.m4,R.drawable.m5};
	String[] Balls= new String[] {"iphone6","ipad","ASUS X550","ACER 4755G","HTC M9"};  
	String[] engNames = { "18000", "12000","30000","25000","20000"};
	String[] intr = { "便宜", "好用","有點貴","kevin lai using","國產品質"};
	int[] a = new int[]{21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21};
	int[] resIds2 = new int[]{ R.drawable.m1, R.drawable.m2, R.drawable.m3,R.drawable.m4,R.drawable.m5};
	String[] Balls2= new String[] {"iphone6","ipad","ASUS X550","ACER 4755G","HTC M9"};  
	String[] engNames2 = { "18000", "12000","30000","25000","20000"};
	String[] intr2 = { "便宜", "好用","有點貴","kevin lai using","國產品質"};
	private int x=0,y=0;
	ListView lstPrefer;
	private String data1,username;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.findpage);
		TextView t1=(TextView)findViewById(R.id.textView1);
		Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        String s1=bundle.getString("NAME");
        data1=(bundle.getString("id"));
		username=(bundle.getString("name"));
        t1.setText(s1);
        for(int i=0;i<resIds.length;i++){
        	if (Balls[i].indexOf(s1) != -1){
        		resIds2[x]=resIds[i];
        		Balls2[x]=Balls[i];
        		engNames2[x]=engNames[i];
        		intr2[x]=intr[i];
        		x++;
        		y++;
        	}
        }
        x=0;
        // 取得資源類別檔中的介面元件 
        lstPrefer=(ListView)findViewById(R.id.listView1); 
        
		// 建立自訂的 Adapter
        MyAdapter adapter=new MyAdapter(this);
		
		// 設定  ListView 的資料來源
		lstPrefer.setAdapter(adapter);
		// 設定 lstPrefer 元件 ItemClick 事件的 listener為 lstPreferListener
        //lstPrefer.setOnItemClickListener(lstPreferListener);
		lstPrefer.setOnItemClickListener(lstPreferListener);
	}
	public void back(View view){
		Intent intent=new Intent();
		intent.setClass(findpage.this,major.class);
		Bundle bundle=new Bundle();
		bundle.putString("idd", data1);
		bundle.putString("name2", username);
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
			return y; 
		}   
		@Override    
		public Object getItem(int position){        
			return Balls2[position];    
		}      
	    @Override    
	    public long getItemId(int position){        
	    	return position;    
	    }      
	    @Override   
	    public View getView(int position,View convertView,ViewGroup parent){   	   
	    	convertView = myInflater.inflate(R.layout.mylayout, null);  
	    	
			// 取得  mylayout.xml 中的元件 
			ImageView imgLogo = (ImageView) convertView.findViewById(R.id.imgLogo);		
			TextView txtName = ((TextView) convertView.findViewById(R.id.txtName));
			TextView txtengName = ((TextView) convertView.findViewById(R.id.txtengName));	
		
			// 設定元件內容        
			imgLogo.setImageResource(resIds2[position]);
			txtName.setText(Balls2[position]);     
			txtengName.setText(engNames2[position]); 

			return convertView;   
		}
	}
	
	private ListView.OnItemClickListener lstPreferListener=
	    	new ListView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
			 int position, long id) {
				int a=resIds2[position];
				int b=Integer.parseInt(engNames2[position]);
				String s1 = Balls2[position];
				String s2 = intr2[position];
				Intent intent=new Intent();
				intent.setClass(findpage.this,comtest.class);
				Bundle bundle=new Bundle();
				bundle.putString("NAME2", s1);
				bundle.putString("intr", s2);
				bundle.putInt("id", a);
				bundle.putInt("money", b);
				bundle.putString("uid", data1);
				bundle.putString("uname", username);
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