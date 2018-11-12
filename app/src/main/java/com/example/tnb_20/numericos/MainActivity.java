package com.example.tnb_20.numericos;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private String name;
    private int intentos = 0;
    private int rango;
    public static List<Jugador> jugadores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        encender();
    }

    private void encender() {
        descubrirNombre();
        final Button button = findViewById(R.id.button);
        final Button botonRecord = findViewById(R.id.button2);
        rango = numAleatorio();
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                adivinaNum();
            }
        });

        botonRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tablaDeRecords();
            }
        });

    }

    private int numAleatorio() {
        int randomNum = (int) (Math.random() * 100 + 1);
        return randomNum;
    }

    public void tablaDeRecords() {
        Intent i = new Intent(this, Hall_Fame.class);
        startActivity(i);
    }

    public void adivinaNum() {
        final EditText editText = findViewById(R.id.editText);
        String st = String.valueOf(editText.getText());
        int numero = Integer.parseInt(st);
        if (numero > rango) {
            intentos++;
            Context context = getApplicationContext();
            CharSequence text = "Introduce un numero menor";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else if (numero < rango) {
            Context context = getApplicationContext();
            CharSequence text = "Introduce un numero mayor";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            intentos++;
        } else if (numero == rango) {
            jugadores.add(new Jugador(name,intentos));
            Context context = getApplicationContext();
            CharSequence text = "¡Felicidades, lo has adivinado!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            rango = numAleatorio();
            descubrirNombre();
        }
    }
    private String descubrirNombre(){
        final Dialog dialogo = new Dialog(MainActivity.this);
        dialogo.setContentView(R.layout.dialog);
        dialogo.setTitle("Introduccion de Usuario");
        dialogo.show();
        Button register = dialogo.findViewById(R.id.botonDialog);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText textName = dialogo.findViewById(R.id.etNombre);
                name = textName.getText().toString();
                dialogo.dismiss();
            }
        });
        return name;
    }
}


