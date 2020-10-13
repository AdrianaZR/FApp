package com.example.fitness_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = (ProgressBar)findViewById(R.id.pb);
        boton = (Button)findViewById(R.id.boton);

        pb.setVisibility(View.INVISIBLE);

        boton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View view){
                new Task().execute();

            }
        });
    }

    class Task extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            pb.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            for(int i=0; i<=10;i++){
                try {
                    Thread.sleep(100);

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            Intent i= new Intent(getBaseContext(),Menu_act.class);
            startActivity(i);
        }
    }



}