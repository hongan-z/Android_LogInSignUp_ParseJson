package com.self.threeassessment10;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class User implements Serializable{

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String userName;
    private String passWord;
    private String yourName;
    private String homeAddr;
    private String workAddr;

    public User(String userName, String passWord, String yourName, String homeAddr, String workAddr) {
        this.userName = userName;
        this.passWord = passWord;
        this.yourName = yourName;
        this.homeAddr = homeAddr;
        this.workAddr = workAddr;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setYourName(String yourName) {
        this.yourName = yourName;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    public void setWorkAddr(String workAddr) {
        this.workAddr = workAddr;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getYourName() {
        return yourName;
    }

    public String getHomeAddr() {
        return homeAddr;
    }

    public String getWorkAddr() {
        return workAddr;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", yourName='" + yourName + '\'' +
                ", homeAddr='" + homeAddr + '\'' +
                ", workAddr='" + workAddr + '\'' +
                '}';
    }
}
