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

public class SigninActivity extends AsyncTask<String,Void,String>{
		private Context context;
		private String username,password;
		public SigninActivity(Context context) {
			this.context = context;
		}
		protected void onPreExecute(){
		}
		@Override
		protected String doInBackground(String... arg0) { 
			
			try{
				username = (String)arg0[0];
				password = (String)arg0[1];
				String link="http://120.105.129.75/shop/android_login.php";
				String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");
			    data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
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
				Toast.makeText(context,"登入失敗",Toast.LENGTH_LONG).show();
			}
			else{	
				Toast.makeText(context,"登入成功",Toast.LENGTH_LONG).show();
				
				String[] AfterSplit = result.split(",");
				Bundle bundle = new Bundle();  
		    	bundle.putString("id",AfterSplit[0]);
		    	bundle.putString("name",AfterSplit[1]);
		    	Intent center2=new Intent();
		    	center2.putExtras(bundle);
		    	center2.setClass(context,personal.class);
		    	((Activity)context).finish();
		    	context.startActivity(center2);
			}
		}
}
