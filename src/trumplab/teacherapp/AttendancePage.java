package trumplab.teacherapp;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;


	public class AttendancePage  extends ActionBarActivity implements ActionBar.TabListener {
		private ActionBar actionBar;
		private int rollnums=20;
		private int index=0;
		//private static String SAVED_INDEX;
		// Tab titles
		private String[] tabs;
		private int[] attendance;
		//private static String SAVED_ATTEN;
		
		LinearLayout l1;
		LinearLayout presentview;
		LinearLayout absentview;
		TextView prestxt;
		TextView linegapview;
		TextView abstxt;
		GradientDrawable greencircle;
		GradientDrawable redcircle;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
		Log.d("LIFECYCLE","onCreate was called");
		super.onCreate(savedInstanceState);
		/*
		if (savedInstanceState != null) {
			  //System.out.println(index);
		      index=savedInstanceState.getInt(SAVED_INDEX);
		      for(int i=1; i<=rollnums; i++){
			  attendance[i-1]=savedInstanceState.getIntArray(SAVED_ATTEN)[i-1];
			  }
		      
		}
		*/
		rollnumstring();
		setContentView(R.layout.attendance_layout);
		
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
		 presentview= (LinearLayout) findViewById(R.id.presentclick);
		 absentview= (LinearLayout) findViewById(R.id.absentclick);
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
					attendance[index]=0;
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
			Log.d("LIFECYCLE","Tab selected="+arg0.getPosition());
			index=arg0.getPosition();
			prestxt=(TextView) findViewById(R.id.presenttxt);
			abstxt=(TextView) findViewById(R.id.absenttxt);
			greencircle=(GradientDrawable)prestxt.getBackground();
			redcircle=(GradientDrawable)abstxt.getBackground();
			if(attendance[index]==1){
				prestxt.setTextColor(Color.BLACK);
				abstxt.setTextColor(Color.parseColor("#b4b4b4"));
				greencircle.setColor(getResources().getColor(R.color.green));
				redcircle.setColor(Color.TRANSPARENT);
			}
			else if(attendance[index]==0){
				prestxt.setTextColor(Color.parseColor("#b4b4b4"));		
				abstxt.setTextColor(Color.BLACK);
				greencircle.setColor(Color.TRANSPARENT);
				redcircle.setColor(getResources().getColor(R.color.brickred));
			}
			else{
				prestxt.setTextColor(Color.parseColor("#b4b4b4"));		
				abstxt.setTextColor(Color.parseColor("#b4b4b4"));
				greencircle.setColor(Color.TRANSPARENT);
				redcircle.setColor(Color.TRANSPARENT);
			}
		}

		@Override
		public void onTabUnselected(Tab arg0,
				android.support.v4.app.FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}
		
		private void rollnumstring(){
			attendance=new int[rollnums];
			tabs=new String[rollnums];
			for(int i=1; i<=rollnums; i++){
			attendance[i-1]=-1;
			tabs[i-1]=Integer.toString(i);
			}
		}
	
		@Override
		public void onConfigurationChanged(Configuration newConfig) {
			// TODO Auto-generated method stub
			Log.d("LIFECYCLE","onConfigurationChanged was called");
			super.onConfigurationChanged(newConfig);
			 l1= (LinearLayout) findViewById(R.id.LinearLayout);
			 linegapview= (TextView) findViewById(R.id.linegap);
			if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
			    	l1.setOrientation(LinearLayout.VERTICAL);
			    	linegapview.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,3));
			    } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
			    	l1.setOrientation(LinearLayout.HORIZONTAL);
				    linegapview.setLayoutParams(new LinearLayout.LayoutParams(3,LayoutParams.MATCH_PARENT));
			    }	
		}
		
		/*
		@Override
		protected void onSaveInstanceState (Bundle outState) {
			Log.d("LIFECYCLE","onSaveInstanceState was called");
		    super.onSaveInstanceState(outState);
		    outState.putInt(SAVED_INDEX,index);
		    outState.putIntArray(SAVED_ATTEN,attendance);
		}
		
		@Override
	    protected void onRestoreInstanceState(Bundle savedInstanceState) {
			Log.d("LIFECYCLE","onRestoreInstanceState was called");
	        super.onRestoreInstanceState(savedInstanceState);
	        index=savedInstanceState.getInt(SAVED_INDEX);
		    for(int i=1; i<=rollnums; i++){
			attendance[i-1]=savedInstanceState.getIntArray(SAVED_ATTEN)[i-1];
	    }    
		}
		*/
		
		@Override
		protected void onStart() {
			// TODO Auto-generated method stub
			Log.d("LIFECYCLE","onStart was called");
			super.onStart();
		}
		
		@Override
		protected void onResume() {
			// TODO Auto-generated method stub
			Log.d("LIFECYCLE","onResume was called");
			super.onResume();
		}
		
		@Override
		protected void onRestart() {
			// TODO Auto-generated method stub
			Log.d("LIFECYCLE","onRestart was called");
			super.onRestart();
		}
		
		@Override
		protected void onPause() {
			// TODO Auto-generated method stub
			Log.d("LIFECYCLE","onPause was called");
			super.onPause();
		}
		
		@Override
		protected void onStop() {
			// TODO Auto-generated method stub
			Log.d("LIFECYCLE","onStop was called");
			super.onStop();
		}
		
		@Override
		protected void onDestroy() {
			// TODO Auto-generated method stub
			Log.d("LIFECYCLE","onDestroy was called");
			super.onDestroy();
		}
		
	}
