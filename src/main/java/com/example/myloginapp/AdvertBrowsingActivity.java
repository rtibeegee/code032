package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.app.ActionBar.LayoutParams;
import android.widget.TextView;

import java.util.ArrayList;

public class AdvertBrowsingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advert_browsing);
        String subject = getIntent().getStringExtra("selectedClass").toString();

        DatabaseLib.getAdvertBySubject(subject, this);
    }

    public void populateWindow(ArrayList<Advert> list)
    {
        final TableLayout lm = (TableLayout) findViewById(R.id.drawer_layout);

        if (list.size() == 0) {
            TextView ime = new TextView(this);
            ime.setTextSize(30);
            ime.setText("Nazalost trenutno nema oglasa za trazeni premet");
            ime.setTextColor(Color.RED);
            lm.addView(ime);

            return;
        }

        // create the layout params that will be used to define how your
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < list.size(); i++) {

            lm.addView(makeAdvertLayout(list, i));

        }
    }

    @SuppressLint("ResourceAsColor")
    public LinearLayout makeAdvertLayout(ArrayList<Advert> list, int i){


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        //pozadina oglasa
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setPaddingRelative(40,40,40,0);
        // ll.setAnimation();
        ll.setVerticalFadingEdgeEnabled(true);

        //za ime
        TextView ime = new TextView(this);
        ime.setTextSize(30);
        ime.setText(list.get(i).getName());
        ime.setTextColor(Color.RED);
        ll.addView(ime);

        //za tekst oglasa
        TextView mail = new TextView(this);
        mail.setTextSize(20);
        mail.setText(list.get(i).getMail());
        mail.setBackgroundColor(Color.GRAY);
        ll.addView(mail);

        TextView price = new TextView(this);
        price.setTextSize(20);
        price.setText(Integer.toString(list.get(i).getPrice()));
        ll.addView(price);



        ll.setPadding(90,90,90,90);

        return ll;
    };

}