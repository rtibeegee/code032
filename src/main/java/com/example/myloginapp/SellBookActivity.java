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

public class SellBookActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String classes[]={"FTN:Matematika 1", "ETF:Matematika 2", "ETF:Programiranje 1"};
    String myClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_book);
        Spinner spin = (Spinner) findViewById(R.id.spinner3);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,classes);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        myClass = classes[i];
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void sellBook(View v){

        if (myClass.equals("")) {
            Toast.makeText(getApplicationContext(), "Nije odabran nijedan predmet", Toast.LENGTH_LONG).show();
            return;
        }
        if (((EditText) findViewById(R.id.editTextTextPersonName)).getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Nije unet naziv knjige", Toast.LENGTH_LONG).show();
            return;
        }
        if (((EditText) findViewById(R.id.editTextTextPersonName6)).getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Nije uneto stanje", Toast.LENGTH_LONG).show();
            return;
        }

        if (((EditText) findViewById(R.id.editTextNumber)).getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Nije uneta cena knjige", Toast.LENGTH_LONG).show();
            return;
        }
        Intent i = getIntent();
        Book myBook = new Book(
                ((EditText) findViewById(R.id.editTextTextPersonName)).getText().toString(),
                i.getStringExtra("name"),
                i.getStringExtra("number"),
                ((EditText) findViewById(R.id.editTextTextPersonName6)).getText().toString(),
                myClass,
                Integer.parseInt(((EditText) findViewById(R.id.editTextNumber)).getText().toString()));
        Log.d("Debugging123",i.getStringExtra("name"));
        DatabaseLib.sellBook(myBook);
    }


}