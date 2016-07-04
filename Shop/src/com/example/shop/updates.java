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

public class updates extends AsyncTask<String,Void,String>{
		private Context context;
		public updates(Context context) {
			this.context = context;
		}
		protected void onPreExecute(){
		}
		@Override
		protected String doInBackground(String... arg0) {
			try{
				String uname = (String)arg0[0];
				String name = (String)arg0[1];
				String many = (String)arg0[2];
				String prize = (String)arg0[3];
				String location = (String)arg0[4];
				String link="http://120.105.129.75/shop/test.php";
				String data = URLEncoder.encode("uname", "UTF-8") + "=" + URLEncoder.encode(uname, "UTF-8");
			    data += "&" + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
			    data += "&" + URLEncoder.encode("many", "UTF-8") + "=" + URLEncoder.encode(many, "UTF-8");
			    data += "&" + URLEncoder.encode("prize", "UTF-8") + "=" + URLEncoder.encode(prize, "UTF-8");
			    data += "&" + URLEncoder.encode("location", "UTF-8") + "=" + URLEncoder.encode(location, "UTF-8");
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
				Toast.makeText(context,"下單失敗",Toast.LENGTH_LONG).show();
			}
			else{	
				Toast.makeText(context,"下單成功",Toast.LENGTH_LONG).show();
			}
		}
}