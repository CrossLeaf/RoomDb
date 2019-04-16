package com.eton.roomdb.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Contact")
public class Contact {
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    private String id;

    @ColumnInfo(name = "img")
    private String img;

    @ColumnInfo(name = "nickname")
    private String nickname;

    public Contact(String id, String img, String nickname) {
        this.id = id;
        this.img = img;
        this.nickname = nickname;
    }
}
