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

public class invitejoin1 extends AsyncTask<String,Void,String>{
		private Context context;
		String uid,uname;
		public invitejoin1(Context context) { 
			this.context = context;
		}
		protected void onPreExecute(){
		}
		@Override
		protected String doInBackground(String... arg0) {
			try{
				uid = (String)arg0[0];
				uname = (String)arg0[1];
				String name = (String)arg0[2];
				String thing = (String)arg0[3];
				String now = (String)arg0[4];
				String link="http://120.105.129.75/shop/invitejoin1.php";
				String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
			    data += "&" + URLEncoder.encode("thing", "UTF-8") + "=" + URLEncoder.encode(thing, "UTF-8");
			    data += "&" + URLEncoder.encode("now", "UTF-8") + "=" + URLEncoder.encode(now, "UTF-8");
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
				//Toast.makeText(context,"ев▒╤",Toast.LENGTH_LONG).show();
			}
			else{	
				Toast.makeText(context,"жие\",Toast.LENGTH_LONG).show();
				Bundle bundle = new Bundle();  
		    	bundle.putString("id",uid);
		    	bundle.putString("name",uname);
		    	Intent center2=new Intent();
		    	center2.putExtras(bundle);
		    	center2.setClass(context,personal.class);
		    	((Activity)context).finish();
		    	context.startActivity(center2);
			}
		}
}