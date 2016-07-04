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
	GoogleMap gmap; //�ŧi google map ����
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
        name=(bundle.getString("name"));//�l���Hkevin
		thing=(bundle.getString("thing"));//�������
		
		uid=(bundle.getString("uid"));
		uname=(bundle.getString("uname"));
		UpdateAdapter();
		
		//���o google map ����     
		gmap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap(); 
		gmap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

		gmap.getUiSettings().setCompassEnabled(true);
		gmap.getUiSettings().setZoomControlsEnabled(true);
        // �]�w�a�Ϯy�Э�:�n��,�g��
      	zoom=17; //�]�w��j���v1(�a�y)-21(��)
      	gmap.setOnMarkerClickListener(gmapListener);

      	for ( int i=0; i<n; ++i){
	      	LatLng Point = aryLatLng[i];
			gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(Point, zoom));		
			// �إ߼аO���ﶵ
			MarkerOptions markerOpt = new MarkerOptions();
			markerOpt.position(Point); // �аO��m
			markerOpt.title(joiner[i]); // ���D
			//markerOpt.snippet(Snippets[i]); // ������r
			markerOpt.draggable(false); // �аO���i�즲
			markerOpt.visible(true);    // ��ܼаO
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
