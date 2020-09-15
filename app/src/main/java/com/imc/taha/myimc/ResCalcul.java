package com.imc.taha.myimc;

import android.graphics.drawable.Drawable;
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
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class ResCalcul extends Activity {




    TextView texte1=null, texte0=null;
    ImageView img=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_calcul);

        Intent i=getIntent();

        String res =i.getStringExtra(Calcul.key);

        //Toast.makeText(ResCalcul.this,res , Toast.LENGTH_SHORT).show();
        float imc = Float.valueOf(res);
        texte0=(TextView)findViewById(R.id.resIMC); texte0.setText("Votre IMC : "+res.substring(0,5));
       if (imc<16.5)       {



           img=(ImageView) findViewById(R.id.img);
           Drawable drawable  = getResources().getDrawable(R.drawable.weak);
           img.setImageDrawable(drawable);
           texte1=(TextView)findViewById(R.id.res1); texte1.setText(R.string.cas1);   }

       else if (imc>=16.5 && imc<18.5)  {
           img=(ImageView) findViewById(R.id.img);
           Drawable drawable  = getResources().getDrawable(R.drawable.weak);
           img.setImageDrawable(drawable);
           texte1=(TextView)findViewById(R.id.res1); texte1.setText(R.string.cas2);}



        else if(imc>=18.5 && imc<25)     {
           img=(ImageView) findViewById(R.id.img);
           Drawable drawable  = getResources().getDrawable(R.drawable.good);
           img.setImageDrawable(drawable);
           texte1=(TextView)findViewById(R.id.res1); texte1.setText(R.string.cas3);}


       else if(imc>=25 && imc<30)     {
           img=(ImageView) findViewById(R.id.img);
           Drawable drawable  = getResources().getDrawable(R.drawable.bad11);
           img.setImageDrawable(drawable);
           texte1=(TextView)findViewById(R.id.res1); texte1.setText(R.string.cas4);}


       else if(imc>=30 && imc<35)     {
           img=(ImageView) findViewById(R.id.img);
           Drawable drawable  = getResources().getDrawable(R.drawable.bad11);
           img.setImageDrawable(drawable);
           texte1=(TextView)findViewById(R.id.res1); texte1.setText(R.string.cas5);}


       else if(imc>=35 && imc<40)    {
           img=(ImageView) findViewById(R.id.img);
           Drawable drawable  = getResources().getDrawable(R.drawable.bad2);
           img.setImageDrawable(drawable);
           texte1=(TextView)findViewById(R.id.res1); texte1.setText(R.string.cas6);}


       else if (imc>=40)           {
           img=(ImageView) findViewById(R.id.img);
           Drawable drawable  = getResources().getDrawable(R.drawable.bad2);
           img.setImageDrawable(drawable);
           texte1=(TextView)findViewById(R.id.res1); texte1.setText(R.string.cas7);}


    }


    public void retry(View view) {

        finish();

    }



















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_res_calcul, menu);
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
