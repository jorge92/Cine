package com.example.cine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.example.BD.PeliculaDbAdapter;
import com.example.cine.MainActivity.PreferencesHelper;

public class AplicationActivity extends Activity {

	   private PeliculaDbAdapter dbAdapter;
	    private Cursor cursor;
	 
	   //
	    // Modo del formulario
	    //
	   private int modo ;
	 
	   //
	   // Identificador del registro que se edita cuando la opción es MODIFICAR
	   //
	   private long id ;
	 
	   //
	   // Elementos de la vista
	   //
	   private TextView nombre;
	   private TextView observaciones;
	 
	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_aplication);
	      
	      

			 SharedPreferences sharedPref = getSharedPreferences("app-data",Context.MODE_PRIVATE);
	         String name = sharedPref.getString(PreferencesHelper.NAME_KEY, "");
	         
	         if(name.length() > 0)
	         {
	                 TextView nameTextView = (TextView) this.findViewById(R.id.welcome);
	                 nameTextView.setText("Welcome " + name + "!");
	         }
	 
	      Intent intent = getIntent();
	      Bundle extra = intent.getExtras();
	 
	      if (extra == null) return;
	 
	      //
	      // Obtenemos los elementos de la vista
	      //
	      nombre = (TextView) findViewById(R.id.appTitulo);
	      observaciones = (TextView) findViewById(R.id.observacion);
	 
	      //
	      // Creamos el adaptador
	      //
	      dbAdapter = new PeliculaDbAdapter(this);
	      dbAdapter.abrir();
	 
	      //
	      // Obtenemos el identificador del registro si viene indicado
	      //
	      if (extra.containsKey(PeliculaDbAdapter.C_COLUMNA_ID))
	      {
	         id = extra.getLong(PeliculaDbAdapter.C_COLUMNA_ID);
	         consultar(id);
	      }
	 
	      //
	      // Establecemos el modo del formulario
	      //
	      establecerModo(extra.getInt(ElegirActivity.C_MODO));
	 
	   }
	 
	   private void establecerModo(int m)
	   {
	      this.modo = m ;
	 
	      if (modo == ElegirActivity.C_VISUALIZAR)
	      {
	         this.setTitle(nombre.getText().toString());
	         this.setEdicion(false);
	      }
	   }
	 
	   private void consultar(long id)
	   {
	      //
	      // Consultamos el centro por el identificador
	      //
	      cursor = dbAdapter.getRegistro(id);
	 
	      nombre.setText(cursor.getString(cursor.getColumnIndex(PeliculaDbAdapter.C_COLUMNA_NOMBRE)));
	      observaciones.setText(cursor.getString(cursor.getColumnIndex(PeliculaDbAdapter.C_COLUMNA_OBSERVACIONES)));
	   }
	 
	   private void setEdicion(boolean opcion)
	   {
	      nombre.setEnabled(opcion);
	      observaciones.setEnabled(opcion);
	   }
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.aplication, menu);
		return true;
	}
	
	 public void onProfileButtonClicked(View view) {
         Intent register = new Intent(this, RegisterActivity.class);
         this.startActivity(register);
 }
 
 public void onLogoutButtonClicked(View view) {
         
         SharedPreferences sharedPref = getSharedPreferences("app-data",Context.MODE_PRIVATE);
         SharedPreferences.Editor editor = sharedPref.edit();
         editor.putBoolean(PreferencesHelper.IS_LOGGED_IN_KEY, false);
         editor.commit();
         
         Intent login = new Intent(this, LoginActivity.class);
         this.startActivity(login);
 }
 
 public void onChangePelicula(View view) {
     Intent elegir = new Intent(this, ElegirActivity.class);
     this.startActivity(elegir);
}

}
 
   //---------------------SEGUNDO ACTIVITY PARA LA BASE DE DATOS-----------------------//
 

