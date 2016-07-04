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

public class major extends Activity {
	private TextView t1,t2;
	private EditText e1;
	private String data1,username;
	ListView lstPrefer;
	int[] resIds = new int[]{ R.drawable.m1, R.drawable.m2, R.drawable.m3,R.drawable.m4,R.drawable.m5};
	String[] Balls= new String[] {"iphone6","ipad","ASUS X550","ACER 4755G","HTC M9"};  
	String[] engNames = { "18000", "12000","30000","25000","20000"};
	//String[] intr = { "便宜", "好用","有點貴","kevin lai using","國產品質"};
	String[] intr = { "iOS作業系統  雙核心處理器\n主相機800萬畫素  前相機120萬畫素\n64 位元 A8 晶片與 M8 協同處理器\n1GB RAM / 64GB ROM\n"
			, "iOS作業系統  雙核心處理器\n主相機70萬畫素  前相機30萬畫素\n1GHz Apple A5 雙核心處理器\n512MB RAM / 16GB ROM\n"
			,"處理器：Intel Core i5-3230M(2.6GHz)\n記憶體：4GB DDRIII 1600\n硬碟：500GB 5400轉\n作業系統：64 Bits Windows 8\n"
			,"CPU：Intel Core i5-2410M 2.3GHz\n記憶體：Kingston DDR3 1333 4GBx2\n硬碟：TOSHIBA MK7559GSXP 750GB 5400RPM\n螢幕：14吋 HD 1366 x 768 LED LCD(鏡面)"
			,"Android 作業系統  八核心處理器\n主相機2000萬畫素  前相機400萬畫素\nMTK Helio X10 MT6795T 2.2GHz\n3GB RAM / 32GB ROM\n"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.major);
		t1=(TextView) findViewById(R.id.textView1);
		t2=(TextView) findViewById(R.id.textView2);
		e1= (EditText)findViewById(R.id.editText1);
		lstPrefer=(ListView)findViewById(R.id.listView1);
        MyAdapter adapter=new MyAdapter(this);
		lstPrefer.setAdapter(adapter);
        lstPrefer.setOnItemClickListener(lstPreferListener);
		Intent a = this.getIntent();
		Bundle b = a.getExtras();
		data1=(b.getString("idd"));
		username=(b.getString("name2"));
		
	}
	public void toinvite(View view){
		Intent intent=new Intent();
		intent.setClass(major.this,invite.class);
		Bundle bundle=new Bundle();
		bundle.putString("id", data1);
		bundle.putString("name", username);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	public void topersonal(View view){
		Intent intent=new Intent();
		intent.setClass(major.this,personal.class);
		Bundle bundle=new Bundle();
		bundle.putString("id", data1);
		bundle.putString("name", username);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	public void find(View view){
		String s1 = e1.getText().toString();
		Intent intent=new Intent();
		intent.setClass(major.this,findpage.class);
		Bundle bundle=new Bundle();
		bundle.putString("NAME", s1); 
		bundle.putString("id", data1);
		bundle.putString("name", username);
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
	    	
			// 取得  mylayout.xml 中的元件 
			ImageView imgLogo = (ImageView) convertView.findViewById(R.id.imgLogo);		
			TextView txtName = ((TextView) convertView.findViewById(R.id.txtName));
			TextView txtengName = ((TextView) convertView.findViewById(R.id.txtengName));	
		
			// 設定元件內容        
			imgLogo.setImageResource(resIds[position]);
			txtName.setText(Balls[position]);     
			txtengName.setText(engNames[position]); 

			return convertView;   
		}    
	}
     //  定義  onItemClick 方法
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
			intent.setClass(major.this,comtest.class);
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