package com.example.shop;
import java.text.DecimalFormat;
import java.util.concurrent.ExecutionException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
public class invitesearch extends Activity {
	private TextView t1,t2;
	private EditText e1;
	ListView lstPrefer;
	private String uid,uname,ip01,ip02,longi,lati;
	String[] name;//發起者
	String[] thing;
	String[] goal;
	String[] now;
	String[] distancetext;
	double[] distance;
	int lenth1,lenth2;
	double my1,my2,get1,get2,input1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.invitesearch);
		t1=(TextView) findViewById(R.id.textView1);
		t2=(TextView) findViewById(R.id.textView2);
		e1= (EditText)findViewById(R.id.editText1);
		lstPrefer=(ListView)findViewById(R.id.listView1);
		Intent intent1=this.getIntent();
        Bundle bundle=intent1.getExtras();
        uid=(bundle.getString("uid"));
		uname=(bundle.getString("uname"));
		ip01=(bundle.getString("ip1"));
		ip02=(bundle.getString("ip2"));
		my1=Double.parseDouble(ip01);
		my2=Double.parseDouble(ip02);
		
	}
	
	public void back(View view){
		Intent intent=new Intent();
		intent.setClass(invitesearch.this,invite.class);
		Bundle bundle=new Bundle();
		bundle.putString("id",uid);//uid
    	bundle.putString("name",uname);//uname
		intent.putExtras(bundle);
		startActivity(intent);
	}
	
	public void find(View view){
		input1=Double.parseDouble(e1.getText().toString());
		UpdateAdapter();
		lenth2=0;
		for(int t=0;t<name.length;++t){
			if(distance[t]<input1*1000.0){
				lenth2++;
			}
		}
		MyAdapter adapter=new MyAdapter(this);
		lstPrefer.setAdapter(adapter);
		lstPrefer.setOnItemClickListener(lstPreferListener);
	}
	
	public void UpdateAdapter(){
        try {
            String applylist = new AutoUpdateActivity4().execute(uname).get();
            //Toast.makeText(SchedualActivity.this,applylist,Toast.LENGTH_SHORT).show();
            String[] AfterSplit = applylist.split(";");
            //Toast.makeText(SchedualActivity.this,applylist,Toast.LENGTH_SHORT).show();
            if (applylist.equals("SELECT Failed") || applylist.equals("")){
                String[]List = {""};
                //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.mylayout,R.id.item,List);
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                		this,android.R.layout.simple_list_item_1,List);
                lstPrefer.setAdapter(adapter);
                //lstPrefer.setOnItemClickListener(lstPreferListener);
                return;
            }
            else{
                //String[] List = new String[AfterSplit.length];
                lenth1=AfterSplit.length;
                name=new String[lenth1];
                thing=new String[lenth1];
                goal=new String[lenth1];
                now=new String[lenth1];
                distancetext=new String[lenth1];
                distance = new double[lenth1];
                for (int i=0; i<AfterSplit.length; i++){
                    String[] temp = AfterSplit[i].split("!");
                    //String x=Integer.toString(i+1);
                    //List[i] = x+".發起人:"+temp[0] +"事情:"+ temp[1]+"集合位置:"+ temp[2]+"目標人數:"+ temp[3]+"目前人數:"+ temp[4];
                    name[i]=temp[0];
                    thing[i]=temp[1];
                    goal[i]=temp[2];
                    now[i]=temp[3];
                    longi=temp[4];
                    lati=temp[5];
                    get1=Double.parseDouble(longi);
                    get2=Double.parseDouble(lati);
                    distancetext[i]=DistanceText(Distance(my1,my2,get1,get2));
                    distance[i]=Distance(my1,my2,get1,get2);
                    //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.mylayout,R.id.item,List);  
                    //lstPrefer.setOnItemClickListener(lstPreferListener);
                }
                for(int i=0;i<distance.length;i++){
        			for(int t=i+1;t<distance.length;t++){
        				if(distance[i]>distance[t]){
        					double f=distance[i];
        					String a=name[i];
        					String b=thing[i];
        					String c=goal[i];
        					String d=now[i];
        					String e=distancetext[i];
        					
        					distance[i]=distance[t];
        					distance[t]=f;
        					
        					name[i]=name[t];
        					name[t]=a;
        					
        					thing[i]=thing[t];
        					thing[t]=b;
        					
        					goal[i]=goal[t];
        					goal[t]=c;
        					
        					now[i]=now[t];
        					now[t]=d;
        					
        					distancetext[i]=distancetext[t];
        					distancetext[t]=e;
        					
        				}
        			}
        		}
            }
            //Toast.makeText(SchedualActivity.this, AfterSplit[1], Toast.LENGTH_LONG).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
	
	public class MyAdapter extends BaseAdapter {           
		private LayoutInflater myInflater; 
		public MyAdapter(Context c){       
			myInflater = LayoutInflater.from(c); 	
		}     
		@Override  
		public int getCount(){    
			//return name.length;
			return lenth2;
		}   
		@Override    
		public Object getItem(int position){        
			return name[position];    
		}      
	    @Override    
	    public long getItemId(int position){        
	    	return position;    
	    }      
	    @Override   
	    public View getView(int position,View convertView,ViewGroup parent){   	   
	    	convertView = myInflater.inflate(R.layout.test, null);  
	    	
			// 取得  mylayout.xml 中的元件 		
			TextView tt1 = ((TextView) convertView.findViewById(R.id.textView1));
			TextView tt2 = ((TextView) convertView.findViewById(R.id.textView2));
			TextView tt3 = ((TextView) convertView.findViewById(R.id.textView3));
			TextView tt4 = ((TextView) convertView.findViewById(R.id.textView4));
		
			// 設定元件內容        
			tt1.setText(name[position]); 
			tt2.setText(thing[position]);
			tt3.setText(distancetext[position]);
			tt4.setText(now[position]+" / "+goal[position]);

			return convertView;   
		}    
	}
	
	public void gomview(String a,String b,String c,String d){
		if(c.equals(d)){
			new goinvite2(this).execute(a,b,uid,uname);
		}
		else{
			new goinvite1(this).execute(a,b,uid,uname,ip01,ip02);
			
		}
		//new jointest(this).execute(uid,uname,a,b);
	}
	
	private ListView.OnItemClickListener lstPreferListener=
	    	new ListView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
			 int position, long id) {
				//new mtest(this).execute(data1,username);
				//Intent intent=new Intent();
				//intent.setClass(mbuyinf2.this,mview3.class);
				//Bundle bundle=new Bundle();
				//bundle.putString("uid",data1);
		    	//bundle.putString("uname",username);
		    	//bundle.putString("name",now[position]);
				//intent.putExtras(bundle);
				//startActivity(intent);
				gomview(name[position],thing[position],now[position],goal[position]);
			}
	    };

	
	public double Distance(double longitude1, double latitude1, double longitude2,double latitude2) 
		{
		   double radLatitude1 = latitude1 * Math.PI / 180;
		   double radLatitude2 = latitude2 * Math.PI / 180;
		   double l = radLatitude1 - radLatitude2;
		   double p = longitude1 * Math.PI / 180 - longitude2 * Math.PI / 180;
		   double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(l / 2), 2)
		                    + Math.cos(radLatitude1) * Math.cos(radLatitude2)
		                    * Math.pow(Math.sin(p / 2), 2)));
		   distance = distance * 6378137.0;
		   distance = Math.round(distance * 10000) / 10000;

		   return distance ;
	}
		
	private String DistanceText(double distance){
		   if(distance < 1000 ) return String.valueOf((int)distance) + "m" ;
		   else return new DecimalFormat("#.00").format(distance/1000) + "km" ;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}