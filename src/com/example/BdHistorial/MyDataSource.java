

package com.example.BdHistorial;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.BdHistorial.MyContract.Cintas;
import com.example.MovieBD.Movie;





public class MyDataSource {

	private MyDbHelper dbHelper;
	private SQLiteDatabase db;
	
	private String[] allColumns = {		//ARREGLO
		    Cintas._ID,
		    Cintas.COLUMN_NAME_FIRST_NAME,
		    Cintas.COLUMN_NAME_LAST_NAME,
		    Cintas.COLUMN_NAME_EMAIL,
		    Cintas.COLUMN_NAME_USER
		    };

	public MyDataSource(Context context) {
		this.dbHelper = new MyDbHelper(context);
	}
	
	public void open() throws SQLException {
		this.db = dbHelper.getWritableDatabase();		//entrega la base de dato como escritura
	}
	
	public void close() {
		dbHelper.close();
	}

	public Movie createMovie(String firstName, String lastName, String email, String user) {
		ContentValues values = new ContentValues();
		values.put(Cintas.COLUMN_NAME_FIRST_NAME, firstName);
		values.put(Cintas.COLUMN_NAME_LAST_NAME, lastName);
		values.put(Cintas.COLUMN_NAME_EMAIL, email);
		values.put(Cintas.COLUMN_NAME_USER, user);
		
	    long insertId = db.insert(Cintas.TABLE_NAME, null, values);		//Inserta el objeto en la BD
	    
	    Cursor c = db.query(											//Hago un Query
	    		Cintas.TABLE_NAME,										//Selecciono una columna y hago un WHERE
	    		this.allColumns, 
	    		Cintas._ID + " = " + insertId, 
	    		null,
	    		null, 
	    		null, 
	    		null,
	    		null
	    	);
	    c.moveToFirst();
	    
	    Movie m = cursorToMovie(c);
	    c.close();
	    
	    return m;
	}
	
	public Movie updateMovie(Movie m, String firstName, String lastName, String email, String user) {		//Actualizar
		ContentValues values = new ContentValues();
		values.put(Cintas.COLUMN_NAME_FIRST_NAME, firstName);
		values.put(Cintas.COLUMN_NAME_LAST_NAME, lastName);
		values.put(Cintas.COLUMN_NAME_EMAIL, email);
		values.put(Cintas.COLUMN_NAME_USER, user);
		
	    db.update(Cintas.TABLE_NAME, values, Cintas._ID + " = " + m.getId(), null);
	    
	    m.setFirstName(firstName);
	    m.setLastName(lastName);
	    m.setEmail(email);
	    m.setUser(user);
	    
	    return m;
	}
	
	public List<Movie> getCintas() {								//Muestra la lista las personas 
	    List<Movie> cintas = new ArrayList<Movie>();
	    
	  // String sortOrder = People.COLUMN_NAME_FIRST_NAME + " DESC";
	    
	    Cursor c = db.query(
	    		Cintas.TABLE_NAME,	// The table to query
			    this.allColumns,			// The columns to return
			    null,				// The columns for the WHERE clause
			    null,				// The values for the WHERE clause
			    null,				// don't group the rows
			    null,				// don't filter by row groups
			    null,
			    null
			    // sortOrder			// The sort order
		    );

	    c.moveToFirst();
	    while (!c.isAfterLast()) {
	      Movie m = cursorToMovie(c);
	      cintas.add(m);
	      c.moveToNext();
	    }
	    
	    // make sure to close the cursor
	    c.close();
	    
	    return cintas;
	}
	
	public Movie deleteMovie(Movie m) {				//Borrar una persona
	    long id = m.getId();
	    db.delete(Cintas.TABLE_NAME, Cintas._ID + " = " + id, null);
	    m.setId(0);
	    return m;
	}

	
	private Movie cursorToMovie(Cursor cursor) {		//llama la posicion de los arreglos
		Movie m = new Movie();
	    m.setId(cursor.getLong(0));
	    m.setFirstName(cursor.getString(1));
	    m.setLastName(cursor.getString(2));
	    m.setEmail(cursor.getString(3));
	    m.setUser(cursor.getString(4));
	    return m;
	}
}