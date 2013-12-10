package com.example.cine;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import com.example.BD.PeliculaCursorAdapter;
import com.example.BD.PeliculaDbAdapter;
 
public class ElegirActivity extends ListActivity {
 
   public static final String C_MODO  = "modo" ;
   public static final int C_VISUALIZAR = 551 ;
 
   private PeliculaDbAdapter dbAdapter;
    private Cursor cursor;
    private PeliculaCursorAdapter peliculaAdapter ;
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
   
   
 //borrar esto si no compila
   @SuppressWarnings("deprecation") //hasta aqui
   
   
private void consultar()
   {
      cursor = dbAdapter.getCursor();
      startManagingCursor(cursor);
      peliculaAdapter = new PeliculaCursorAdapter(this, cursor);
      lista.setAdapter(peliculaAdapter);
   }
 
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.elegir, menu);
      return true;
   }
 
   private void visualizar(long id)
   {
      // Llamamos a la Actividad PeliculaFormulario indicando el modo visualización y el identificador del registro
      Intent i = new Intent(ElegirActivity.this, AplicationActivity.class);
      i.putExtra(C_MODO, C_VISUALIZAR);
      i.putExtra(PeliculaDbAdapter.C_COLUMNA_ID, id);
 
      startActivityForResult(i, C_VISUALIZAR);
   }
 
   @Override
   protected void onListItemClick(ListView l, View v, int position, long id)
   {
      super.onListItemClick(l, v, position, id);
 
      visualizar(id);
   }
} 