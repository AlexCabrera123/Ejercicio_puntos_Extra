package com.example.ejercicio_puntos_extra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText etTexto;
    private Button bRegistrar;
    private ListView lvLista;
    private ArrayList alPalabras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTexto = findViewById(R.id.etTexto);
        bRegistrar = findViewById(R.id.bRegistrar);
        lvLista = findViewById(R.id.lvlista);
        alPalabras = new ArrayList<String>();

        bRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String palabra = etTexto.getText().toString().trim();

                if (palabra.equals(" ")) {
                    Toast.makeText(getApplicationContext(), "FAVOR DE UNA PALABRA", Toast.LENGTH_LONG);

                } else {
                  String aux = etTexto.getText().toString();
                   alPalabras.add(aux);

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,alPalabras);

                lvLista.setAdapter(adapter);
                lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                });
            }


        });


    }
}