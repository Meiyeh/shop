package com.example.shop;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class login extends Activity {
	private EditText user,pass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		user = (EditText)findViewById(R.id.editText1);
		pass = (EditText)findViewById(R.id.editText2);
	}
	public void login2(View view){
		String username = user.getText().toString();
		String password = pass.getText().toString();
		new SigninActivity(this).execute(username,password);
	}
	public void createAccount(View view){
		Uri uri=Uri.parse("http://120.105.129.75/shop/member_join_form.php");
		Intent intent=new Intent(Intent.ACTION_VIEW,uri);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}