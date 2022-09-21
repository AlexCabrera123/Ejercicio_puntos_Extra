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
    private Button bOrdenar,bGuardar;
    private ListView lvLista;
    private ArrayList alnumeros;
    private EditText etGuardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etGuardar = findViewById(R.id.etGuardar);
        bGuardar = findViewById(R.id.bGuardar);
        bOrdenar = findViewById(R.id.bRegistrar);
        lvLista = findViewById(R.id.lvlista);

        ArrayList<Integer> alnumeros = new ArrayList<>();

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_list_item_1,alnumeros);

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = etGuardar.getText().toString().trim();
                if (input.equals(""))
                    Toast.makeText(getApplicationContext(),"Favor de ingresar un número",Toast.LENGTH_LONG).show();
                else{
                    int aux = Integer.parseInt(input);
                    for (int i = 0; i < alnumeros.size(); i++) {
                        if (alnumeros.get(i) == aux){
                            Toast.makeText(getApplicationContext(),"El entero" +aux+ "ya existe",Toast.LENGTH_LONG).show();
                        }


                    }

                    alnumeros.add(aux);
                    etGuardar.setText("");
                    adapter.notifyDataSetChanged();
                    lvLista.setAdapter(adapter);
                }

            }
        });

        bOrdenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = 0;
                for(int i=0; i < alnumeros.size(); i++){
                    for(int j=1; j < (alnumeros.size()-i); j++){
                        if(alnumeros.get(j - 1) > alnumeros.get(j)){
                            //swap elements
                            temp = alnumeros.get(j - 1);
                            alnumeros.set(j - 1, alnumeros.get(j));
                            alnumeros.set(j, temp);
                        }
                    }
                }
                System.out.println("Array After Bubble Sort");
                for(int i=0; i < alnumeros.size(); i++){
                    System.out.print(alnumeros.get(i) + " ");
                }
                ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_list_item_1,alnumeros);
                lvLista.setAdapter(adapter);
            }
        });

        };


    }
    