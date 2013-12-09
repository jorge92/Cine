package com.example.BD;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PeliculaDbHelper extends SQLiteOpenHelper {

	   private static int version = 3;
	   private static String name = "PeliculaDb" ;
	   private static CursorFactory factory = null;
	 
	   public PeliculaDbHelper(Context context)
	   {
	      super(context, name, factory, version);
	   }
	 
	   @Override
	   public void onCreate(SQLiteDatabase db)
	   {
		   Log.i(this.getClass().toString(), "Creando base de datos");
		   
		   db.execSQL( "CREATE TABLE PELICULA(" +
		          " _id INTEGER PRIMARY KEY," +
		          " peli_nombre TEXT NOT NULL, " +
		          " peli_sala TEXT, " +
		          " peli_horario TEXT," +
		          " peli_formato TEXT," +
		          " peli_observaciones TEXT)" );
		 
		   db.execSQL( "CREATE UNIQUE INDEX hip_nombre ON PELICULA(peli_nombre ASC)" );
		 
		   Log.i(this.getClass().toString(), "Tabla PELICULA creada");
		 
		   /*
		    * Insertamos datos iniciales
		    */
		   db.execSQL("INSERT INTO PELICULA(_id, peli_nombre) VALUES(1,'El Conjuro')");
		   db.execSQL("INSERT INTO PELICULA(_id, peli_nombre) VALUES(2,'Thor 2')");
		   db.execSQL("INSERT INTO PELICULA(_id, peli_nombre) VALUES(3,'Ciudadano Kramer')");
		   
		 
		   Log.i(this.getClass().toString(), "Datos iniciales PELICULA insertados");
		 
		   Log.i(this.getClass().toString(), "Base de datos creada");
		   
	   }
	 
	   
	   private static final String SQL_DROP_PELICULA =				//eliminar tabla
			    "DROP TABLE IF EXISTS PELICULA"  ;
	   
	   @Override
	   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	   {
		   Log.w(
	    			PeliculaDbHelper.class.getName(),
	    			"Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data"
	    	);

	    	db.execSQL(SQL_DROP_PELICULA);
	    	onCreate(db);
	    }
	   }
	