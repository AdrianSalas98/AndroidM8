package com.example.tnb_20.numericos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.Collections;
import java.util.List;


public class Hall_Fame extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);
        mostrarDatos();
    }


    private void mostrarDatos(){
        List<Jugador> jugadors = MainActivity.jugadores;

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
}