package com.example.cine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.example.cine.MainActivity.PreferencesHelper;

public class AplicationActivity extends Activity {

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
