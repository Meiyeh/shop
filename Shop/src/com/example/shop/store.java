package com.example.shop;

import java.util.List;
import java.util.Locale;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class store extends Activity {
	GoogleMap gmap;
	Marker marker;
	float zoom;
	
	private int No_county=0,No_city=0;
	private TextView Address;
	private EditText e1;
	String name,intr,location;
	private String data1,username;
	int n1,n2,n3;
	private Spinner spn_city,spn_county;
    private ArrayAdapter<String> countyList;
    private ArrayAdapter<String> cityList;
	private String mark="�ثe��ܦ�m";
    private String[] county = {"�򶩥�", "�x�_��", "�s�_��", "��饫", "�s�˿�", "�s�˥�",
    "�]�߿�", "�x����", "���ƿ�", "�n�뿤", "���L��", "�Ÿq��", "�Ÿq��", "�x�n��",
    "������", "�̪F��", "�x�F��", "�Ὤ��", "�y����", "�s����", "������", "���"};
    private String[] city=new String[] {"", "", "", "", "", ""};
	private String[] city1=new String[] {"", "������", "�C����", "�x�x��", "�w�ְ�", "���s��"};
	private String[] city2={"", "�Q�s��", "�H�q��", "�j�w��", "���s��", "������"};
    private String[] city3={"", "�O����", "�T����", "���M��", "�éM��", "�s����"};
    private String[] city4={"", "����", "���c��", "�K�w��", "�����", "�t�s��"};
    private String[] city5={"", "�˥_��", "�˪F��", "�s�H��", "������", "��f�m"};
    private String[] city6={"", "�F��", "�_��", "���s��", "", ""};
    private String[] city7={"", "�]�ߥ�", "�˫n��", "���s��", "�Y����", "�y���m"};
    private String[] city8={"", "�׭��", "����", "�j����", "�F��", "�n��"};
    private String[] city9={"", "���ƥ�", "������", "����m", "�u��m", "�q���m"};
    private String[] city10={"", "�n�륫", "�H����", "�����", "�ˤs��", "������"};
    private String[] city11={"", "�椻��", "��n��", "�����", "������", "�g�w��"};
    private String[] city12={"", "�ӫO��", "���l��", "���U��", "�j�L��", "�����m"};
    private String[] city13={"", "�F��", "���", "", "", ""};
    private String[] city14={"", "�s���", "�w�n��", "�w����", "�ñd��", "�_��"};
    private String[] city15={"", "��s��", "�Q�L��", "���s��", "�L���", "�j�d��"};
    private String[] city16={"", "�̪F��", "��{��", "�F����", "��K��", "�U���m"};
    private String[] city17={"", "�x�F��", "���\��", "���s��", "���n�m", "�����m"};
    private String[] city18={"", "�Ὤ��", "��L��", "�ɨ���", "�s���m", "�N�w�m"};
    private String[] city19={"", "�y����", "ù�F��", "Ĭ�D��", "�Y����", "�G�˶m"};
    private String[] city20={"", "�n��m", "�_��m", "�F�޶m", "", ""};
    private String[] city21={"", "������", "���F��", "������", "����m", "�P���m"};
    private String[] city22={"", "������", "���m", "�ըF�m", "�����m", "�C���m"};
    private  String[] shop={"", "�򶩥������ϥ_���327��1��", "�򶩥��C���ϩ��w�@��174��", "�򶩥��x�x�ϤK����142��", "�򶩥��w�ְϰ���@��381��383��1��", "�򶩥����s�Ϥ��ظ�9��",
    		"", "�x�_���Q�s�ϴ��ƥ_��168��B2", "�x�_���H�q�ϧd����156��2��2��4��1��", "�x�_���j�w��ù���ָ�3�q283��14��16��1��", "�x�_�����s�ϩ�����581��15��1��", "�x�_�������ϪL�˫n��4����3",
    		"", "�s�_���O���ϪF�C�����ɵ�53��", "�s�_���T���Ϥj����139��139��2��1��", "�s�_�����M�Ϻֲ���27�F�éM��56��58��1��", "�s�_���éM�Ϥ�����559��561��1��2��", "�s�_���s���Ϥ��s��3�q488��490��",
    		"", "��饫���Ϥj�~��1�q54��56��1��", "��饫���c�Ϥ�������G�q259��259-1��1��", "��饫�K�w�ϩ��i��197��", "��饫����Ϥ��׸��@�q281��1��1��", "��饫�t�s�ϥ��p���d�H�s��15��1��",
    		"", "�s�˿��˥_�����q�_��130��", "�s�˿��˪F�������538��25��", "�s�˿��s�H������619��621��", "�s�˿�������ۥ����۩��l252��1��", "�s�˿���f�m�j�P��26��6��",
    		"", "�s�˥��F�Ϫ��s�Q�C��1��", "�s�˥��_��������22�F������46��", "�s�˥����s�ϭ��_��181��183��", "", "",
    		"", "�]�߿��]�ߥ�������904��", "�]�߿��˫n��Ѥ��176��", "�]�߿����s��j�s���s���6��1��", "�]�߿��Y��������319��1��", "�]�߿��y���m�Q�r��16��",
    		"", "�x�����׭�ϤT�׸�909��", "�x�������ϫذ��172��", "�x�����j���Ϥ�����2�q833��835��", "�x�����F�ϥx����195��197��199��", "�x�����n�Ϸs�a���_����3�q140��",
    		"", "���ƿ����ƥ��j�˨����n��2�q181��", "���ƿ�������F�T�����������q7��", "���ƿ�����m�s���������1�q355��", "���ƿ��u��m�J�H���u�����@�q892��", "���ƿ��q���m�������G�q795-1��",
    		"", "�n�뿤�n�륫��_��������3��", "�n�뿤�H�����s��1�q423��", "�n�뿤���������T�q219-1��", "�n�뿤�ˤs���s���۱j��176��", "�n�뿤������d�����͸�63��",
    		"", "���L���椻���[�p�����q��52��1��", "���L����n�������G�q581��1��", "���L�����������307��", "���L��������ؿ���163��1��2��", "���L���g�w��ذ��164��",
    		"", "�Ÿq���ӫO����樽���408-7��408-8���@��", "�Ÿq�����l���j�m��1�F�j(��d)�}179��4��", "�Ÿq�����U������14�F�W����177��", "�Ÿq���j�L���L�����R��23��25��27��1��", "�Ÿq�������m�T�����j�Ǹ��@�q421��",
    		"", "�Ÿq���F�Ϥ��Ш��L�˪F��288��", "�Ÿq����ϫO�֨��K�w��237��", "", "", "",
    		"", "�x�n���s��Ϥӥ_���Ӥl�c142-34��", "�x�n���w�n�Ϸs�������w��151��", "�x�n���w���ϰꥭ���奭��217��", "�x�n���ñd���Q�樽���R��68��70��1��", "�x�n���_�ϩM�n��5�q76��",
    		"", "��������s�ϥ��q����Ҹ�491��493��", "�������Q�L�Ϥj�����G��", "���������s�ϤE�p�|��1432��1434��", "�������L��Ϧ�˸�133-30��", "�������j�d�ϻ�L�T��359��361��",
    		"", "�̪F���̪F���s�ب��s�ظ�152��156��1��", "�̪F����{��T�M��������89��", "�̪F���F������Y�����Y��26-33��1��", "�̪F����K���_��������193��", "�̪F���U���m�U�������a��625��",
    		"", "�x�F���x�F�����ظ��@�q175��", "�x�F�����\��T�����j�P��70��", "�x�F�����s��M����4��4��1��1��", "�x�F�����n�m�Ŭu���s�u��59��", "�x�F�������m���������ظ��@�q430��",
    		"", "�Ὤ���Ὤ�����e��298��298��1��1��", "�Ὤ����L�������������108��1��", "�Ὤ���ɨ����s��2�q90��1��", "�Ὤ���s���m�_�H��282��", "�Ὤ���N�w�m�n�H�K��223��",
    		"", "�y�����y�������s��212��", "�y����ù�F���F�n��188��", "�y����Ĭ�D��n���41��42��", "�y�����Y����C����2�q230��1��", "�y�����G�˶m�j�����j����120-122��",
    		"", "�s�����n��m���ا�3�F48-2��", "�s�����_��m��������s��193��195��", "�s�����F�޶m���h��85�P86��1��", "", "",
    		"", "���������������q�n����e�q2��4��", "���������F��Z�F���ꤤ��2��", "��������������͸�6��", "����������m�j�Ǹ�1��(�ǥ��\�U1��)", "�������P���m�L����F�L��156��",
    		"", "��򿤰��������y�����v��55��", "��򿤴��m�i��34��2��", "��򿤥ըF�m���r��20�F�j���r351��1��", "��򿤦����m�X�ɧ�3-1��", "��򿤤C���m�n����n��50��51��"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.store);
		Address=(TextView)findViewById(R.id.Address);
		final TextView txtView = (TextView)findViewById(R.id.textView2);
        Intent intent1=this.getIntent();
        Bundle bundle=intent1.getExtras();
        n1=bundle.getInt("id");
        n2=bundle.getInt("money");
        n3=bundle.getInt("many");
        name=(bundle.getString("NAME2"));
		intr=(bundle.getString("intr"));
		data1=(bundle.getString("uid"));
		username=(bundle.getString("uname"));
		
		spn_county = (Spinner)findViewById(R.id.spn_county);
        spn_city = (Spinner)findViewById(R.id.spn_city);
        
        countyList = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, county);
        spn_county.setAdapter(countyList);
        spn_county.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
            	No_county=position;
                switch (position){
                    case 0:
                        for(int i=0; i<6; ++i)
                        { city[i]=city1[i]; }
                        break;
                    case 1:
                        for(int i=0; i<6; ++i)
                        { city[i]=city2[i]; }
                        break;
                    case 2:
                        for(int i=0; i<6; ++i)
                        { city[i]=city3[i]; }
                        break;
                    case 3:
                        for(int i=0; i<6; ++i)
                        { city[i]=city4[i]; }
                        break;
                    case 4:
                        for(int i=0; i<6; ++i)
                        { city[i]=city5[i]; }
                        break;
                    case 5:
                        for(int i=0; i<6; ++i)
                        { city[i]=city6[i]; }
                        break;
                    case 6:
                        for(int i=0; i<6; ++i)
                        { city[i]=city7[i]; }
                        break;
                    case 7:
                        for(int i=0; i<6; ++i)
                        { city[i]=city8[i]; }
                        break;
                    case 8:
                        for(int i=0; i<6; ++i)
                        { city[i]=city9[i]; }
                        break;
                    case 9:
                        for(int i=0; i<6; ++i)
                        { city[i]=city10[i]; }
                        break;
                    case 10:
                        for(int i=0; i<6; ++i)
                        { city[i]=city11[i]; }
                        break;
                    case 11:
                        for(int i=0; i<6; ++i)
                        { city[i]=city12[i]; }
                        break;
                    case 12:
                        for(int i=0; i<6; ++i)
                        { city[i]=city13[i]; }
                        break;
                    case 13:
                        for(int i=0; i<6; ++i)
                        { city[i]=city14[i]; }
                        break;
                    case 14:
                        for(int i=0; i<6; ++i)
                        { city[i]=city15[i]; }
                        break;
                    case 15:
                        for(int i=0; i<6; ++i)
                        { city[i]=city16[i]; }
                        break;
                    case 16:
                        for(int i=0; i<6; ++i)
                        { city[i]=city17[i]; }
                        break;
                    case 17:
                        for(int i=0; i<6; ++i)
                        { city[i]=city18[i]; }
                        break;
                    case 18:
                        for(int i=0; i<6; ++i)
                        { city[i]=city19[i]; }
                        break;
                    case 19:
                        for(int i=0; i<6; ++i)
                        { city[i]=city20[i]; }
                        break;
                    case 20:
                        for(int i=0; i<6; ++i)
                        { city[i]=city21[i]; }
                        break;
                    case 21:
                        for(int i=0; i<6; ++i)
                        { city[i]=city22[i]; }
                        break;
                }
			}

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        
        cityList = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, city);
        spn_city.setAdapter(cityList);
        spn_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
            	double latitude,longitude;
            	No_city=position;
                int n=No_county*6+No_city;
                String s=shop[n];
                Address.setText(s);
                LatLng[] aryLatLng={new LatLng(25.033611,121.565000)};
                try{
                	Geocoder geoCoder = new Geocoder(store.this, Locale.getDefault());
                	List<Address> addressLocation = geoCoder.getFromLocationName(s, 1);
                	latitude = addressLocation.get(0).getLatitude();
                	longitude = addressLocation.get(0).getLongitude();
                	aryLatLng[0]=new LatLng(latitude,longitude);
                }catch(Exception e){
                	e.printStackTrace();
                }
                CameraPosition cameraPosition=new CameraPosition.Builder()
						.target(aryLatLng[0])
						.zoom(zoom)
						.bearing(0)
						.tilt(0)
						.build();
				gmap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
				
				LatLng Point = aryLatLng[0]; 
				gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(Point, zoom));		
				// �إ߼аO���ﶵ
				MarkerOptions markerOpt = new MarkerOptions();
				markerOpt.position(Point); // �аO��m
				markerOpt.title(county[No_county]+" "+city[No_city]); // ���D
				markerOpt.snippet(mark); // ������r
				markerOpt.draggable(false); // �аO���i�즲
				markerOpt.visible(true);    // ��ܼаO
				markerOpt.anchor(0.5f, 0.5f);//�]���Ϥ�����
				markerOpt.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
				gmap.addMarker(markerOpt);
                location=s;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        gmap=((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
		gmap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		gmap.getUiSettings().setCompassEnabled(true);
		gmap.getUiSettings().setZoomControlsEnabled(true);
		zoom=17;
		
		gmap.setOnMarkerClickListener(gmapListener); // �]�w��ť
        
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
	
	public void go(View view){
		//location=e1.getText().toString();
		Intent intent=new Intent();
		intent.setClass(store.this,scheck.class);
		Bundle bundle=new Bundle();
		bundle.putString("NAME2", name);//cname
		bundle.putString("intr", intr);//cintr
		bundle.putInt("id", n1);//cid
		bundle.putInt("money", n2);//cprize
		bundle.putInt("many", n3);//cmany
		bundle.putString("uid", data1);//uid
		bundle.putString("uname", username);//uname
		bundle.putString("location", location);//location
		intent.putExtras(bundle);
		startActivity(intent);
	}
	public void back(View view){
		Intent intent=new Intent();
		intent.setClass(store.this,singlebuy.class);
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
	/*
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case R.id.menu_normal:
				gmap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
				break;
			case R.id.menu_hybrid:
				gmap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			case R.id.menu_satellite:
				gmap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
				break;
			case R.id.menu_terrain:
				gmap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
				break;
		}
		return super.onOptionsItemSelected(item);
	}*/

}