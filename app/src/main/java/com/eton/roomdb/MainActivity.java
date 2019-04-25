package com.eton.roomdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.eton.roomdb.db.AppDatabase;
import com.eton.roomdb.db.Chat;
import com.eton.roomdb.db.Contact;
import com.eton.roomdb.db.Group;
import com.eton.roomdb.db.Message;

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
                        for (int i = 0; i < 10; i++) {
                            Contact contact = new Contact(i + "", "img", "小a");
                            AppDatabase.getInstance(getApplicationContext()).contactDao().insertContact(contact);
                            Group group = new Group(i + "","","","","",3,2,1,true,"","",2,2,"",3,"","","",2,"","","");
                            Group group1 = new Group(i + "10","","","","",3,2,1,false,"","",2,2,"",3,"","","",2,"","","");
                            AppDatabase.getInstance(getApplicationContext()).groupDao().insertGroup(group);
                            AppDatabase.getInstance(getApplicationContext()).groupDao().insertGroup(group1);
                            Message message = new Message(i + "");
                            AppDatabase.getInstance(getApplicationContext()).messageDao().insertMessage(message);
                            Chat chat = new Chat("1");
                            AppDatabase.getInstance(getApplicationContext()).chatDao().insertChat(chat);
                        }
                    }
                }).start();
            }
        });
        clickTv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("123", "run: longclick");
                        AppDatabase.getInstance(getApplicationContext()).contactDao().deleteAll();
                    }
                }).start();
                return true;
            }
        });
//        initDbHelper();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("123", "run: 456456");
                //初始化数据库
//                AppDatabase.getInstance(getApplicationContext());
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
