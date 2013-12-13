package com.example.Listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.example.Historial.HistorialActivity;
import com.example.Historial.HistorialMainActivity;
import com.example.MovieBD.Movie;

public class ListViewItemClickListener implements AdapterView.OnItemClickListener {

	private Activity activity;
	
	public ListViewItemClickListener(Activity activity) {
		this.activity = activity;
	}
	
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Movie m = (Movie) parent.getItemAtPosition(position);
		
		if(m != null)
		{
			Intent i = new Intent(this.activity, HistorialActivity.class);
			i.putExtra("movie", m);
			this.activity.startActivityForResult(i, HistorialMainActivity.REQUEST_CODE_UPDATE_MOVIE);			
		}
	}
}
