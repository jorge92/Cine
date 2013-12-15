package com.example.Historial;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.BdHistorial.MyDataSource;
import com.example.Listener.ListViewItemClickListener;
import com.example.MovieBD.Movie;
import com.example.cine.EncuestaActivity;
import com.example.cine.R;

public class HistorialMainActivity extends ListActivity {

	public static final int REQUEST_CODE_ADD_MOVIE = 1;
	public static final int REQUEST_CODE_UPDATE_MOVIE = 2;
	
	public static final String EXTRA_MOVIE = "movie";
	public static final String EXTRA_REMOVE = "remove";

	private MyDataSource ds;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_historial_main);
		
		ds = new MyDataSource(this);
	    ds.open();
	    
	    List<Movie> values = ds.getCintas();		//llama la Query y envia una lista de personas
	    
	    // use the SimpleCursorAdapter to show the elements in a ListView
	    ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(
	    		this,
	    		android.R.layout.simple_list_item_1, 
	    		values
	    	);
	    
	    this.setListAdapter(adapter);
	    
	    ListView lv = (ListView) this.findViewById(android.R.id.list);
	    lv.setOnItemClickListener(new ListViewItemClickListener(this));		//
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if(data.hasExtra(EXTRA_MOVIE))
		{
			List<Movie> values = ds.getCintas();
		    
		    // use the SimpleCursorAdapter to show the elements in a ListView
		    ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(
		    		this,
		    		android.R.layout.simple_list_item_1, 
		    		values
		    	);
		    
		    ListView lv = (ListView) this.findViewById(android.R.id.list);
		    lv.setAdapter(adapter);
		    
			if(requestCode == REQUEST_CODE_ADD_MOVIE) {
				// do something here when a person is added
			}
			else if(requestCode == REQUEST_CODE_UPDATE_MOVIE)
			{
				Boolean remove = data.getBooleanExtra(EXTRA_REMOVE, false);
				
				if(remove) {
					// do something here when a pelicula is removed
				}
				else {
					// do something here when a pelicula is updated
				}
			}
			adapter.notifyDataSetChanged();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.historial_main, menu);
		return true;
	}
	
	public void onAddButtonClicked(View view) {
		Intent i = new Intent(this, HistorialActivity.class);
		this.startActivityForResult(i, REQUEST_CODE_ADD_MOVIE);
	}
	
	 public void onEncuesta(View view) {
	     Intent encuesta = new Intent(this, EncuestaActivity.class);
	     this.startActivity(encuesta);
	}

}
