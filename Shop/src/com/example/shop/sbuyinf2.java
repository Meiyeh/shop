package com.example.shop;
import java.util.concurrent.ExecutionException;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class sbuyinf2 extends Activity {
	private TextView t1,t2;
	private String data1,username,s1,s2,s3,s4;
	private ListView lstPrefer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sbuyinf2);
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
		intent.setClass(sbuyinf2.this,personal.class);
		Bundle bundle=new Bundle();
		bundle.putString("id", data1);
		bundle.putString("name", username);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	public void UpdateAdapter(){
        try {
            String applylist = new AutoUpdateActivity().execute(username).get();
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
                    List[i] = x+".商品:"+temp[0] +"數量:"+ temp[1]+"價格:"+ temp[2]+"取貨地點:"+ temp[3];
                    //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.mylayout,R.id.item,List);
                    ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                    		this,android.R.layout.simple_list_item_1,List);
                    lstPrefer.setAdapter(adapter);
                    //lstPrefer.setOnItemClickListener(lstPreferListener);
                }
            }
            //Toast.makeText(SchedualActivity.this, AfterSplit[1], Toast.LENGTH_LONG).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}