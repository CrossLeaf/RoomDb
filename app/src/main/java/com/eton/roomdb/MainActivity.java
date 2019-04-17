package com.eton.roomdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.eton.roomdb.db.AppDatabase;
import com.eton.roomdb.db.Contact;
import com.eton.roomdb.db.Group;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView clickTv = findViewById(R.id.clickTv);
        clickTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("123", "run: 123123");
                        //初始化数据库
//                AppDatabase.getInstance(getApplicationContext());
                        Contact contact = new Contact("1", "img", "小a");
                        AppDatabase.getInstance(getApplicationContext()).contactDao().insertContact(contact);
                        Group group = new Group("123123");
                        AppDatabase.getInstance(getApplicationContext()).groupDao().insertGroup(group);
                    }
                }).start();
            }
        });
//        initDbHelper();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("123", "run: 456456");
                //初始化数据库
                AppDatabase.getInstance(getApplicationContext());
//                Contact contact = new Contact("1", "img", "小a");
//                AppDatabase.getInstance(getApplicationContext()).contactDao().insertContact(contact);
            }
        }).start();
    }

    private void initDbHelper() {
        DbHelper mDbHelper = new DbHelper(getApplication(), "Im.db", 4);
        mDbHelper.getWritableDatabase();
    }

}
