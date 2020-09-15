package com.imc.taha.myimc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;
import android. widget. EditText;
import android.widget.Spinner;


public class Calcul extends Activity {

    EditText poids = null;
    EditText taille = null;

    Spinner s1 = null;
    Spinner s2 = null;

    ImageView ok = null;
    ImageView cancel = null;

    public final static String key = "clé";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);

        taille = (EditText)findViewById(R.id.taille);
        poids = (EditText)findViewById(R.id.poids);
        ok = (ImageView)findViewById(R.id.ok);
        cancel = (ImageView)findViewById(R.id.cancel);
    }



// ******************************************************************** event OK ************************************************
    public void ok(View view) {


        String t = taille.getText().toString( );
        String p = poids.getText().toString();






        if(t.isEmpty() || p.isEmpty())      Toast.makeText(Calcul.this, "veillez remplir les champs ", Toast.LENGTH_SHORT).show() ;

       else {
            float tValue = Float.valueOf(t);
            float pValue = Float.valueOf(p);

              if (tValue == 0 || pValue == 0)  Toast.makeText(Calcul.this, "Entrez des informations correctes !!", Toast.LENGTH_SHORT).show();

            else

                   s1 = (Spinner)findViewById(R.id.spinner);

                   s2 = (Spinner)findViewById(R.id.spinner2);

                    if(s1.getSelectedItem().toString().equals("Inch")) tValue=tValue*(float)0.0254;
                    if(s2.getSelectedItem().toString().equals("lb"))   pValue=pValue*(float)0.453592;

                    tValue = (float)Math.pow(tValue,2) ;
                    float fImc = pValue/tValue;
                    String sImc = String.valueOf(fImc);
                    //Toast.makeText(Calcul.this,sImc , Toast.LENGTH_SHORT).show();


                   Intent intent = new Intent( this, ResCalcul.class );


                    intent.putExtra( key,sImc);
                    startActivity(intent);
        }

    }


// ******************************************************************** event CANCEL ****************************************
    public void cancel(View view) {

        poids.getText().clear();
        taille.getText().clear();

    }



//************************************************************************* Return

    public void retour(View view) {

       finish();

    }





















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calcul, menu);
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
