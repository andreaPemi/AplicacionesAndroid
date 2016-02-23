package com.example.andrea.conversorbytes;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.app.AlertDialog;//Muestra mensaje al usuario

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private EditText et;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioButton rb5;
    private RadioButton rb6;
    private Button bt1;

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


        tv1 = (TextView) findViewById(R.id.textView);
        tv1.setText("Origen");
        tv2 = (TextView) findViewById(R.id.textView2);
        tv2.setText("Cantidad a convertir");
        tv3 = (TextView) findViewById(R.id.textView3);
        tv3.setText("Destino");


        et = (EditText) findViewById(R.id.editText);
        et.setText(Integer.toString(0));

        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb1.setText("Bytes");
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb2.setText("KiloBytes");
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb3.setText("MegaBytes");
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
        rb4.setText("Bytes");
        rb5 = (RadioButton) findViewById(R.id.radioButton5);
        rb5.setText("KiloBytes");
        rb6 = (RadioButton) findViewById(R.id.radioButton6);
        rb6.setText("MegaBytes");

        //declaro mi boton y le pongo texto
        bt1 = (Button) findViewById(R.id.button);
        bt1.setText("Convertir");


        //funcion del boton convertir




               bt1.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       try {

                           //convierto a double el texto que escriben en el cuadro de texto
                           float cant = Float.parseFloat(et.getText().toString());

                           float kb = cant / 1024;//pasando de bytes a kB
                           float mb = kb / 1024;//pasando de bytes a MB
                           float kby = cant * 1024;//pasando de kB a Bytes
                           float mby = kby * 1024;// pasando de MB a Bytes


                           //Misma unidad de conversion
                           if (rb1.isChecked() && rb4.isChecked()) {

                               abre_dialogo();
                           } else if (rb2.isChecked() && rb5.isChecked()) {

                               abre_dialogo();
                           } else if (rb3.isChecked() && rb6.isChecked()) {
                               abre_dialogo();

                           }


                           //Bytes a KiloBytes
                           else if (rb1.isChecked() && rb5.isChecked()) {


                               Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                               i.putExtra("DATO",kb);
                               startActivity(i);

                               //et.setText("" + kb);

                           }
                           //bytes a MegaBytes
                           else if (rb1.isChecked() && rb6.isChecked()) {
                              // et.setText("" + mb);

                               Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                               i.putExtra("DATO",mb);
                               startActivity(i);

                           }


                           //KiloBytes a Bytes
                           else if (rb2.isChecked() && rb4.isChecked()) {
                               //et.setText("" + kby);
                               Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                               i.putExtra("DATO",kby);
                               startActivity(i);

                           }
                           //kiloBytes a MegaByte
                           else if (rb2.isChecked() && rb6.isChecked()) {
                              // et.setText("" + kb);
                               Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                               i.putExtra("DATO",kb);
                               startActivity(i);

                           }
                           //MegaBytes a Bytes
                           else if (rb3.isChecked() && rb4.isChecked()) {
                               //et.setText("" + mby);
                               Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                               i.putExtra("DATO",mby);
                               startActivity(i);
                           }
                           //MegaBytes a KiloBytes
                           else if (rb3.isChecked() && rb5.isChecked()) {
                             //  et.setText("" + kby);
                               Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                               i.putExtra("DATO",kby);
                               startActivity(i);
                           }


                       } catch (Exception e) {
                           errorCaracter();
                       }


                   }
               });
               findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       startActivity(new Intent(MainActivity.this, Main2Activity.class));
                   }
               });




           }

           //Mensaje alerta si en vez de num ponen caracteres o si en los decimales usan la coman en vez del punto
           public void errorCaracter() {
               AlertDialog alertDialog = new AlertDialog.Builder(this).create();
               alertDialog.setTitle("Valor no valido");
               alertDialog.setMessage("Escribe un numero y si es con decimal recuerda usar el punto y no la coma");

               alertDialog.show();
           }

           //Mensaje ALerta si son iguales los radioButtons
           public void abre_dialogo() {
               AlertDialog alertDialog = new AlertDialog.Builder(this).create();
               alertDialog.setTitle("¿Me estas vacilando?");
               alertDialog.setMessage("Has puesto la misma unidad para convertir la cantidad .....Cambia una de las opciones por favor");

               alertDialog.show();
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
