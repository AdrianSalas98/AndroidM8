package com.example.tnb_20.numericos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random = new Random();
        final int rango = random.nextInt(100);
        final Button button = findViewById(R.id.button);
        final EditText editText = findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String st = String.valueOf(editText.getText());
                int numero = Integer.parseInt(st);
                if(numero > rango){
                    Context context = getApplicationContext();
                    CharSequence text = "Pon un numero mas pequeño";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else if(numero < rango){
                    Context context = getApplicationContext();
                    CharSequence text = "Pon un numero mas grande";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else if(numero == rango){
                    Context context = getApplicationContext();
                    CharSequence text = "Lo has adivinado";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }

}
