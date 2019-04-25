package com.eton.roomdb.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ChatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertChat(Chat... chats);

    @Query("SELECT * FROM chat WHERE uid= :uid ORDER BY update_time DESC ")
    List<Chat> getChats(String uid);

    @Query("SELECT update_time FROM chat WHERE uid= :uid AND chat_id= :chatId")
    long getChatUpdateTime(String uid, String chatId);

    @Query("SELECT unread FROM chat WHERE uid= :uid AND chat_id= :chatId")
    int getUnread(String uid, String chatId);

    @Query("UPDATE chat SET unread = 0 WHERE uid= :uid AND chat_id= :chatId")
    void clearUnread(String uid, String chatId);

    @Query("DELETE FROM chat")
    void deleteAll();
}
