package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View v) {
   /*     Log.d("TAG123456","LOGIN");
        String username = ((EditText)findViewById(R.id.username)).getText().toString();
        String password = ((EditText)findViewById(R.id.password)).getText().toString();
        User myUser = DatabaseLib.login(username, password);
        if(myUser == null){ Toast.makeText(getApplicationContext(), "Korisnicko ime ili lozinka su pogresni", Toast.LENGTH_LONG).show();
        Log.d("TAG123456","NO USER");
        }
        else {
            Log.d("TAG123456","USER");
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("username", myUser.getUsername());
        i.putExtra("number", myUser.getPhoneNumber());
        i.putExtra("averageGrade", myUser.getAverageGrade());
        i.putExtra("numberOfGrades", myUser.getNumberOfGrades());
        startActivity(i);
        }
        */
        Log.d("TAG123456", "LOGIN");
        String username = ((EditText) findViewById(R.id.username)).getText().toString();
        String password = ((EditText) findViewById(R.id.password)).getText().toString();
        if(username.equals("") || password.equals("")) return;
        DatabaseLib.login(username, password, this);
    }
    public void loginCallback(User myUser){
        if(myUser == null){ Toast.makeText(getApplicationContext(), "Korisnicko ime ili lozinka su pogresni", Toast.LENGTH_LONG).show();
            Log.d("TAG123456","NO USER");
        }
        else {
            Log.d("TAG123456","USER");
            Intent i = new Intent(getApplicationContext(), MainActivity.class);

            i.putExtra("username", myUser.getUsername());
            i.putExtra("number", myUser.getPhoneNumber());
            i.putExtra("averageGrade", myUser.getAverageGrade());
            i.putExtra("numberOfGrades", myUser.getNumberOfGrades());
            i.putExtra("name", myUser.getName());
            i.putExtra("mail", myUser.getMail());
            startActivity(i);
        }



    }
}