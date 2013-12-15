package com.example.BD;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PeliculaDbHelper extends SQLiteOpenHelper {

	   private static int version = 42;
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
		 
		   db.execSQL( "CREATE UNIQUE INDEX peli_nombre ON PELICULA(peli_nombre ASC)" );
		 
		   Log.i(this.getClass().toString(), "Tabla PELICULA creada");
		 
		   /*
		    * Insertamos datos iniciales
		    */
		   db.execSQL("INSERT INTO PELICULA(_id, peli_nombre) VALUES(1,'El Conjuro')");
		   db.execSQL("INSERT INTO PELICULA(_id, peli_nombre) VALUES(2,'Thor 2')");
		   db.execSQL("INSERT INTO PELICULA(_id, peli_nombre) VALUES(3,'Ciudadano Kramer')");
		   db.execSQL("INSERT INTO PELICULA(_id, peli_nombre) VALUES(4,'Carrie')");
		   db.execSQL("INSERT INTO PELICULA(_id, peli_nombre) VALUES(5,'Jobs')");
		   db.execSQL("INSERT INTO PELICULA(_id, peli_nombre) VALUES(6,'Lluvia de Hamburguesas 2')");
	
		   
		   
		   db.execSQL("UPDATE PELICULA SET peli_observaciones = 'Espeluznante, terrorífica, agobiante y opresora… los epítetos se quedan cortos cuando se trata de describir " +
	         		"las sensaciones que se derivan de “El Conjuro” (“The Conjuring”), un filme cuyo efecto se potencia al descubrir que se trata de una historia real; de un caso verídico.'" +
	                     " WHERE _id = 1");
	         
	         db.execSQL("UPDATE PELICULA SET peli_observaciones = 'Thor lucha por restablecer el orden en todo el cosmos. " +
	         		"Pero una antigua raza liderada por el vengativo Malekith regresa para volver a sumir al universo en la oscuridad. " +
	         		"En este viaje se reunirá con Jane Foster y le obligará a sacrificar todo para salvar a los Nueve Reinos.'" +
                    " WHERE _id = 2");
	         
	         db.execSQL("UPDATE PELICULA SET peli_observaciones = 'En ella vemos como el humorista, después de alcanzar su show número mil, " +
		         		"siente la necesidad de renovarse y decide aprovechar el contexto de las elecciones presidenciales en Chile para realizar un nuevo espectáculo. " +
		         		"La publicidad del show, que lo muestra como candidato, genera confusión en la opinión pública'" +
		                     " WHERE _id = 3");
	        
	         db.execSQL("UPDATE PELICULA SET peli_observaciones = 'Carrie es la historia de una introvertida adolescente, Carrie White, quien descubre que posee poderes psíquicos, " +
		         		"los cuales salen a la luz en el momento que ella estalle de ira. Carrie sufre constantes humillaciones por parte de sus compañeros, " +
		         		"lo cual termina en tragedia el día del baile de graduación cuando usa sus poderes en contra de toda su clase.'" +
			                     " WHERE _id = 4");
	         
	         db.execSQL("UPDATE PELICULA SET peli_observaciones = 'Sólo se necesita una persona para empezar una revolución. " +
		         		"La extraordinaria historia de Steve Jobs, innovador y extraordinario empresario al que no se le interpuso nada en el camino a la grandeza. " +
		         		"La película cuenta la épica y turbulenta historia de Jobs mientras abría un camino que cambió la tecnología y el mundo para siempre.'" +
				                     " WHERE _id = 5");
	         
	         db.execSQL("UPDATE PELICULA SET peli_observaciones = 'Flint Lockwood y Sam Sparks descubrirán que a partir de los restos de comida que " +
		         		"indundaron Swallow Falls durante la primera película ha creado una serie de criaturas mutantes tales como tacodrilos, " +
		         		"chimpancés de camarón o arañas de queso con doble tocino, y cuyos nombres surgirán a partir de una serie de juegos de palabras a lo cringeworthy.'" +
					                     " WHERE _id = 6");
	         
	       
	         
	         
	         
		 
		   Log.i(this.getClass().toString(), "Datos iniciales PELICULA insertados");
		 
		   Log.i(this.getClass().toString(), "Base de datos creada");
		   
	   }
	 
	//  private static final String SQL_DROP_PELICULA =                                //eliminar tabla
      //  "DROP TABLE IF EXISTS PELICULA"  ;
	  
	   @Override
	   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	   {
	      
	      
	     // db.execSQL(SQL_DROP_PELICULA);
	       //onCreate(db);
	     
  }
	   
	   
	   }
	   

