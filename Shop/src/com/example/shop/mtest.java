package com.example.shop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

public class mtest extends AsyncTask<String,Void,String>{
		private Context context;
		private String uid,uname,name,many,money,location;
		public mtest(Context context) {
			this.context = context;
		}
		protected void onPreExecute(){
		}
		@Override
		protected String doInBackground(String... arg0) {
			
			try{
				uid = (String)arg0[0];
				uname = (String)arg0[1];
				name = (String)arg0[2];
				many = (String)arg0[3];
				money = (String)arg0[4];
				location = (String)arg0[5];
				String link="http://10.0.2.2/shop/test7.php";
				String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
				URL url = new URL(link);
				URLConnection conn = url.openConnection(); 
		        conn.setDoOutput(true); 
		        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream()); 
		        wr.write(data); 
		        wr.flush(); 
		        BufferedReader reader = new BufferedReader(new  InputStreamReader(conn.getInputStream()));
		        StringBuilder sb = new StringBuilder();	        
		        String line = null;
		        while((line = reader.readLine()) != null){
		           sb.append(line);
		           break;
		        }
		        return sb.toString();
		     }catch(Exception e){
		        return new String("Exception: " + e.getMessage());
		     }
		}
		@Override	
		protected void onPostExecute(String result){
			if(result.equals("")){
				//Toast.makeText(context,"登入失敗",Toast.LENGTH_LONG).show();
			}
			else{	
				//Toast.makeText(context,"登入成功",Toast.LENGTH_LONG).show();	
				String[] AfterSplit = result.split(",");
				Bundle bundle = new Bundle();
				bundle.putString("uid",uid);
		    	bundle.putString("uname",uname);
		    	bundle.putString("name",name);
		    	bundle.putString("many",many);
		    	bundle.putString("money",money);
		    	bundle.putString("location",location);
		    	bundle.putString("goal",AfterSplit[0]);
		    	bundle.putString("now",AfterSplit[1]);
		    	bundle.putString("dead",AfterSplit[2]);
		    	Intent center2=new Intent();
		    	center2.putExtras(bundle);
		    	center2.setClass(context,mview2.class);
		    	((Activity)context).finish();
		    	context.startActivity(center2);
			}
		}
}