package com.example.shop;

import java.util.concurrent.ExecutionException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
public class inviteinf extends Activity {
	private TextView t1;
	private String uid,uname;
	private ListView lstPrefer;
	String[] name = new String[20];//發起者
	String[] thing = new String[20];
	String[] location = new String[20];
	String[] goal = new String[20];
	String[] now = new String[20];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inviteinf);
		t1=(TextView)findViewById(R.id.textView1);
		lstPrefer=(ListView) findViewById(R.id.listView1);
		Intent intent1=this.getIntent();
        Bundle bundle=intent1.getExtras();
        uid=(bundle.getString("uid"));
		uname=(bundle.getString("uname"));
		UpdateAdapter();
	}
	public void back(View view){
		Intent intent=new Intent();
		intent.setClass(inviteinf.this,invite.class);
		Bundle bundle=new Bundle();
		bundle.putString("id",uid);//uid
    	bundle.putString("name",uname);//uname
		intent.putExtras(bundle);
		startActivity(intent);
	}
	public void UpdateAdapter(){
        try {
            String applylist = new AutoUpdateActivity3().execute(uname).get();
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
                    List[i] = x+".發起人:"+temp[0] +"事情:"+ temp[1]+"集合位置:"+ temp[2]+"目標人數:"+ temp[3]+"目前人數:"+ temp[4];
                    name[i]=temp[0];
                    thing[i]=temp[1];
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
	
	public void gomview(String a,String b){
		new jointest(this).execute(uid,uname,a,b);
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
				gomview(name[position],thing[position]);
			}
	    };

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}