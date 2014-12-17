package com.example.quiz02repair01_55410654;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMemder extends Activity implements OnClickListener {

	private EditText e5, e6;

	private Button add, close;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addmember);
		add = (Button) findViewById(R.id.btnaddmember_654);
		close = (Button) findViewById(R.id.btnclose_654);
		close.setOnClickListener(this);
		add.setOnClickListener(this);
	}

	private boolean add() {
		e5 = (EditText) findViewById(R.id.e5_654);
		e6 = (EditText) findViewById(R.id.e6_654);
		final AlertDialog.Builder adb = new AlertDialog.Builder(this);
		AlertDialog ad = adb.create();
		if (e5.getText().length() == 0) {
			ad.setMessage("Please input Username");
			e5.requestFocus();
			return false;
		}

		if (e6.getText().length() == 0) {
			ad.setMessage("Please input Password");
			e6.requestFocus();
			return false;
		}
		control654DB dbclass = new control654DB(this);
		String getUserid = dbclass.checkId(e5.getText().toString());
		if (getUserid.equalsIgnoreCase("")) {
			long savedata = dbclass.InsertDataMember(e5.getText().toString(),
					e6.getText().toString());
			if (savedata <= 0) {
				ad.setMessage("Error !!!");
				ad.show();
				return false;
			}
			Toast.makeText(getApplicationContext(), "Add Data Successfully",
					Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(getApplicationContext(), "Username has already",
					Toast.LENGTH_SHORT).show();
		}
		return true;

	}

	@Override
	public void onClick(View v) {
		if (v == add) {
			add();
		} else if (v == close) {
			finish();
		}

	}

}

