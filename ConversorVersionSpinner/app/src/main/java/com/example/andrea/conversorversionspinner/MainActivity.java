package com.example.andrea.conversorversionspinner;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Localizar spinner
    Spinner lista;
    EditText cant;
    TextView solucion;
    float temp;
    String[]datos = {"Opciones de conversion","- Bytes a KiloBytes","- Bytes a MegaBytes","- KiloBytes a Bytes","- KiloBytes a Megabytes","- MegaBytes a Bytes","- Megabytes a KiloBytes"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //---------------------------------------------   Empieza mi codigo   ---------------------------------------------------------------

        cant = (EditText)findViewById(R.id.editText);
        solucion = (TextView)findViewById(R.id.txvRespuesta);
        lista = (Spinner)findViewById(R.id.lista1);


        //crear adaptador que extrae el array
        ArrayAdapter<String>adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,datos);
        //vincular mi spinner con el adaptador
        lista.setAdapter(adaptador);

        //Evento manejador al pulsar una opcion del spinner
        lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //position nos da el index del array
                switch (position){
                    case 1:
                        temp = Float.parseFloat(cant.getText().toString());

                        //de B a KB
                       solucion.setText("El resultado es: " + temp/1024);

                        break;
                    case 2:
                        temp = Float.parseFloat(cant.getText().toString());

                        //de B a MB
                        solucion.setText("El resultado es: " + (temp/1024)/1024);
                        break;
                    case 3:
                        temp = Float.parseFloat(cant.getText().toString());

                        //de KB a B
                        solucion.setText("El resultado es: " + temp*1024);

                        break;
                    case 4:
                        temp = Float.parseFloat(cant.getText().toString());

                        //de KB a MB
                        solucion.setText("El resultado es: " + temp/1024);
                        break;

                    case 5:
                        temp = Float.parseFloat(cant.getText().toString());

                        //de MB a B
                        solucion.setText("El resultado es: " + (temp*1024)*1024);

                        break;
                    case 6:
                        temp = Float.parseFloat(cant.getText().toString());

                        //de MB a KB
                        solucion.setText("El resultado es: " + temp*1024);
                        break;


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
