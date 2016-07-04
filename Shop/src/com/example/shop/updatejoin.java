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

public class updatejoin extends AsyncTask<String,Void,String>{
		private Context context;
		public updatejoin(Context context) { 
			this.context = context;
		}
		protected void onPreExecute(){
		}
		@Override
		protected String doInBackground(String... arg0) {
			try{
				String name = (String)arg0[0];
				String thing = (String)arg0[1];
				String location = (String)arg0[2];
				String goal = (String)arg0[3];
				String now = (String)arg0[4];
				String deadline = (String)arg0[5];
				String telephone= (String)arg0[6];
				String longitude= (String)arg0[7];
				String latitude= (String)arg0[8];
				String link="http://120.105.129.75/shop/updatejoin.php";
				String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
			    data += "&" + URLEncoder.encode("thing", "UTF-8") + "=" + URLEncoder.encode(thing, "UTF-8");
			    data += "&" + URLEncoder.encode("location", "UTF-8") + "=" + URLEncoder.encode(location, "UTF-8");
			    data += "&" + URLEncoder.encode("goal", "UTF-8") + "=" + URLEncoder.encode(goal, "UTF-8");
			    data += "&" + URLEncoder.encode("now", "UTF-8") + "=" + URLEncoder.encode(now, "UTF-8");
			    data += "&" + URLEncoder.encode("deadline", "UTF-8") + "=" + URLEncoder.encode(deadline, "UTF-8");
			    data += "&" + URLEncoder.encode("telephone", "UTF-8") + "=" + URLEncoder.encode(telephone, "UTF-8");
			    data += "&" + URLEncoder.encode("longitude", "UTF-8") + "=" + URLEncoder.encode(longitude, "UTF-8");
			    data += "&" + URLEncoder.encode("latitude", "UTF-8") + "=" + URLEncoder.encode(latitude, "UTF-8");
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
		        //return new String("true");
		     }catch(Exception e){
		        return new String("Exception: " + e.getMessage());
		     }		
		}
		@Override	
		protected void onPostExecute(String result){	
			//Toast.makeText(context,result,Toast.LENGTH_LONG).show();
			if(result.equals("")){
				Toast.makeText(context,"����",Toast.LENGTH_LONG).show();
			}
			else{	
				Toast.makeText(context,"���\",Toast.LENGTH_LONG).show();
			}
		}
}