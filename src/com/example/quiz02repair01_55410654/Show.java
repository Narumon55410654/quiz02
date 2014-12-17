package com.example.quiz02repair01_55410654;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Show  extends Activity {
	private ListView ListView;
	@Override
		protected void onCreate(Bundle savedInstanceState) {		
			super.onCreate(savedInstanceState);
			setContentView(R.layout.show);
			ListView = (ListView) findViewById(R.id.listView2_654);
			control654DB control654db = new control654DB(this);
			ArrayList<HashMap<String, String>> MyArrayList = control654db.SelectAllData();
			SimpleAdapter adapter;
			adapter = new SimpleAdapter(Show.this, MyArrayList, R.layout.item, new String[]{"Userid","Username","Password","Position"},new int[]{R.id.ColUserid_654,R.id.ColUsername_654,R.id.ColPassword_654,R.id.ColPosition_654});
			ListView.setAdapter(adapter);
			
		}
	}


