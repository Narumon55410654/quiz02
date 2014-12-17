package com.example.quiz02repair01_55410654;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private Button btnLogin, btnregister;
	private EditText e1, e2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		control654DB control654db = new control654DB(this);
		control654db.getWritableDatabase();

		btnLogin = (Button) findViewById(R.id.btn1_654);
		btnregister = (Button) findViewById(R.id.btnnewmember_654);
		e1 = (EditText) findViewById(R.id.e1_654);
		e2 = (EditText) findViewById(R.id.e2_654);
		btnregister.setOnClickListener(this);
		btnLogin.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn1_654:
			control654DB db = new control654DB(this);
			db.getWritableDatabase();
			String getPassword = db.checkLogin(e1.getText().toString());
			String getPosition = db.checkPosition(e1.getText().toString());
			db.close();
			if (getPassword.equalsIgnoreCase(e2.getText().toString())) {
				if (getPosition.equalsIgnoreCase("admin")) {
					String getUserid = db.checkId(e1.getText().toString());
					Toast.makeText(getApplicationContext(), "Success!",
							Toast.LENGTH_LONG).show();
					Intent i = new Intent(getApplicationContext(),
							AddAdmin.class);
					i.putExtra("Userid", getUserid);
					startActivity(i);
				} else if (getPosition.equalsIgnoreCase("member")) {
					String getUserid = db.checkId(e1.getText().toString());
					Toast.makeText(getApplicationContext(), "Success!",
							Toast.LENGTH_LONG).show();
					Intent j = new Intent(getApplicationContext(), play.class);
					j.putExtra("Userid", getUserid);
					startActivity(j);
				}
			} else
				Toast.makeText(getApplicationContext(), "Error!",
						Toast.LENGTH_LONG).show();

			break;
		case R.id.btnnewmember_654:
			Intent j = new Intent(getApplicationContext(), AddMemder.class);
			startActivity(j);
			
			break;
		default:
			break;
		}
	}
}