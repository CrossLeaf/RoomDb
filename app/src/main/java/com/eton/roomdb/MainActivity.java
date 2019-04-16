package com.eton.roomdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eton.roomdb.db.AppDatabase;
import com.eton.roomdb.db.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Contact contact = new Contact("1", "img", "小a");
                AppDatabase.getInstance(getApplicationContext()).contactDao().insertContact(contact);
            }
        }).start();
    }
}
