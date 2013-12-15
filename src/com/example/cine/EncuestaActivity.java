package com.example.cine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;



public class EncuestaActivity extends Activity {
	
	
	
	public final static String RADIOBUTTON01_VALUE ="com.example.cine.RADIOBUTTON01_VALUE";
	public final static String RADIOBUTTON02_VALUE ="com.example.cine.RADIOBUTTON02_VALUE";
	public final static String RADIOBUTTON03_VALUE ="com.example.cine.RADIOBUTTON03_VALUE";
	public final static String NACIONAL_VALUE ="com.example.cine.NACIONAL_VALUE";
	public final static String INTERNACIONAL_VALUE ="com.example.cine.INTERNACIONAL_VALUE";
	public final static String COMENTARIO_VALUE = "com.example.cine.COMENTARIO_VALUE";	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_encuesta);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.encuesta, menu);
		return true;
	}
	
	
	
	
	public void onSubmitForm(View view) {		//esto hará la activacion de nuestro BUTTON
		//para eso "onClick" (se edita en el XML) debe llamarse como
		//el metodo "oneSubmitForm"
Intent intent = new Intent(this, RespuestaEnActivity.class);				


EditText comentarioEditText = (EditText) findViewById(R.id.comentario);
String comentario = comentarioEditText.getText().toString();


RadioButton rbEditText01 = (RadioButton) findViewById(R.id.op1);
Boolean rbEdit01 = rbEditText01.isChecked();


RadioButton rbEditText02 = (RadioButton) findViewById(R.id.op2);
Boolean rbEdit02 = rbEditText02.isChecked();


RadioButton rbEditText03 = (RadioButton) findViewById(R.id.op3);
Boolean rbEdit03 = rbEditText03.isChecked();


RadioButton rbNacional = (RadioButton) findViewById(R.id.nacional);
Boolean rbEditNacional = rbNacional.isChecked();


RadioButton rbInter = (RadioButton) findViewById(R.id.inter);
Boolean rbEditInter = rbInter.isChecked();






SharedPreferences sharedPref = getSharedPreferences("app-data", Context.MODE_PRIVATE);		
SharedPreferences.Editor editor = sharedPref.edit();		

editor.putString(COMENTARIO_VALUE, comentario);	
editor.putBoolean(RADIOBUTTON01_VALUE, rbEdit01);
editor.putBoolean(RADIOBUTTON02_VALUE, rbEdit02);
editor.putBoolean(RADIOBUTTON03_VALUE, rbEdit03);
editor.putBoolean(NACIONAL_VALUE, rbEditNacional);
editor.putBoolean(INTERNACIONAL_VALUE, rbEditInter);




editor.commit();


//getProgress, setProgress para SEEK = Integer


startActivity(intent);
}

	
//-----------------------------------SEGUNDOACTIVITY-----------------//
	

	
	
	
	
	
	
}
