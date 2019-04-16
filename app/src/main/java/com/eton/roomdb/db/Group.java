package com.eton.roomdb.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Group")
public class Group {
    @PrimaryKey
    @ColumnInfo(name = "chat_id")
    private String chatId;

    @ColumnInfo(name = "avatar")
    private String avatar;
}
