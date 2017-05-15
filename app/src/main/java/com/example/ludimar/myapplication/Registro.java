package com.example.ludimar.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Registro extends Activity {

    String userstr, passwordstr,passconstr,emailstr,preguntastr,respuestastr;
    EditText user,password,passcon,email,pregunta,respuesta;
    ImageButton BSignUp, BBack;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        user        = (EditText)findViewById(R.id.edtUser);
        password    = (EditText)findViewById(R.id.edtPassword);
        passcon     = (EditText)findViewById(R.id.edtPassCon);
        email       = (EditText)findViewById(R.id.edtEmail);
        pregunta    = (EditText)findViewById(R.id.edtPregunta);
        respuesta   = (EditText)findViewById(R.id.edtRespuesta);
        BSignUp     = (ImageButton) findViewById(R.id.bRegistrar);
        BBack       = (ImageButton) findViewById(R.id.bAtras);

        //Abrimos la base de datos 'BDAlumnos' en modo escritura
        BDAlumnos alumnos = new BDAlumnos(this, "footprint", null, 2);
        db = alumnos.getWritableDatabase();


        BSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userstr         = user.getText().toString();
                passwordstr     = password.getText().toString();
                passconstr      = passcon.getText().toString();
                emailstr        = email.getText().toString();
                preguntastr     = pregunta.getText().toString();
                respuestastr    = respuesta.getText().toString();

                if(userstr.length()!=0){
                    if(passwordstr.length()!=0){
                        if(passconstr.length()!=0){
                            if(emailstr.length()!=0){
                                if(email.getText().toString().contains("@") && email.getText().toString().contains(".com")){
                                if(preguntastr.length()!=0){
                                    if(respuestastr.length()!=0){

                                        if(!passwordstr.equals(passconstr)){
                                            Toast.makeText(Registro.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                                        }else {

                                            //Comrpuebo que la BD se abre correctamente
                                            if(db != null){

                                                String[] args = new String[] {userstr};
                                                Cursor c = db.rawQuery(" select * from registro where usuario = ? ", args);
                                                if (c.moveToFirst()) {
                                                    Toast.makeText(Registro.this, "disculpe el usuario que ha introducido ya existe", Toast.LENGTH_SHORT).show();
                                                }else {
                                                    db.execSQL("insert into registro (id,usuario,clave,email,pregunta,respuesta) values " +
                                                            "(NULL,'"+userstr+"','"+passconstr+"','"+emailstr+"','"+preguntastr+"','"+respuestastr+"')");
                                                    limpiarCampos();
                                                    Toast pass = Toast.makeText(Registro.this, "Usuario Registrado con exito", Toast.LENGTH_SHORT);
                                                    pass.show();
                                                }
                                            }
                                        }

                                    }else{
                                        Toast.makeText(Registro.this, "porfavro llene el campo de respuesta", Toast.LENGTH_SHORT).show();
                                    }
                                }else{
                                    Toast.makeText(Registro.this, "porfavro llene el campo de pregunta", Toast.LENGTH_SHORT).show();
                                }

                                }else{
                                    email.setError("Instroduzca solo Email");
                                }
                            }else{
                                Toast.makeText(Registro.this, "porfavro llene el campo de email", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(Registro.this, "porfavro llene el campo de confirmar contraseña", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Registro.this, "porfavro llene el campo de contraseña", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(Registro.this, "porfavro llene el campo de usuarios", Toast.LENGTH_SHORT).show();
                }


            }
        });

        BBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Registro.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    private void limpiarCampos(){
        user.setText(null);
        passcon.setText(null);
        password.setText(null);
        email.setText(null);
        pregunta.setText(null);
        respuesta.setText(null);
    }

}


