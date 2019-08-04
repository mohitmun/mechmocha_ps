package com.mechmocha_chorsipahi.model;

public class User {
    public User(long uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public final long uid;
    public final String name;
    public String role;
}
