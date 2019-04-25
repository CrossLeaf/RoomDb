package com.eton.roomdb.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

@Database(entities = {Contact.class, Group.class, Message.class, Chat.class}, version = 5)
public abstract class AppDatabase extends RoomDatabase {
    static final Migration MIGRATION_4_5 = new Migration(4, 5) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `contact` (`user_id` TEXT NOT NULL, `img` TEXT, `nickname` TEXT, PRIMARY KEY(`user_id`))");
            database.execSQL("CREATE TABLE IF NOT EXISTS `group` (`chat_id` TEXT NOT NULL, `uid` TEXT, `users` TEXT, `avatar` TEXT, `title` TEXT, `update_time` INTEGER NOT NULL, `unread` INTEGER NOT NULL, `current_position` INTEGER NOT NULL, `is_private` TEXT, `from_id` TEXT, `text` TEXT, `chat_position` INTEGER NOT NULL, `msg_type` INTEGER NOT NULL, `event` TEXT, `from_role` INTEGER NOT NULL, `from_nickname` TEXT, `from_avatar` TEXT, `file_id` TEXT, `file_duration` INTEGER NOT NULL, `is_muted` TEXT, `at` TEXT, `at_nickname` TEXT, PRIMARY KEY(`chat_id`))");
            database.execSQL("CREATE TABLE IF NOT EXISTS `message` (`message_id` TEXT NOT NULL, `user_id` TEXT, `chat_id` TEXT, `time` INTEGER NOT NULL, `from_user` TEXT, `text` TEXT, `chat_p` INTEGER NOT NULL, `msg_type` INTEGER NOT NULL, `event` TEXT, `from_role` INTEGER NOT NULL, `from_nick_name` TEXT, `from_avatar` TEXT, `file_id` TEXT, `image_local_url` TEXT, `voice_local_url` TEXT, `file_duration` INTEGER NOT NULL, `is_muted` TEXT, `at` TEXT, `at_nick_name` TEXT, `send_state` INTEGER NOT NULL, `item_type` INTEGER NOT NULL, `og_object` TEXT, PRIMARY KEY(`message_id`))");
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
//                        .addMigrations(MIGRATION_4_5)
                        .build();

            }
            return INSTANCE;
        }
    }

    public abstract ContactDao contactDao();

    public abstract GroupDao groupDao();

    public abstract MessageDao messageDao();

    public abstract ChatDao chatDao();
}
