package com.example.shop;

import java.util.concurrent.ExecutionException;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class seepeopleInMap extends Activity {
	GoogleMap gmap; //宣告 google map 物件
	float zoom;
	Marker marker;
	
	String[] joiner;
	String[] longitude;
	String[] latitude;
	String name,thing,uid,uname;
	int n=0;
	LatLng[] aryLatLng;
		@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seepeopleinmap);
		
		Intent intent1=this.getIntent();
        Bundle bundle=intent1.getExtras();
        name=(bundle.getString("name"));//召集人kevin
		thing=(bundle.getString("thing"));//做什麼事
		
		uid=(bundle.getString("uid"));
		uname=(bundle.getString("uname"));
		UpdateAdapter();
		
		//取得 google map 元件     
		gmap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap(); 
		gmap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

		gmap.getUiSettings().setCompassEnabled(true);
		gmap.getUiSettings().setZoomControlsEnabled(true);
        // 設定地圖座標值:緯度,經度
      	zoom=17; //設定放大倍率1(地球)-21(街景)
      	gmap.setOnMarkerClickListener(gmapListener);

      	for ( int i=0; i<n; ++i){
	      	LatLng Point = aryLatLng[i];
			gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(Point, zoom));		
			// 建立標記的選項
			MarkerOptions markerOpt = new MarkerOptions();
			markerOpt.position(Point); // 標記位置
			markerOpt.title(joiner[i]); // 標題
			//markerOpt.snippet(Snippets[i]); // 說明文字
			markerOpt.draggable(false); // 標記不可拖曳
			markerOpt.visible(true);    // 顯示標記
			markerOpt.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
			gmap.addMarker(markerOpt);
      	}
	}
	
	public void UpdateAdapter(){
        try {
            String applylist = new AutoUpdateActivity5().execute(name,thing).get();
            String[] AfterSplit = applylist.split(";");
            if (applylist.equals("SELECT Failed") || applylist.equals("")){
                String[]List = {""};
                
                return;
            }
            else{
            	n=AfterSplit.length;
                joiner=new String[AfterSplit.length];
                longitude=new String[AfterSplit.length];
                latitude=new String[AfterSplit.length];
                aryLatLng=new LatLng[AfterSplit.length];
                for (int i=0; i<AfterSplit.length; i++){
                    String[] temp = AfterSplit[i].split("!");
                    joiner[i]=temp[0];
                    longitude[i]=temp[1];
                    latitude[i]=temp[2];
                    double lat= Double.parseDouble(latitude[i]);
                    double lng= Double.parseDouble(longitude[i]);
                    aryLatLng[i]=new LatLng(lat,lng);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
	
	private GoogleMap.OnMarkerClickListener gmapListener=new GoogleMap.OnMarkerClickListener(){
		@Override
		public boolean onMarkerClick(Marker marker) {
			marker.showInfoWindow();
			Toast.makeText(getApplication(), 
					marker.getTitle()+ "\n" + marker.getSnippet(),
					Toast.LENGTH_LONG).show();
			return true;
		}		
	};
	
	public void back(View view){
		Intent intent=new Intent();
		intent.setClass(seepeopleInMap.this,personal.class);
		Bundle bundle=new Bundle();
		bundle.putString("id",uid);//uid
    	bundle.putString("name",uname);//uname
		intent.putExtras(bundle);
		startActivity(intent);
	}
	
	public void back_mul(View view){
		Intent intent=new Intent();
		intent.setClass(seepeopleInMap.this,inviteinf.class);
		Bundle bundle=new Bundle();
		bundle.putString("uid",uid);//uid
    	bundle.putString("uname",uname);//uname
		intent.putExtras(bundle);
		startActivity(intent);
	}
	
	
}
