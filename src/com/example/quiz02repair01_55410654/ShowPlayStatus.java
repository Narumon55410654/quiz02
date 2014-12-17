package com.example.quiz02repair01_55410654;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ShowPlayStatus extends Activity{

	private ListView ListView;
	@Override
		protected void onCreate(Bundle savedInstanceState) {		
			super.onCreate(savedInstanceState);
			setContentView(R.layout.show);
			ListView = (ListView) findViewById(R.id.listView2_654);
			control654DB control654db = new control654DB(this);
			ArrayList<HashMap<String, String>> MyArrayList = control654db.SelectPlayStatus();
			SimpleAdapter adapter;
			adapter = new SimpleAdapter(ShowPlayStatus.this, MyArrayList, R.layout.itemplaystatus, new String[]{"Play","Player","Random", "Position","Status","Score"},new int[]{R.id.ColPlay_654,R.id.ColUseridp_654,R.id.ColRandom_654, R.id.ColPositionp_654,R.id.ColStatus_654,R.id.ColScorep_654});
			ListView.setAdapter(adapter);
			
		}
}