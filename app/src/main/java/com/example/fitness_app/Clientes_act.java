package com.example.fitness_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.*;

import java.util.ArrayList;

import Clases.Planes;

public class Clientes_act extends AppCompatActivity {

    private Spinner spin1, spin2;
    private TextView text;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        spin1 = (Spinner)findViewById(R.id.spinner);
        spin2=(Spinner)findViewById(R.id.spinner2);
        text = (TextView)findViewById(R.id.textView5);
        edit = (EditText)findViewById(R.id.editTextTextPersonName3);
        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaPlanes = (ArrayList<String>) getIntent().getSerializableExtra("listaPlanes");

        ArrayAdapter<String> adapt = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaClientes);
        spin1.setAdapter(adapt);
        ArrayAdapter<String> adapt2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaPlanes);
        spin2.setAdapter(adapt2);



    }


    public void Calcular(View v){
        String cliente = spin1.getSelectedItem().toString();
        String planes = spin2.getSelectedItem().toString();

        Planes plan = new Planes();

        int saldo = Integer.parseInt(edit.getText().toString());
        int extreme = Integer.parseInt(plan.getExtreme());
        int mindfulness = Integer.parseInt(plan.getMindfulness());
        int resultado = saldo - extreme;
        int resultado2 = saldo - mindfulness;

        if(cliente.equals("Roberto") && planes.equalsIgnoreCase("Extreme"))
        {
            text.setText("El valor Adeudado por Extreme es: "+ resultado);
        }
        else if(cliente.equals("Roberto") && planes.equalsIgnoreCase("Mindfulness"))
        {
            text.setText("El valor Adeudado por Mindfulness es: "+ resultado2);
        }


    }

}