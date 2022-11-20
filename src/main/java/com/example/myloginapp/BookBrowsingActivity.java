package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class BookBrowsingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_browsing);
        String subject = getIntent().getStringExtra("selectedClass").toString();

        DatabaseLib.getBookBySubject(subject, this);
    }

    public void populateWindow(ArrayList<Book> list)
    {
        final TableLayout lm = (TableLayout) findViewById(R.id.drawer_layout);

        if (list.size() == 0) {
            TextView ime = new TextView(this);
            ime.setTextSize(30);
            ime.setText("Nazalost trenutno nema oglasa za trazeni predmet");
            ime.setTextColor(Color.RED);
            lm.addView(ime);

            return;
        }

        // create the layout params that will be used to define how your
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < list.size(); i++) {

            lm.addView(makeBookLayout(list, i));

        }
    }

    @SuppressLint("ResourceAsColor")
    public LinearLayout makeBookLayout(ArrayList<Book> list, int i){


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

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
        TextView number = new TextView(this);
        number.setTextSize(20);
        number.setText(list.get(i).getSellerNumber());
        number.setBackgroundColor(Color.GRAY);
        ll.addView(number);

        TextView price = new TextView(this);
        price.setTextSize(20);
        price.setText(Integer.toString(list.get(i).getPrice()));
        ll.addView(price);

        ll.setPadding(90,90,90,90);

        return ll;
    }
}