package com.eton.roomdb.db;

import android.arch.persistence.room.Query;

import java.util.List;

interface ContactDao {
    @Query("SELECT * FROM Contact")
    List<Contact> getContacts();
}
