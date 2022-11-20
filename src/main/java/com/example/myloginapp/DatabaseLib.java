package com.example.myloginapp;

import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class DatabaseLib {

    public static DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    public static DatabaseReference usersRef = rootRef.child("users");
    public static DatabaseReference advertsRef = rootRef.child("adverts");
    public static DatabaseReference booksRef=rootRef.child("books");
    public static DatabaseReference likesRef = rootRef.child("likes");

    public static void register(User user, SignInActivity target) {

        usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    if (ds.getValue(User.class).getUsername().equals(user.getUsername()))
                        { target.registerCallback(false); return; }
                }
                usersRef.push().setValue(user);
                target.registerCallback(true);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public static void sellBook(Book book) {
        booksRef.push().setValue(book);
    }

    public static void login(String username, String password, LoginActivity target) {

        usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    if (ds.getValue(User.class).getUsername().equals(username)
                        && ds.getValue(User.class).getPassword().equals(password))
                    {
                        target.loginCallback(ds.getValue(User.class));
                        return;
                    }
                }
                target.loginCallback(null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public static void getBookBySubject(String subject, BookBrowsingActivity target) {

        booksRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Book> books = new ArrayList<>();
                for (DataSnapshot ds : snapshot.getChildren()) {
                    if (subject.equals(ds.getValue(Book.class).getSubject()))
                        books.add(ds.getValue(Book.class));
                }
                target.populateWindow(books);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public static void addAdvert(Advert advert, OfferClassActivity target) {

        advertsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    if (ds.getValue(Advert.class).getUsername().equals(advert.getUsername())
                            && ds.getValue(Advert.class).getSubject().equals(advert.getSubject()))
                    {
                        target.submitOfferCallback(false);
                        return;
                    }
                }
                advertsRef.push().setValue(advert);


                target.submitOfferCallback(true);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    public static void getAdvertBySubject(String subject, AdvertBrowsingActivity target) {

        advertsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Advert> a = new ArrayList<>();
                for (DataSnapshot ds : snapshot.getChildren()) {
                    if (subject.equals(ds.getValue(Advert.class).getSubject()))
                        a.add(ds.getValue(Advert.class));
                }
                target.populateWindow(a);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }



}