package trumplab.teacherapp;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.LinearLayout;



	public class TimetableSetup  extends ActionBarActivity implements ActionBar.TabListener {
		private ActionBar actionBar;
		private int rollnums=20;
		private int index=0;
		// Tab titles
		private String[] tabs;
		private int[] attendance=new int[rollnums];
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		rollnumstring();
		setContentView(R.layout.timetablesetup);
		
		//Action bar description
		actionBar = getSupportActionBar();
		actionBar.setTitle("Attendance");
		actionBar.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.parrotgreen)));		
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.contact_font_color)));  			

		// Adding Tabs
		for (String tab_name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));
		}
		 LinearLayout presentview= (LinearLayout) findViewById(R.id.presentclick);
		 LinearLayout absentview= (LinearLayout) findViewById(R.id.absentclick);
		 presentview.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					attendance[index]=1;
					if(index<rollnums){ 
						index=index+1;
						actionBar.setSelectedNavigationItem(index);
					}
				}
			});
		   absentview.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(index<rollnums){
						index=index+1;
						actionBar.setSelectedNavigationItem(index);
					}
					
				}
			});

		}
		
		@Override
		public void onTabReselected(Tab arg0,
				android.support.v4.app.FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			index=arg0.getPosition();
		}

		@Override
		public void onTabSelected(Tab arg0,
				android.support.v4.app.FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			index=arg0.getPosition();
		}

		@Override
		public void onTabUnselected(Tab arg0,
				android.support.v4.app.FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}
		
		private void rollnumstring(){
			tabs=new String[rollnums];
			for(int i=1; i<=rollnums; i++){
			tabs[i-1]=Integer.toString(i);
			}
		}

	}
