package com.example.BD;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;



public class PeliculaDbAdapter {
	
	 /**
	    * Definimos constante con el nombre de la tabla
	    */
	   public static final String C_TABLA = "PELICULA" ;
	 
	   /**
	    * Definimos constantes con el nombre de las columnas de la tabla
	    */
	   public static final String C_COLUMNA_ID   = "_id";
	   public static final String C_COLUMNA_NOMBRE = "peli_nombre";
	   public static final String C_COLUMNA_SALA = "peli_sala";
	   public static final String C_COLUMNA_HORARIO = "peli_horario";
	   public static final String C_COLUMNA_FORMATO = "peli_formato";
	   public static final String C_COLUMNA_OBSERVACIONES = "peli_observaciones";
	 
	   private Context contexto;
	   private PeliculaDbHelper dbHelper;
	   private SQLiteDatabase db;
	 
	   /**
	    * Definimos lista de columnas de la tabla para utilizarla en las consultas a la base de datos
	    */
	   private String[] columnas = new String[]{ C_COLUMNA_ID, C_COLUMNA_NOMBRE, C_COLUMNA_SALA, C_COLUMNA_HORARIO, C_COLUMNA_FORMATO, C_COLUMNA_OBSERVACIONES} ;
	 
	   public PeliculaDbAdapter(Context context)
	   {
	      this.contexto = context;
	   }
	 
	   public PeliculaDbAdapter abrir() throws SQLException
	   {
	      dbHelper = new PeliculaDbHelper(contexto);
	      db = dbHelper.getWritableDatabase();
	      return this;
	   }
	 
	   public void cerrar()
	   {
	      dbHelper.close();
	   }
	 
	   /**
	    * Devuelve cursor con todos las columnas de la tabla
	    */
	   public Cursor getCursor() throws SQLException
	   {
	      Cursor c = db.query( true, C_TABLA, columnas, null, null, null, null, null, null);
	 
	      return c;
	   }
	   /**
	    * Devuelve cursor con todos las columnas del registro
	    */
	   public Cursor getRegistro(long id) throws SQLException
	   {
	      Cursor c = db.query( true, C_TABLA, columnas, C_COLUMNA_ID + "=" + id, null, null, null, null, null);
	 
	      //Nos movemos al primer registro de la consulta
	      if (c != null) {
	         c.moveToFirst();
	      }
	      return c;
	   }
	}


