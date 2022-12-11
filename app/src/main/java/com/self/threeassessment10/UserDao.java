package com.self.threeassessment10;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


// User(String userName, String passWord, String yourName, String homeAddr, String workAddr)
@Dao
public interface UserDao {

    @Query(" SELECT * FROM User WHERE userName=:username AND passWord=:password")
    User getUser(String username, String password);

    @Insert
    void insert(User user);

}
