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

public class mbuy extends AsyncTask<String,Void,String>{
		private Context context;
		private String id,uname;
		public mbuy(Context context) {
			this.context = context;
		}
		protected void onPreExecute(){
		}
		@Override
		protected String doInBackground(String... arg0) {
			
			try{
				id = (String)arg0[0];
				uname = (String)arg0[1];
				String link="http://120.105.129.75/shop/test6.php";
				String data = URLEncoder.encode("uname", "UTF-8") + "=" + URLEncoder.encode(uname, "UTF-8");
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
				bundle.putString("id",id);
		    	bundle.putString("uname",uname);
		    	bundle.putString("name",AfterSplit[0]);
		    	bundle.putString("many",AfterSplit[1]);
		    	bundle.putString("prize",AfterSplit[2]);
		    	bundle.putString("location",AfterSplit[3]);
		    	Intent center2=new Intent();
		    	center2.putExtras(bundle);
		    	center2.setClass(context,mbuyinf.class);
		    	((Activity)context).finish();
		    	context.startActivity(center2);
			}
		}
}