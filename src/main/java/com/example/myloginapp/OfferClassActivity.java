package com.example.myloginapp;

import static com.example.myloginapp.DatabaseLib.addAdvert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class OfferClassActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String classes[]={"FTN:Matematika 1", "ETF:Matematika 2", "ETF:Programiranje 1"};
    String myClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myClass="";
        setContentView(R.layout.activity_offer_class);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,classes);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(), classes[i] , Toast.LENGTH_LONG).show();
        myClass = classes[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void submitOffer(View v) {
/*
        if(myClass.equals("")) { Toast.makeText(getApplicationContext(), "Nije odabran nijedan predmet", Toast.LENGTH_LONG).show();
        return;}
        if(((EditText)findViewById(R.id.editTextTextPersonName3)).getText().toString().equals("")) {
        Toast.makeText(getApplicationContext(), "Nije uneta cena", Toast.LENGTH_LONG).show();
        return;
        }
        Intent i=getIntent();
        Advert advert=new Advert(myClass, i.getStringExtra("username"), Integer.parseInt(((EditText)findViewById(R.id.editTextTextPersonName3)).getText().toString()),
        ((CheckBox)findViewById(R.id.checkBox)).isChecked(), ((CheckBox)findViewById(R.id.checkBox2)).isChecked());

        if(!addAdvert(advert)){
        Toast.makeText(getApplicationContext(), "Nije bilo moguce uneti ponudu", Toast.LENGTH_LONG).show();
        }
        else{
        Intent j = new Intent(getApplicationContext(), MainActivity.class);
        j.putExtra("username", getIntent().getStringExtra("username"));
        j.putExtra("number", getIntent().getStringExtra("username"));
        j.putExtra("averageGrade", getIntent().getStringExtra("AverageGrade"));
        j.putExtra("numberOfGrades", getIntent().getStringExtra("numberOfGrades"));
        startActivity(j);
        }
*/
        if (myClass.equals("")) {
            Toast.makeText(getApplicationContext(), "Nije odabran nijedan predmet", Toast.LENGTH_LONG).show();
            return;
        }
        if (((EditText) findViewById(R.id.editTextTextPersonName3)).getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Nije uneta cena", Toast.LENGTH_LONG).show();
            return;
        }
        Intent i = getIntent();
        Advert advert = new Advert(
                myClass,
                i.getStringExtra("username"),
                Integer.parseInt(((EditText) findViewById(R.id.editTextTextPersonName3)).getText().toString()),
                ((CheckBox) findViewById(R.id.checkBox)).isChecked(),
                ((CheckBox) findViewById(R.id.checkBox2)).isChecked(),
                i.getStringExtra("number"),
                i.getStringExtra("name"),
                i.getStringExtra("mail")
        );
        Log.d("abcd",i.getStringExtra("username"));
        addAdvert(advert, this);
    }
     public void submitOfferCallback(boolean submited){
        if(!submited){
            Toast.makeText(getApplicationContext(), "Nije bilo moguce uneti ponudu", Toast.LENGTH_LONG).show();
        }
        else{
            Intent j = new Intent(getApplicationContext(), MainActivity.class);
            j.putExtra("username", getIntent().getStringExtra("username"));
            j.putExtra("number", getIntent().getStringExtra("number"));
            j.putExtra("averageGrade", getIntent().getDoubleExtra("averageGrade", 0));
            j.putExtra("numberOfGrades", getIntent().getIntExtra("numberOfGrades", 0));
            j.putExtra("name", getIntent().getStringExtra("name"));
            j.putExtra("mail", getIntent().getStringExtra("mail"));
            startActivity(j);
        }

    }
}