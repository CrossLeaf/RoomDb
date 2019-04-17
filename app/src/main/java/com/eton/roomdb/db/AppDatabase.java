package com.eton.roomdb.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

@Database(entities = {Contact.class, Group.class}, version = 6)
public abstract class AppDatabase extends RoomDatabase {
    static final Migration MIGRATION_4_5 = new Migration(4, 5) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `contact` (`user_id` TEXT NOT NULL, `img` TEXT, `nickname` TEXT, PRIMARY KEY(`user_id`))");
            database.execSQL("drop table if exists chat_list");
            database.execSQL("drop table if exists chat_msg_list");
        }
    };
    private static final String APP_NAME = "Im";// APP名称
    private static final String DB_NAME = APP_NAME + ".db";//数据库名称
    private static final Object sLock = new Object();
    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                        .addMigrations(MIGRATION_4_5)
                        .build();
                //                        .fallbackToDestructiveMigration()

            }
            return INSTANCE;
        }
    }

    public abstract ContactDao contactDao();

    public abstract GroupDao groupDao();
}
