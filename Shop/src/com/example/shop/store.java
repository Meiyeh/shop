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
	private String mark="目前選擇位置";
    private String[] county = {"基隆市", "台北市", "新北市", "桃園市", "新竹縣", "新竹市",
    "苗栗縣", "台中市", "彰化縣", "南投縣", "雲林縣", "嘉義縣", "嘉義市", "台南市",
    "高雄市", "屏東縣", "台東縣", "花蓮縣", "宜蘭縣", "連江縣", "金門縣", "澎湖縣"};
    private String[] city=new String[] {"", "", "", "", "", ""};
	private String[] city1=new String[] {"", "中正區", "七堵區", "暖暖區", "安樂區", "中山區"};
	private String[] city2={"", "松山區", "信義區", "大安區", "中山區", "中正區"};
    private String[] city3={"", "板橋區", "三重區", "中和區", "永和區", "新莊區"};
    private String[] city4={"", "桃園區", "中壢區", "八德區", "平鎮區", "龜山區"};
    private String[] city5={"", "竹北市", "竹東鎮", "新埔鎮", "關西鎮", "湖口鄉"};
    private String[] city6={"", "東區", "北區", "香山區", "", ""};
    private String[] city7={"", "苗栗市", "竹南鎮", "後龍鎮", "頭份鎮", "造橋鄉"};
    private String[] city8={"", "豐原區", "中區", "大里區", "東區", "南區"};
    private String[] city9={"", "彰化市", "鹿港鎮", "伸港鄉", "線西鄉", "秀水鄉"};
    private String[] city10={"", "南投市", "埔里鎮", "草屯鎮", "竹山鎮", "集集鎮"};
    private String[] city11={"", "斗六市", "斗南鎮", "虎尾鎮", "西螺鎮", "土庫鎮"};
    private String[] city12={"", "太保市", "朴子市", "布袋鎮", "大林鎮", "民雄鄉"};
    private String[] city13={"", "東區", "西區", "", "", ""};
    private String[] city14={"", "新營區", "安南區", "安平區", "永康區", "北區"};
    private String[] city15={"", "鳳山區", "鹽埕區", "鼓山區", "林園區", "大寮區"};
    private String[] city16={"", "屏東市", "潮州鎮", "東港鎮", "恆春鎮", "萬丹鄉"};
    private String[] city17={"", "台東市", "成功鎮", "關山鎮", "卑南鄉", "鹿野鄉"};
    private String[] city18={"", "花蓮市", "鳳林鎮", "玉里鎮", "新城鄉", "吉安鄉"};
    private String[] city19={"", "宜蘭市", "羅東鎮", "蘇澳鎮", "頭城鎮", "礁溪鄉"};
    private String[] city20={"", "南竿鄉", "北竿鄉", "東引鄉", "", ""};
    private String[] city21={"", "金湖鎮", "金沙鎮", "金城鎮", "金寧鄉", "烈嶼鄉"};
    private String[] city22={"", "馬公市", "湖西鄉", "白沙鄉", "西嶼鄉", "七美鄉"};
    private  String[] shop={"", "基隆市中正區北寧路327號1樓", "基隆市七堵區明德一路174號", "基隆市暖暖區八堵路142號", "基隆市安樂區基金一路381號383號1樓", "基隆市中山區中華路9號",
    		"", "台北市松山區敦化北路168號B2", "台北市信義區吳興街156巷2弄2號4號1樓", "台北市大安區羅斯福路3段283巷14弄16號1樓", "台北市中山區明水路581巷15號1樓", "台北市中正區林森南路4號之3",
    		"", "新北市板橋區東丘里民享街53號", "新北市三重區大智街139號139之2號1樓", "新北市中和區福祥里27鄰永和路56號58號1樓", "新北市永和區中正路559號561號1樓2樓", "新北市新莊區中山路3段488號490號",
    		"", "桃園市桃園區大業路1段54號56號1樓", "桃園市中壢區中央西路二段259號259-1號1樓", "桃園市八德區忠勇街197號", "桃園市平鎮區中豐路一段281之1號1樓", "桃園市龜山區光峰路千禧新城15號1樓",
    		"", "新竹縣竹北市莊敬北路130號", "新竹縣竹東鎮光明路538巷25號", "新竹縣新埔鎮中正路619號621號", "新竹縣關西鎮石光里石岡子252號1樓", "新竹縣湖口鄉大同路26號6樓",
    		"", "新竹市東區金山十七街1號", "新竹市北區湳雅里22鄰湳雅街46號", "新竹市香山區香北路181號183號", "", "",
    		"", "苗栗縣苗栗市中正路904號", "苗栗縣竹南鎮天文路176號", "苗栗縣後龍鎮大山里龍文路6號1樓", "苗栗縣頭份鎮中正路319號1樓", "苗栗縣造橋鄉十字路16號",
    		"", "台中市豐原區三豐路909號", "台中市中區建國路172號", "台中市大里區中興路2段833號835號", "台中市東區台中路195號197號199號", "台中市南區新榮里復興路3段140號",
    		"", "彰化縣彰化市大竹里彰南路2段181號", "彰化縣鹿港鎮東崎里彰鹿路五段7號", "彰化縣伸港鄉新港村中興路1段355號", "彰化縣線西鄉寓埔村沿海路一段892號", "彰化縣秀水鄉彰水路二段795-1號",
    		"", "南投縣南投市營北里學藝路3號", "南投縣埔里鎮中山路1段423號", "南投縣草屯鎮芬草路三段219-1號", "南投縣竹山鎮中山里自強路176號", "南投縣集集鎮吳厝里民生路63號",
    		"", "雲林縣斗六市崙峰里仁義路52號1樓", "雲林縣斗南鎮延平路二段581號1樓", "雲林縣虎尾鎮中正路307號", "雲林縣西螺鎮建興路163號1樓2樓", "雲林縣土庫鎮建國路164號",
    		"", "嘉義縣太保市後潭里後潭408-7號408-8號一樓", "嘉義縣朴子市大鄉里1鄰大(木康)榔179之4號", "嘉義縣布袋鎮興中里14鄰上海路177號", "嘉義縣大林鎮西林里仁愛路23號25號27號1樓", "嘉義縣民雄鄉三興村大學路一段421號",
    		"", "嘉義市東區王田里林森東路288號", "嘉義市西區保福里八德路237號", "", "", "",
    		"", "台南市新營區太北里太子宮142-34號", "台南市安南區新順里培安路151號", "台南市安平區國平里文平路217號", "台南市永康區鹽行里仁愛街68號70號1樓", "台南市北區和緯路5段76號",
    		"", "高雄市鳳山區正義里鳳甲路491號493號", "高雄市鹽埕區大公路二號", "高雄市鼓山區九如四路1432號1434號", "高雄市林園區西溪路133-30號", "高雄市大寮區鳳林三路359號361號",
    		"", "屏東縣屏東市龍華里龍華路152號156號1樓", "屏東縣潮州鎮三和里延平路89號", "屏東縣東港鎮船頭里船頭路26-33號1樓", "屏東縣恆春鎮城北里中正路193號", "屏東縣萬丹鄉萬全村丹榮路625號",
    		"", "台東縣台東市中華路一段175號", "台東縣成功鎮三民里大同路70號", "台東縣關山鎮和平路4號4之1號1樓", "台東縣卑南鄉溫泉村龍泉路59號", "台東縣鹿野鄉鹿野村中華路一段430號",
    		"", "花蓮縣花蓮市府前路298號298之1號1樓", "花蓮縣鳳林鎮長橋里長橋路108號1樓", "花蓮縣玉里鎮中山路2段90號1樓", "花蓮縣新城鄉北埔路282號", "花蓮縣吉安鄉南埔八街223號",
    		"", "宜蘭縣宜蘭市泰山路212號", "宜蘭縣羅東鎮興東南路188號", "宜蘭縣蘇澳鎮南寧路41號42號", "宜蘭縣頭城鎮青雲路2段230號1樓", "宜蘭縣礁溪鄉大忠村大忠路120-122號",
    		"", "連江縣南竿鄉介壽村3鄰48-2號", "連江縣北竿鄉塘岐村中山路193號195號", "連江縣東引鄉中柳村85與86號1樓", "", "",
    		"", "金門縣金湖鎮環島南路湖前段2號4號", "金門縣金沙鎮汶沙里國中路2號", "金門縣金城鎮民生路6號", "金門縣金寧鄉大學路1號(學生餐廳1樓)", "金門縣烈嶼鄉林湖村東林路156號",
    		"", "澎湖縣馬公市重慶里民權路55號", "澎湖縣湖西鄉隘門34之2號", "澎湖縣白沙鄉赤崁村20鄰大赤崁351號1樓", "澎湖縣西嶼鄉合界村3-1號", "澎湖縣七美鄉南港村南滬50號51號"};

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
				// 建立標記的選項
				MarkerOptions markerOpt = new MarkerOptions();
				markerOpt.position(Point); // 標記位置
				markerOpt.title(county[No_county]+" "+city[No_city]); // 標題
				markerOpt.snippet(mark); // 說明文字
				markerOpt.draggable(false); // 標記不可拖曳
				markerOpt.visible(true);    // 顯示標記
				markerOpt.anchor(0.5f, 0.5f);//設為圖片中心
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
		
		gmap.setOnMarkerClickListener(gmapListener); // 設定偵聽
        
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