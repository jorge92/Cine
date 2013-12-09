package com.example.cine;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import com.example.BD.PeliculaCursorAdapter;
import com.example.BD.PeliculaDbAdapter;

public class ElegirActivity extends ListActivity {

	 private PeliculaDbAdapter dbAdapter;
	    private Cursor cursor;
	    private PeliculaCursorAdapter PeliculaAdapter ;
	    private ListView lista;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_elegir);
		
		
		lista = (ListView) findViewById(android.R.id.list);
		 
	      dbAdapter = new PeliculaDbAdapter(this);
	      dbAdapter.abrir();
	 
	      consultar();
	   }
	 
	   @SuppressWarnings("deprecation")
	private void consultar()
	   {
	      cursor = dbAdapter.getCursor();
	      startManagingCursor(cursor);
	      PeliculaAdapter = new PeliculaCursorAdapter(this, cursor);
	      lista.setAdapter(PeliculaAdapter);
	   }
	   
	   
	   
	   //--------------------------------SEGUNDO ACTIVITY----------------------//
	   
	   
	   
	   
	   

}
