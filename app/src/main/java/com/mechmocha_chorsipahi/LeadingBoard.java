package com.mechmocha_chorsipahi;

public class LeadingBoard {
    private int imgUrl;
    private String pName;
    private int points;
    private int position;

    public LeadingBoard(int i, String str, int i2, int i3) {
        this.imgUrl = i;
        this.pName = str;
        this.points = i2;
        this.position = i3;
    }

    public int getImageUrl() {
        return this.imgUrl;
    }

    public String getPlayerName() {
        return this.pName;
    }

    public int getPoints() {
        return this.points;
    }

    public int getPosition() {
        return this.position;
    }
}
