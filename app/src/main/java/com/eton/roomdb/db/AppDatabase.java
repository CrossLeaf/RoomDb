package com.eton.roomdb.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Contact.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String APP_NAME = "Im";// APP名称
    private static final String DB_NAME = APP_NAME + ".db";//数据库名称
    private static final Object sLock = new Object();
    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                        .build();
            }
            return INSTANCE;
        }
    }

    public abstract ContactDao contactDao();
}
