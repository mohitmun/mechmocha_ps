package com.mechmocha_chorsipahi.model;

public class User {
    public User(int uid, String name, boolean isHost) {
        this.uid = uid;
        this.name = name;
        this.role = isHost ? "king" : null;
    }

    public final int uid;
    public final String name;
    public String role;
}
