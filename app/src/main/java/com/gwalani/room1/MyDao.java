package com.gwalani.room1;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addUser(User user);

    @Query("SELECT * FROM users")
    public List<User> getUsers();

    @Delete
    public void deleteUser(User user);
}
