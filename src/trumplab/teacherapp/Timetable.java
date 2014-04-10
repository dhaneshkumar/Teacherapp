package trumplab.teacherapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

	@SuppressLint("ValidFragment")
	public class Timetable extends Fragment {
		
		int index=0;
		public Timetable(int i)
		{
			index=i;
		}
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			View rootView = inflater.inflate(R.layout.timetable, container, false);
			return rootView;
		}
		
		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
		   super.onActivityCreated(savedInstanceState); 
		   LinearLayout l1 = (LinearLayout) getView().findViewById(R.id.LinearLayout);
		   
		 /*
		  * Start your code from here............
		  */
		}
		
	
		
	}
