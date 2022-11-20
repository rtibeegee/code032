package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class BuyBookActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String classes[]={"FTN:Matematika 1", "ETF:Matematika 2", "ETF:Programiranje 1"};
    String mySubject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mySubject="";
        setContentView(R.layout.activity_buy_book);
        Spinner spin = (Spinner) findViewById(R.id.spinner10);
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
        mySubject = classes[i];
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
    public void search(View v){

        if(mySubject.equals("")) { Toast.makeText(getApplicationContext(), "Nije odabran nijedan", Toast.LENGTH_LONG).show();
            return;}
        Intent i=getIntent();




        Intent j = new Intent(getApplicationContext(), BookBrowsingActivity.class);
        j.putExtra("username", getIntent().getStringExtra("username"));
        j.putExtra("number", getIntent().getStringExtra("number"));
        j.putExtra("averageGrade", getIntent().getDoubleExtra("averageGrade", 0));
        j.putExtra("numberOfGrades", getIntent().getIntExtra("numberOfGrades", 0));
        j.putExtra("name", getIntent().getStringExtra("name"));
        j.putExtra("mail", getIntent().getStringExtra("mail"));
        j.putExtra("selectedClass", mySubject);
        startActivity(j);



    }
}