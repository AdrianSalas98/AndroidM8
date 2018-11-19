package com.example.tnb_20.numericos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Hall_Fame extends Activity{
    private List<Jugador> jugadors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);
        try {
            mostrarDatos();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void mostrarDatos() throws IOException {
        jugadors = new ArrayList<>();
        leerFichero();
        final TextView tablaRecord = findViewById(R.id.record);
        tablaRecord.setText("");
        if(jugadors.size()>0){
            Collections.sort(jugadors);
            for (Jugador jug:
                    jugadors) {
                tablaRecord.setText(tablaRecord.getText() + jug.toString());
            }
        }else{
            tablaRecord.setText(tablaRecord.getText() + "No hay datos registrados");
        }

    }

    private void leerFichero() throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("almacenarJugadors.txt")));
            String datos;
            while((datos = br.readLine())!=null){
                String[] arrayDatos = datos.split(",");
                jugadors.add(new Jugador(arrayDatos[0],Integer.parseInt(arrayDatos[1])));
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}