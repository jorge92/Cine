package com.example.BdHistorial;

import android.provider.BaseColumns;

public final class MyContract {

	public MyContract() {		//coleccion de clases publicas abstractas constantes
		
		// this empty constructor prevent accidentally instantiating the contract class
	}
	
	public static abstract class Cintas implements BaseColumns {		//genera automaticamente los 'id'
		public static final String TABLE_NAME = "cintas";
		public static final String COLUMN_NAME_FIRST_NAME = "first_name";
		public static final String COLUMN_NAME_LAST_NAME = "last_name";
		public static final String COLUMN_NAME_EMAIL = "email";
		public static final String COLUMN_NAME_USER = "user";
	}
}
