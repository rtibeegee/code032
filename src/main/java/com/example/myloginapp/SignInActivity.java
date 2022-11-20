package com.example.myloginapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myloginapp.databinding.ActivitySignIn2Binding;

public class SignInActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySignIn2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void register(View v){
/*        Log.d("TAG123456","REGISTER");
        String name = ((EditText)findViewById(R.id.name_and_surname)).getText().toString();
        String username = ((EditText)findViewById(R.id.username)).getText().toString();
        String password = ((EditText)findViewById(R.id.password)).getText().toString();
        String mail = ((EditText)findViewById(R.id.mail)).getText().toString();
        String number = ((EditText)findViewById(R.id.number)).getText().toString();
        Log.d("TAG123456","REGISTER2");
        if(name.equals("") || username.equals("") || password.equals("") || mail.equals("") || number.equals("") ){
            Log.d("TAG123456","REGISTER4");
         Toast.makeText(getApplicationContext(), "Nisu popunjeni svi podaci", Toast.LENGTH_LONG).show();
         }
         else{
            Log.d("TAG123456",name);
         User user=new User(name, username, password, mail, number);
         if(!DatabaseLib.register(user)){
         Toast.makeText(getApplicationContext(), "Podaci nisu ispravni", Toast.LENGTH_LONG).show();
         }
         else {
         Intent i=new Intent(getApplicationContext(), MainActivity.class);
         i.putExtra("username", getIntent().getStringExtra("username"));
         i.putExtra("number", getIntent().getStringExtra("username"));
         i.putExtra("averageGrade", getIntent().getStringExtra("AverageGrade"));
         i.putExtra("numberOfGrades", getIntent().getStringExtra("numberOfGrades"));
         startActivity(i);
         }
         }
*/
        Log.d("TAG123456","REGISTER");
        String name = ((EditText)findViewById(R.id.name_and_surname)).getText().toString();
        String username = ((EditText)findViewById(R.id.username)).getText().toString();
        String password = ((EditText)findViewById(R.id.password)).getText().toString();
        String mail = ((EditText)findViewById(R.id.mail)).getText().toString();
        String number = ((EditText)findViewById(R.id.number)).getText().toString();
        Log.d("TAG123456","REGISTER2");
        if(name.equals("") || username.equals("") || password.equals("") || mail.equals("") || number.equals("") ){
            Log.d("TAG123456","REGISTER4");
            Toast.makeText(getApplicationContext(), "Nisu popunjeni svi podaci", Toast.LENGTH_LONG).show();
        }
        else{
            Log.d("TAG123456",name);
            User user=new User(name, username, password, mail, number);
            DatabaseLib.register(user, this);

        }
    }
    public void registerCallback(boolean registered){
        if(!registered){
            Toast.makeText(getApplicationContext(), "Podaci nisu ispravni", Toast.LENGTH_LONG).show();

        }
        else {
            Intent i=new Intent(getApplicationContext(), MainActivity.class);
            i.putExtra("username", getIntent().getStringExtra("username"));
            i.putExtra("number", getIntent().getStringExtra("number"));
            i.putExtra("averageGrade", getIntent().getDoubleExtra("averageGrade", 0));
            i.putExtra("numberOfGrades", getIntent().getIntExtra("numberOfGrades", 0));
            i.putExtra("name", getIntent().getStringExtra("name"));
            i.putExtra("mail", getIntent().getStringExtra("mail"));
            startActivity(i);
        }
    }
}