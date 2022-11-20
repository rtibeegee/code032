package com.example.myloginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Context con=MainActivity.this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.drawer_layout);
        Log.d("TAGTAGTAG",findViewById(R.id.drawer_layout).toString());
        drawerLayout=findViewById(R.id.drawer_layout);
        Log.d("TAGTAGTAG", drawerLayout.toString());
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d("TAGTAGTAG","HJFOWJFOJ");

        navigationView=findViewById(R.id.navigation_view);

        String s1="navigation_drawer_open";
        String s2="navigation_drawer_close";

     //   actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.menu_Open, R.string.menu_Close);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.teach:{
                        if(getIntent().getStringExtra("username")==null||getIntent().getStringExtra("username").equals("")||!getIntent().hasExtra("username")) {
                            Toast.makeText(MainActivity.this,"Niste ulogovani",Toast.LENGTH_LONG).show();return true;}
                        Intent i=new Intent(con, OfferClassActivity.class);
                        i.putExtra("username", getIntent().getStringExtra("username"));
                        i.putExtra("number", getIntent().getStringExtra("number"));
                        i.putExtra("averageGrade", getIntent().getDoubleExtra("averageGrade", 0));
                        i.putExtra("numberOfGrades", getIntent().getIntExtra("numberOfGrades", 0));
                        i.putExtra("name", getIntent().getStringExtra("name"));
                        i.putExtra("mail", getIntent().getStringExtra("mail"));
                        startActivity(i);
                        return true;
                    }
                    case R.id.login:{
                        if(getIntent().getStringExtra("username")!=null&&!getIntent().getStringExtra("username").equals("")&&getIntent().hasExtra("username")) {
                            Toast.makeText(MainActivity.this,"Vec ste ulogovani",Toast.LENGTH_LONG).show();return true;}
                        Intent i=new Intent(con, LoginActivity.class);
                        i.putExtra("username", getIntent().getStringExtra("username"));
                        i.putExtra("number", getIntent().getStringExtra("number"));
                        i.putExtra("numberOfGrades", getIntent().getIntExtra("numberOfGrades", 0));
                        i.putExtra("averageGrade", getIntent().getDoubleExtra("averageGrade", 0));
                        i.putExtra("name", getIntent().getStringExtra("name"));
                        i.putExtra("mail", getIntent().getStringExtra("mail"));
                        startActivity(i);
                        return true;
                    }

                    case R.id.logout:{
                        if(getIntent().getStringExtra("username")==null||getIntent().getStringExtra("username").equals("")||!getIntent().hasExtra("username")) {
                            Toast.makeText(MainActivity.this,"Niste ulogovani",Toast.LENGTH_LONG).show();return true;}

                        Intent i=new Intent(MainActivity.this, MainActivity.class);
                        i.putExtra("username", "");
                        i.putExtra("number", "");
                        i.putExtra("numberOfGrades", 0);
                        i.putExtra("averageGrade", 0);
                        i.putExtra("name", "");
                        i.putExtra("mail", "");


                        startActivity(i);
                        return true;
                    }

                    case R.id.signup:{
                        if(getIntent().getStringExtra("username")!=null&&!getIntent().getStringExtra("username").equals("")&&getIntent().hasExtra("username")) {
                            Toast.makeText(MainActivity.this,"Vec ste ulogovani",Toast.LENGTH_LONG).show();return true;}
                        Intent i=new Intent(con, SignInActivity.class);
                        i.putExtra("username", getIntent().getStringExtra("username"));
                        i.putExtra("number", getIntent().getStringExtra("number"));
                        i.putExtra("averageGrade", getIntent().getDoubleExtra("averageGrade", 0));
                        i.putExtra("numberOfGrades", getIntent().getIntExtra("numberOfGrades", 0));
                        i.putExtra("name", getIntent().getStringExtra("name"));
                        i.putExtra("mail", getIntent().getStringExtra("mail"));
                        startActivity(i);
                        return true;
                    }
                    case R.id.book_purchase:{
                        Intent i=new Intent(con, BuyBookActivity.class);
                        i.putExtra("username", getIntent().getStringExtra("username"));
                        i.putExtra("number", getIntent().getStringExtra("number"));
                        i.putExtra("averageGrade", getIntent().getDoubleExtra("averageGrade", 0));
                        i.putExtra("numberOfGrades", getIntent().getIntExtra("numberOfGrades", 0));
                        i.putExtra("name", getIntent().getStringExtra("name"));
                        i.putExtra("mail", getIntent().getStringExtra("mail"));
                        startActivity(i);
                        return true;
                    }
                    case R.id.book_sell:{
                        if(getIntent().getStringExtra("username")==null||getIntent().getStringExtra("username").equals("")||!getIntent().hasExtra("username")) {
                            Toast.makeText(MainActivity.this,"Niste ulogovani",Toast.LENGTH_LONG).show();return true;}
                        Intent i=new Intent(con, SellBookActivity.class);
                        i.putExtra("username", getIntent().getStringExtra("username"));
                        i.putExtra("number", getIntent().getStringExtra("number"));
                        i.putExtra("averageGrade", getIntent().getDoubleExtra("averageGrade", 0));
                        i.putExtra("numberOfGrades", getIntent().getIntExtra("numberOfGrades", 0));
                        i.putExtra("name", getIntent().getStringExtra("name"));
                        i.putExtra("mail", getIntent().getStringExtra("mail"));
                        startActivity(i);
                        return true;
                    }
                    case R.id.attend:{
                        Intent i=new Intent(con, LookClassActivity.class);
                        i.putExtra("username", getIntent().getStringExtra("username"));
                        i.putExtra("number", getIntent().getStringExtra("number"));
                        i.putExtra("averageGrade", getIntent().getDoubleExtra("averageGrade", 0));
                        i.putExtra("numberOfGrades", getIntent().getIntExtra("numberOfGrades", 0));
                        i.putExtra("name", getIntent().getStringExtra("name"));
                        i.putExtra("mail", getIntent().getStringExtra("mail"));
                        startActivity(i);
                        return true;
                    }
                    default: return true;



                }

            }


        });


    }





}