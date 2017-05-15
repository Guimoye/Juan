package com.example.ludimar.myapplication;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Javier on 15/05/2017.
 */

public class Recuperar extends Activity {

    String userstr,emailstr,preguntastr,respuestastr;
    EditText user,email,pregunta,respuesta;
    ImageButton bRecuperar;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);
        user        = (EditText)findViewById(R.id.edtUser);
        email       = (EditText)findViewById(R.id.edtEmail);
        pregunta    = (EditText)findViewById(R.id.edtPregunta);
        respuesta   = (EditText)findViewById(R.id.edtRespuesta);
        bRecuperar  = (ImageButton) findViewById(R.id.bRecuperar);

        //Abrimos la base de datos 'BDAlumnos' en modo escritura
        BDAlumnos alumnos = new BDAlumnos(this, "footprint", null, 2);
        db = alumnos.getWritableDatabase();


        bRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userstr         = user.getText().toString();
                emailstr        = email.getText().toString();
                preguntastr     = pregunta.getText().toString();
                respuestastr    = respuesta.getText().toString();

                if(userstr.length()!=0){
                    if(emailstr.length()!=0){
                        if(email.getText().toString().contains("@") && email.getText().toString().contains(".com")){

                         if(preguntastr.length()!=0){
                             if(respuestastr.length()!=0){


                                            //Comrpuebo que la BD se abre correctamente
                                            if(db != null){

                                                Cursor c = db.rawQuery("select clave from registro where " +
                                                                        "usuario = '"+userstr+"' and " +
                                                                        "email= '"+emailstr+"' and " +
                                                                        "pregunta = '"+preguntastr+"' and " +
                                                                        "respuesta = '"+respuestastr+"'", null);
                                                if (c.moveToFirst()) {
                                                    limpiarCampos();
                                                    Toast.makeText(getApplicationContext(), "Contraseña Recuperada con Exito "+c.getString(0), Toast.LENGTH_SHORT).show();
                                                }else {
                                                    Toast.makeText(getApplicationContext(), "usuario no encontrado, porfavor revise sus datos", Toast.LENGTH_SHORT).show();

                                                }
                                            }


                                    }else{
                                        Toast.makeText(getApplicationContext(), "porfavro llene el campo de respuesta", Toast.LENGTH_SHORT).show();
                                    }
                                }else{
                                    Toast.makeText(getApplicationContext(), "porfavro llene el campo de pregunta", Toast.LENGTH_SHORT).show();
                                }

                        }else{
                            email.setError("Instroduzca solo Email");
                        }

                            }else{
                                Toast.makeText(getApplicationContext(), "porfavro llene el campo de email", Toast.LENGTH_SHORT).show();
                            }


                }else{
                    Toast.makeText(getApplicationContext(), "porfavro llene el campo de usuarios", Toast.LENGTH_SHORT).show();
                }


            }
        });



    }

    private void limpiarCampos(){
        user.setText(null);
        email.setText(null);
        pregunta.setText(null);
        respuesta.setText(null);
    }

}
