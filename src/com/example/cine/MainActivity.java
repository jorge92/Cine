package com.example.cine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends Activity {
	
	
	public class PreferencesHelper {

		public final static String IS_REGISTERES_KEY = "com.example.cine.IS_REGISTERES_KEY";
		public final static String IS_LOGGED_IN_KEY = "com.example.cine.IS_LOGGED_IN_KEY";
		
		public final static String NAME_KEY = "com.example.cine.NAME_KEY";
		public final static String EMAIL_KEY = "com.example.cine.EMAIL_KEY";
		public final static String NACION_KEY = "com.example.cine.NACION_KEY";
		public final static String EDAD_KEY = "com.example.cine.EDAD_KEY";
		public final static String PASSWORD_KEY = "com.example.cine.PASSWORD_KEY";
		public final static String RATING_KEY = "com.example.cine.FRECUENCIA_KEY";
	}

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        SharedPreferences sharedPref = getSharedPreferences("app-data",Context.MODE_PRIVATE);
        Boolean isLoggedIn = sharedPref.getBoolean(PreferencesHelper.IS_LOGGED_IN_KEY, false);
        Boolean isRegistered = sharedPref.getBoolean(PreferencesHelper.IS_REGISTERES_KEY, false);
        
        if(!isRegistered)
        {
                Intent register = new Intent(this, RegisterActivity.class);
                this.startActivity(register);
        }
        else if(!isLoggedIn)
        {
                Intent login = new Intent(this, LoginActivity.class);
                this.startActivity(login);
        }
        else
        {
                Intent app = new Intent(this, AplicationActivity.class);
                this.startActivity(app);
        }
    }

 
}