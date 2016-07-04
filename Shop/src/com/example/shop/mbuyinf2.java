package com.example.shop;
import java.util.concurrent.ExecutionException;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class mbuyinf2 extends Activity {
	private TextView t1,t2;
	private String data1,username,s1,s2,s3,s4;
	private ListView lstPrefer;
	String[] name = new String[20];
	String[] many = new String[20];
	String[] money = new String[20];
	String[] location = new String[20];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mbuyinf2);
		t1=(TextView) findViewById(R.id.textView1);
		lstPrefer=(ListView) findViewById(R.id.listView1);
		Intent a = this.getIntent();
		Bundle b = a.getExtras();
		data1=(b.getString("id"));
		username=(b.getString("uname"));
		UpdateAdapter();
	}
	public void topersonal(View view){
		Intent intent=new Intent();
		intent.setClass(mbuyinf2.this,personal.class);
		Bundle bundle=new Bundle();
		bundle.putString("id", data1);
		bundle.putString("name", username);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	public void gomview(String a,String b,String c,String d){
		new mtest2(this).execute(data1,username,a,b,c,d);
	}
	
	public void UpdateAdapter(){
        try {
            String applylist = new AutoUpdateActivity2().execute(username).get();
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
                String[] List = new String[AfterSplit.length];
                for (int i=0; i<AfterSplit.length; i++){
                    String[] temp = AfterSplit[i].split("!");
                    String x=Integer.toString(i+1);
                    List[i] = x+".�ӫ~:"+temp[0] +"�ƶq:"+ temp[1]+"����:"+ temp[2]+"���f�a�I:"+ temp[3];
                    name[i]=temp[0];
                    many[i]=temp[1];
                    money[i]=temp[2];
                    location[i]=temp[3];
                    //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.mylayout,R.id.item,List);
                    ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                    		this,android.R.layout.simple_list_item_1,List);
                    lstPrefer.setAdapter(adapter);
                    lstPrefer.setOnItemClickListener(lstPreferListener);
                }
            }
            //Toast.makeText(SchedualActivity.this, AfterSplit[1], Toast.LENGTH_LONG).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
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
				gomview(name[position],many[position],money[position],location[position]);
			}
	    };

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}