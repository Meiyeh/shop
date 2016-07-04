package com.example.shop;



import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

public class commodity extends Activity {
	private int[] imageIds = {
			R.drawable.p1,
		};
	private TextView t1,t2,t3;
	private ImageView i1,i2,i3,i4,i5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.commodity);
		t1=(TextView) findViewById(R.id.textView1);
		t2=(TextView) findViewById(R.id.textView2);
		t3=(TextView) findViewById(R.id.textView3);
		i1=(ImageView) findViewById(R.id.imageView1);
		i2=(ImageView) findViewById(R.id.imageView2);
		i3=(ImageView) findViewById(R.id.imageView3);
		i4=(ImageView) findViewById(R.id.imageView4);
		i5=(ImageView) findViewById(R.id.imageView5);
        MyAdapter adapter=new MyAdapter(this);
		Gallery gal=(Gallery)findViewById(R.id.gallery1);
		gal.setAdapter(adapter);
		gal.setOnItemSelectedListener(galListener);
		gal.setSelection(Integer.MAX_VALUE/2);
	}
	private Gallery.OnItemSelectedListener galListener=new Gallery.OnItemSelectedListener(){
		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position,
				long id) {
			i1.setImageResource(imageIds[position % imageIds.length]);	
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0){
			// TODO Auto-generated method stub
		}
	}; 
	class MyAdapter extends BaseAdapter {
    	private Context mContext; 
    	public MyAdapter(Context c){
    		mContext=c;
    	}    		
    	public int getCount(){
    		return Integer.MAX_VALUE; // 設定圖片數量為系統最大整數
    	}
    	public Object getItem(int position){			    
    		return position;     		
    	}
    	public long getItemId(int position){
    		return position; // 目前圖片索引 
    	}
    	
    	// 設定 imageView 的圖片、顯示方式在中間，大小是 120x90    	
    	public View getView(int position, View contextView, ViewGroup parent){
    		ImageView iv = new ImageView(mContext);    		
    		iv.setImageResource(imageIds[position % imageIds.length]); 
     		iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
    		iv.setLayoutParams(new Gallery.LayoutParams(120,90));
    		return iv;
    	} 
    }
	public void buy(View view){
		new AlertDialog.Builder(commodity.this)
		.setTitle("確認視窗")
		.setIcon(R.drawable.ic_launcher)
		.setMessage("選擇購買方式")
		.setPositiveButton("單人購買", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialoginterface, int i)
			{
				Intent intent=new Intent();
				intent.setClass(commodity.this,singlebuy.class);
				startActivity(intent);
			}
		})
		.setNeutralButton("多人團購", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialoginterface, int i)
			{
				Intent intent2=new Intent();
				intent2.setClass(commodity.this,multibuy.class);
				startActivity(intent2);
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