package com.example.cine;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RadioButton;
import android.widget.TextView;

public class RespuestaEnActivity extends Activity {
	
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_respuesta_en);
		
		
SharedPreferences sharedPref = getSharedPreferences("app-data", Context.MODE_PRIVATE);	
		
		String comentario = sharedPref.getString(EncuestaActivity.COMENTARIO_VALUE, "not set");	
		Boolean rbEdit01 = (Boolean) sharedPref.getBoolean(EncuestaActivity.RADIOBUTTON01_VALUE, true);
		Boolean rbEdit02 = (Boolean) sharedPref.getBoolean(EncuestaActivity.RADIOBUTTON02_VALUE, true);
		Boolean rbEdit03 = (Boolean) sharedPref.getBoolean(EncuestaActivity.RADIOBUTTON03_VALUE, true);
		Boolean rbEditNacional = (Boolean) sharedPref.getBoolean(EncuestaActivity.NACIONAL_VALUE, true);
		Boolean rbEditInter = (Boolean) sharedPref.getBoolean(EncuestaActivity.INTERNACIONAL_VALUE, true);
		
		
		
		

		TextView nameTextView = (TextView) findViewById(R.id.respuestaCom);
        nameTextView.setText(comentario);

        
        RadioButton rd01  = (RadioButton) findViewById(R.id.resOp1);
        rd01.setChecked(rbEdit01);
        
   
		RadioButton rd02  = (RadioButton) findViewById(R.id.resOp2);
        rd02.setChecked(rbEdit02);
        

		RadioButton rd03  = (RadioButton) findViewById(R.id.resOp3);
        rd03.setChecked(rbEdit03);
        
 
		RadioButton rdNacional  = (RadioButton) findViewById(R.id.resNacional);
        rdNacional.setChecked(rbEditNacional);
        
   

		RadioButton rdInter  = (RadioButton) findViewById(R.id.resInter);
        rdInter.setChecked(rbEditInter);
        
        
    	
	}



	
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.respuesta_en, menu);
		return true;
	}
	


}
