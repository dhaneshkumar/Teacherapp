package trumplab.teacherapp;

import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;


	public class TimetableSetup  extends ActionBarActivity implements ActionBar.TabListener {
		private ActionBar actionBar;
		private int rollnums=20;
		private int index=0;
		private static String SAVED_INDEX;
		// Tab titles
		private String[] tabs;
		private int[] attendance=new int[rollnums];
		private static String SAVED_ATTEN;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState != null) {
			  //System.out.println(index);
		      index=savedInstanceState.getInt(SAVED_INDEX);
		      for(int i=1; i<=rollnums; i++){
			  attendance[i-1]=savedInstanceState.getIntArray(SAVED_ATTEN)[i-1];
			  }
		      
		}
		rollnumstring();
		setContentView(R.layout.timetablesetup);
		
		//Action bar description
		actionBar = getSupportActionBar();
		actionBar.setTitle("Attendance");
		actionBar.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.contact_font_color)));		
		//actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.contact_font_color)));  			

		// Adding Tabs
		for (String tab_name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		}
		actionBar.setSelectedNavigationItem(index);
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
		
		@Override
		public void onConfigurationChanged(Configuration newConfig) {
			// TODO Auto-generated method stub
			super.onConfigurationChanged(newConfig);
			 LinearLayout l1= (LinearLayout) findViewById(R.id.LinearLayout);
			 TextView linegapview= (TextView) findViewById(R.id.linegap);
			if (getResources().getConfiguration().orientation == newConfig.ORIENTATION_PORTRAIT) {
			    l1.setOrientation(LinearLayout.VERTICAL);
			    linegapview.setLayoutParams(new LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT,3));
			    } else if (getResources().getConfiguration().orientation == newConfig.ORIENTATION_LANDSCAPE) {
			    	l1.setOrientation(LinearLayout.HORIZONTAL);
				    linegapview.setLayoutParams(new LayoutParams(3,android.view.ViewGroup.LayoutParams.MATCH_PARENT));
			    }
			
		}
		
		@Override
		protected void onSaveInstanceState (Bundle outState) {
		    super.onSaveInstanceState(outState);
		    outState.putInt(SAVED_INDEX,index);
		    outState.putIntArray(SAVED_ATTEN,attendance);
		}
		
		@Override
	    protected void onRestoreInstanceState(Bundle savedInstanceState) {
	        super.onRestoreInstanceState(savedInstanceState);
	        index=savedInstanceState.getInt(SAVED_INDEX);
		    for(int i=1; i<=rollnums; i++){
			attendance[i-1]=savedInstanceState.getIntArray(SAVED_ATTEN)[i-1];
	    }
	}
	}
