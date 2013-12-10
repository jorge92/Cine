package com.example.cine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.cine.MainActivity.PreferencesHelper;

public class RegisterActivity extends Activity {
	
	private Boolean isUpdatingProfile = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		SharedPreferences sharedPref = getSharedPreferences("app-data",Context.MODE_PRIVATE);
        Boolean isLoggedIn = sharedPref.getBoolean(PreferencesHelper.IS_LOGGED_IN_KEY, false);
        
        
        if(isLoggedIn)
        {
                String name = sharedPref.getString(PreferencesHelper.NAME_KEY, "");
                String email = sharedPref.getString(PreferencesHelper.EMAIL_KEY, "");
                String nacion = sharedPref.getString(PreferencesHelper.NACION_KEY, "");
                String edad = sharedPref.getString(PreferencesHelper.EDAD_KEY, "");
                String password = sharedPref.getString(PreferencesHelper.PASSWORD_KEY, "");
                Float rating = sharedPref.getFloat(PreferencesHelper.RATING_KEY, 0);
                
                
                
                EditText nameField = (EditText) this.findViewById(R.id.RegisName);
                nameField.setText(name);
                
                EditText emailField = (EditText) this.findViewById(R.id.RegisEmail);
                emailField.setText(email);
                
                EditText nacionField = (EditText) this.findViewById(R.id.RegisNacion);
                nacionField.setText(nacion);
                
                EditText edadField = (EditText) this.findViewById(R.id.RegisEdad);
                edadField.setText(edad);
                
                EditText passwordField = (EditText) this.findViewById(R.id.RegisPass);
                passwordField.setText(password);
                
                EditText passwordConfirmationField = (EditText) this.findViewById(R.id.RegisPassConf);
                passwordConfirmationField.setText(password);
                
                RatingBar ratingField = (RatingBar) this.findViewById(R.id.RegisFrecuencia);
                ratingField.setRating(rating);
                
                Button submitButton = (Button) this.findViewById(R.id.CrearCuenta);
                submitButton.setText("Update");
                
                this.setTitle("Profile");
                
                this.isUpdatingProfile = true;
        }
}
        
        
        
        
        
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}
	
	
	
	public void onRegisterButtonClicked(View view) {
        
        EditText nameField = (EditText) this.findViewById(R.id.RegisName);
        String name = nameField.getText().toString();
        
        EditText emailField = (EditText) this.findViewById(R.id.RegisEmail);
        String email = emailField.getText().toString();
        
        EditText nacionField = (EditText) this.findViewById(R.id.RegisNacion);
        String nacion = nacionField.getText().toString();
        
        EditText edadField = (EditText) this.findViewById(R.id.RegisEdad);
        String edad = edadField.getText().toString();
        
        EditText passField = (EditText) this.findViewById(R.id.RegisPass);
        String pass = passField.getText().toString();
        
        EditText confirmPassField = (EditText) this.findViewById(R.id.RegisPassConf);
        String passConfirmation = confirmPassField.getText().toString();
        
        RatingBar ratingField = (RatingBar) this.findViewById(R.id.RegisFrecuencia);
        Float rating = ratingField.getRating();
        
        if(pass.equals(passConfirmation))
        {
                SharedPreferences sharedPref = getSharedPreferences("app-data",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                                        
                editor.putString(PreferencesHelper.NAME_KEY, name);
                editor.putString(PreferencesHelper.EMAIL_KEY, email);
                editor.putString(PreferencesHelper.NACION_KEY, nacion);
                editor.putString(PreferencesHelper.EDAD_KEY, edad);
                editor.putString(PreferencesHelper.PASSWORD_KEY, pass);
                editor.putFloat(PreferencesHelper.RATING_KEY, rating);
                editor.putBoolean(PreferencesHelper.IS_REGISTERES_KEY, true);
                editor.putBoolean(PreferencesHelper.IS_LOGGED_IN_KEY, false);
                
                editor.commit();
                
                if(this.isUpdatingProfile)
                {
                        this.isUpdatingProfile = false;
                        
                        Toast.makeText(this, "Profile updated!", Toast.LENGTH_LONG).show();
                        
                        Intent app = new Intent(this, ElegirActivity.class);
                        this.startActivity(app);
                }
                else
                {
                        Toast.makeText(this, "Thanks for registering!", Toast.LENGTH_LONG).show();
                        
                        Intent login = new Intent(this, LoginActivity.class);
                        this.startActivity(login);
                }
        }
        else
        {
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_LONG).show();
        }
	}
}


