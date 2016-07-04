package com.example.shop;



import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
public class invite extends Activity {
	private TextView t1,t2,t3,t4;
	private int a1;
	private double ip1,ip2;
	private String uid,uname,ip01,ip02;
	private LocationManager mLocationManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.invite);
		t1=(TextView)findViewById(R.id.textView1);
		t2=(TextView)findViewById(R.id.textView2);
		t3=(TextView)findViewById(R.id.textView3);
		t4=(TextView)findViewById(R.id.textView4);
		mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Intent a = this.getIntent();
		Bundle b = a.getExtras();
		uid=(b.getString("id"));
		uname=(b.getString("name"));
	}
	public void getip(View view){
		mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,10000.0f,LocationChange);
	}
	public void gonew(View view){
		//mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,10000.0f,LocationChange);
		Intent intent=new Intent();
		intent.setClass(invite.this,invitenew.class);
		Bundle bundle=new Bundle();
		bundle.putString("uid", uid);
		bundle.putString("uname", uname);
		bundle.putString("ip1", ip01);
		bundle.putString("ip2", ip02);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	public void find(View view){
		Intent intent=new Intent();
		intent.setClass(invite.this,invitesearch.class);
		Bundle bundle=new Bundle();
		bundle.putString("uid", uid);
		bundle.putString("uname", uname);
		bundle.putString("ip1", ip01);
		bundle.putString("ip2", ip02);
		intent.putExtras(bundle);
		startActivity(intent);
		
	}
	public void inf(View view){
		Intent intent=new Intent();
		intent.setClass(invite.this,inviteinf.class);
		Bundle bundle=new Bundle();
		bundle.putString("uid", uid);
		bundle.putString("uname", uname);
		intent.putExtras(bundle);
		startActivity(intent);
		
	}
    public void backp(View view){
    	Intent intent=new Intent();
		intent.setClass(invite.this,personal.class);
		Bundle bundle=new Bundle();
		bundle.putString("id", uid);
		bundle.putString("name", uname);
		intent.putExtras(bundle);
		startActivity(intent);
		
	}
    public void backm(View view){
    	Intent intent2=new Intent();
		intent2.setClass(invite.this,major.class);
		Bundle bundle=new Bundle();
		bundle.putString("idd", uid);
		bundle.putString("name2", uname);
		intent2.putExtras(bundle);
		startActivity(intent2);
		
	}
    
    public LocationListener LocationChange = new LocationListener() 
	{
		public void onLocationChanged(Location mLocation) 
	     {
	      //印出我的座標-經度緯度
	      //Log.d("TAG", "我的座標 - 經度 : " + mLocation.getLongitude() + "  , 緯度 : " + mLocation.getLatitude() );
	      t3.setText("經度="+String.valueOf(mLocation.getLongitude()));
	      t4.setText("緯度="+String.valueOf(mLocation.getLatitude()));
	      ip01=String.valueOf(mLocation.getLongitude());
	      ip02=String.valueOf(mLocation.getLatitude());
	      
	    }

	    public void onProviderDisabled(String provider) 
	    {
	    }
	         
	    public void onProviderEnabled(String provider) 
	    {
	    }
	         
	    public void onStatusChanged(String provider, int status,Bundle extras) 
	    {
	    }
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
