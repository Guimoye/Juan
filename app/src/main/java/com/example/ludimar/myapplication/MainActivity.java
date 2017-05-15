package com.example.ludimar.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton bRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bRecuperar  = (ImageButton) findViewById(R.id.bRecuperar);

        bRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Recuperar.class);
                startActivity(i);
            }
        });

       }

    public void OnButtonClick(View v){
        if(v.getId() == R.id.bLogin){

            EditText a = (EditText)findViewById(R.id.edtuser);
            String str = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.edtpassword);
            String pass = b.getText().toString();

            String password = "";
            if(pass.equals(password)){
                Intent i = new Intent(MainActivity.this, Mapa.class);
                i.putExtra("Usuario",str);
                startActivity(i);
            }
            else{
                Toast temp = Toast.makeText(MainActivity.this, "Usuario y Contraseña Incorrectos", Toast.LENGTH_SHORT);
                temp.show();
            }

        }
        if(v.getId() == R.id.bRegistrar){
            Intent i = new Intent(MainActivity.this, Registro.class);

            startActivity(i);

        }
    }
}



/*
        //Mapeamos las variables creadas con los controles. Así podemos obtener valores.

        edtuser = (EditText) findViewById(R.id.edtuser);
        edtpassword = (EditText) findViewById(R.id.edtpassword);

    }

   @Override
    public boolean onCreateOptionsMenu(Menu menu){
       //Asignamos el menu al activity
       getMenuInflater().inflate(R.menu.menu_registro, menu);
       return true;
   }

   //Boton Entrar ImageButton

    public void entrar(View view){

        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Mapa.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
      //  String message = editText.getText().toString();
       // intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


   @Override
    public boolean onOptionsItemSelected(MenuItem item){
       //De acuerdo al icono seleccionado se debe realizar una accion
       switch(item.getItemId()){
           case android.R.id.home:
                this.finish();
                return true;
           case R.id.action_add:
               //Controles del usuario necesarios para ingresar
               String user = edtuser.getText().toString();
               String password = edtpassword.getText().toString();

                //Validamos que se ingresen todos los datos
               if(user.length() > 0 && password.length() > 0){
                   //Abrimos la base de datos de clientes
                   UsuarioSQLiteHelper usuario = new UsuarioSQLiteHelper(this, "DBregistro", null, 1);
                   SQLiteDatabase db = usuario.getWritableDatabase();

                   db.execSQL("INSERT INTO registro (user, password) VALUES ('"+user+"', '"+password+"')");
                   db.close();
                   Toast.makeText(this, "El usuario se ha creado exitosamente", Toast.LENGTH_SHORT).show();
                   edtuser.setText("");
                   edtpassword.setText("");
               }
               else{
                   Toast.makeText(this, "Ingrese todos los datos", Toast.LENGTH_SHORT).show();
               }

               return true;
           default:
               return super.onOptionsItemSelected(item);
       }
   }
}
*/

