package com.eton.roomdb.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertContact(Contact... contacts);

    @Query("SELECT * FROM Contact")
    List<Contact> getContacts();
}
