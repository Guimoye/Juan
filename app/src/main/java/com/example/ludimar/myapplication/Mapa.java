package com.example.ludimar.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Mapa extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        String username = getIntent().getStringExtra("Usuario");

        TextView tv = (TextView) findViewById(R.id.TVUsername);
        tv.setText(username);

    }
}
        //Obtener el mensaje de Intent
       // Intent intent = getIntent();
     //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //Crear el TextView
       // TextView textView = new TextView(this);
        //textView.setTextSize(40);
       // textView.setText("Hello Baby");

        //Mostrar el TextView en el Layout
      //  setContentView(textView);

