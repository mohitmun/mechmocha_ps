package com.mechmocha_chorsipahi;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SpinTheBottleAppPreferences {
    private static final String CAT10 = "cat10";
    private static final String IMG_URL = "IMG_URL";
    private static final String KISS_COUNT1 = "KISS_COUNT1";
    private static final String KISS_COUNT2 = "KISS_COUNT2";
    private static final String KISS_COUNT3 = "KISS_COUNT3";
    private static final String KISS_COUNT4 = "KISS_COUNT4";
    private static final String KISS_COUNT5 = "KISS_COUNT5";
    private static final String KISS_COUNT6 = "KISS_COUNT6";
    private static final String KISS_COUNT7 = "KISS_COUNT7";
    private static final String KISS_COUNT8 = "KISS_COUNT8";
    private static final String KISS_COUNT9 = "KISS_COUNT9";
    private static final String OTHER_PLAYER_INDEX = "OTHER_PLAYER_INDEX";
    private static final String PLAYER_1_CHANGE_COUNT = "PLAYER_1_CHANGE_COUNT";
    private static final String PLAYER_2_CHANGE_COUNT = "PLAYER_2_CHANGE_COUNT";
    private static final String PLAYER_3_CHANGE_COUNT = "PLAYER_3_CHANGE_COUNT";
    private static final String PLAYER_4_CHANGE_COUNT = "PLAYER_4_CHANGE_COUNT";
    private static final String PLAYER_5_CHANGE_COUNT = "PLAYER_5_CHANGE_COUNT";
    private static final String PLAYER_6_CHANGE_COUNT = "PLAYER_6_CHANGE_COUNT";
    private static final String PLAYER_7_CHANGE_COUNT = "PLAYER_7_CHANGE_COUNT";
    private static final String PLAYER_8_CHANGE_COUNT = "PLAYER_8_CHANGE_COUNT";
    private static final String PLAYER_9_CHANGE_COUNT = "PLAYER_9_CHANGE_COUNT";
    private static final String PREF_APP_RATE = "pref_app_rate";
    private static final String PREF_LAUNCH_COUNT = "cat1";
    private static final String playerTurn = "playerturn";
    private static SpinTheBottleAppPreferences sInstance;
    private SharedPreferences mPrefs;

    private SpinTheBottleAppPreferences(Context context) {
        this.mPrefs = context.getSharedPreferences("app_prefs", 0);
    }

    public static SpinTheBottleAppPreferences getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new SpinTheBottleAppPreferences(context);
        }
        return sInstance;
    }

    public boolean getAppRate() {
        return this.mPrefs.getBoolean(PREF_APP_RATE, true);
    }

    public void setAppRate(boolean z) {
        Editor edit = this.mPrefs.edit();
        edit.putBoolean(PREF_APP_RATE, z);
        edit.commit();
    }

    public int getLaunchCount() {
        return this.mPrefs.getInt(PREF_LAUNCH_COUNT, 0);
    }

    public void incrementLaunchCount() {
        int launchCount = getLaunchCount();
        Editor edit = this.mPrefs.edit();
        edit.putInt(PREF_LAUNCH_COUNT, launchCount + 1);
        edit.commit();
    }

    public void resetLaunchCount() {
        Editor edit = this.mPrefs.edit();
        edit.remove(PREF_LAUNCH_COUNT);
        edit.commit();
    }

    public void incrementKiss1Count(int i) {
        int kiss1Count = getKiss1Count();
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT1, kiss1Count + i);
        edit.commit();
    }

    public int getKiss1Count() {
        return this.mPrefs.getInt(KISS_COUNT1, 0);
    }

    public void incrementKiss2Count(int i) {
        int kiss2Count = getKiss2Count();
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT2, kiss2Count + i);
        edit.commit();
    }

    public int getKiss2Count() {
        return this.mPrefs.getInt(KISS_COUNT2, 0);
    }

    public void incrementKiss3Count(int i) {
        int kiss3Count = getKiss3Count();
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT3, kiss3Count + i);
        edit.commit();
    }

    public int getKiss3Count() {
        return this.mPrefs.getInt(KISS_COUNT3, 0);
    }

    public void incrementKiss4Count(int i) {
        int kiss4Count = getKiss4Count();
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT4, kiss4Count + i);
        edit.commit();
    }

    public int getKiss4Count() {
        return this.mPrefs.getInt(KISS_COUNT4, 0);
    }

    public void incrementKiss5Count() {
        int kiss5Count = getKiss5Count();
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT5, kiss5Count + 1);
        edit.commit();
    }

    public int getKiss5Count() {
        return this.mPrefs.getInt(KISS_COUNT5, 0);
    }

    public void incrementKiss6Count() {
        int kiss6Count = getKiss6Count();
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT6, kiss6Count + 1);
        edit.commit();
    }

    public int getKiss6Count() {
        return this.mPrefs.getInt(KISS_COUNT6, 0);
    }

    public void incrementKiss7Count() {
        int kiss7Count = getKiss7Count();
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT7, kiss7Count + 1);
        edit.commit();
    }

    public int getKiss7Count() {
        return this.mPrefs.getInt(KISS_COUNT7, 0);
    }

    public void incrementKiss8Count() {
        int kiss8Count = getKiss8Count();
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT8, kiss8Count + 1);
        edit.commit();
    }

    public int getKiss8Count() {
        return this.mPrefs.getInt(KISS_COUNT8, 0);
    }

    public void incrementKiss9Count() {
        int kiss9Count = getKiss9Count();
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT9, kiss9Count + 1);
        edit.commit();
    }

    public int getKiss9Count() {
        return this.mPrefs.getInt(KISS_COUNT9, 0);
    }

    public void increasePlayerTurn() {
        int playerTurn2 = getPlayerTurn();
        Editor edit = this.mPrefs.edit();
        edit.putInt(playerTurn, playerTurn2 + 1);
        edit.commit();
    }

    public int getPlayerTurn() {
        return this.mPrefs.getInt(playerTurn, 0);
    }

    public void incrementCat10Count() {
        int launchCat10Count = getLaunchCat10Count();
        Editor edit = this.mPrefs.edit();
        edit.putInt(CAT10, launchCat10Count + 1);
        edit.commit();
    }

    public int getLaunchCat10Count() {
        return this.mPrefs.getInt(CAT10, 0);
    }

    public void incrementPlayer1ChangeCount() {
        int player1ChangeCount = getPlayer1ChangeCount();
        Editor edit = this.mPrefs.edit();
        edit.putInt(PLAYER_1_CHANGE_COUNT, player1ChangeCount + 1);
        edit.commit();
    }

    public int getPlayer1ChangeCount() {
        return this.mPrefs.getInt(PLAYER_1_CHANGE_COUNT, 0);
    }

    public void setPlayer1ChangeCountToZero() {
        Editor edit = this.mPrefs.edit();
        edit.putInt(PLAYER_1_CHANGE_COUNT, 0);
        edit.commit();
    }

    public void setPlayer2ChangeCountToZero() {
        Editor edit = this.mPrefs.edit();
        edit.putInt(PLAYER_2_CHANGE_COUNT, 0);
        edit.commit();
    }

    public void setPlayer3ChangeCountToZero() {
        Editor edit = this.mPrefs.edit();
        edit.putInt(PLAYER_3_CHANGE_COUNT, 0);
        edit.commit();
    }

    public void setPlayer4ChangeCountToZero() {
        Editor edit = this.mPrefs.edit();
        edit.putInt(PLAYER_4_CHANGE_COUNT, 0);
        edit.commit();
    }

    public void setPlayer5ChangeCountToZero() {
        Editor edit = this.mPrefs.edit();
        edit.putInt(PLAYER_5_CHANGE_COUNT, 0);
        edit.commit();
    }

    public void setPlayer6ChangeCountToZero() {
        Editor edit = this.mPrefs.edit();
        edit.putInt(PLAYER_6_CHANGE_COUNT, 0);
        edit.commit();
    }

    public void setPlayer7ChangeCountToZero() {
        Editor edit = this.mPrefs.edit();
        edit.putInt(PLAYER_7_CHANGE_COUNT, 0);
        edit.commit();
    }

    public void setPlayer8ChangeCountToZero() {
        Editor edit = this.mPrefs.edit();
        edit.putInt(PLAYER_8_CHANGE_COUNT, 0);
        edit.commit();
    }

    public void setPlayer1KISSToZero() {
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT1, 0);
        edit.commit();
    }

    public void setPlayer2KISStToZero() {
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT2, 0);
        edit.commit();
    }

    public void setPlayer3KISSToZero() {
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT3, 0);
        edit.commit();
    }

    public void setPlayer4KISSToZero() {
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT4, 0);
        edit.commit();
    }

    public void setPlayer5KISSToZero() {
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT5, 0);
        edit.commit();
    }

    public void setPlayer6KISSToZero() {
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT6, 0);
        edit.commit();
    }

    public void setPlayer7KISSToZero() {
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT7, 0);
        edit.commit();
    }

    public void setPlayer8KISSToZero() {
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT8, 0);
        edit.commit();
    }

    public void setPlayer9KISSToZero() {
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT9, 0);
        edit.commit();
    }

    public void incrementPlayer2ChangeCount() {
        int player2ChangeCount = getPlayer2ChangeCount();
        Editor edit = this.mPrefs.edit();
        edit.putInt(PLAYER_2_CHANGE_COUNT, player2ChangeCount + 1);
        edit.commit();
    }

    public int getPlayer2ChangeCount() {
        return this.mPrefs.getInt(PLAYER_2_CHANGE_COUNT, 0);
    }

    public void incrementPlayer3ChangeCount() {
        int player3ChangeCount = getPlayer3ChangeCount();
        Editor edit = this.mPrefs.edit();
        edit.putInt(PLAYER_3_CHANGE_COUNT, player3ChangeCount + 1);
        edit.commit();
    }

    public int getPlayer3ChangeCount() {
        return this.mPrefs.getInt(PLAYER_3_CHANGE_COUNT, 0);
    }

    public void incrementPlayer4ChangeCount() {
        int player4ChangeCount = getPlayer4ChangeCount();
        Editor edit = this.mPrefs.edit();
        edit.putInt(PLAYER_4_CHANGE_COUNT, player4ChangeCount + 1);
        edit.commit();
    }

    public int getPlayer4ChangeCount() {
        return this.mPrefs.getInt(PLAYER_4_CHANGE_COUNT, 0);
    }

    public void incrementPlayer5ChangeCount() {
        int player1ChangeCount = getPlayer1ChangeCount();
        Editor edit = this.mPrefs.edit();
        edit.putInt(PLAYER_5_CHANGE_COUNT, player1ChangeCount + 1);
        edit.commit();
    }

    public int getPlayer5ChangeCount() {
        return this.mPrefs.getInt(PLAYER_5_CHANGE_COUNT, 0);
    }

    public void incrementPlayer6ChangeCount() {
        int player6ChangeCount = getPlayer6ChangeCount();
        Editor edit = this.mPrefs.edit();
        edit.putInt(PLAYER_6_CHANGE_COUNT, player6ChangeCount + 1);
        edit.commit();
    }

    public int getPlayer6ChangeCount() {
        return this.mPrefs.getInt(PLAYER_6_CHANGE_COUNT, 0);
    }

    public void incrementPlayer7ChangeCount() {
        int player7ChangeCount = getPlayer7ChangeCount();
        Editor edit = this.mPrefs.edit();
        edit.putInt(PLAYER_7_CHANGE_COUNT, player7ChangeCount + 1);
        edit.commit();
    }

    public int getPlayer7ChangeCount() {
        return this.mPrefs.getInt(PLAYER_7_CHANGE_COUNT, 0);
    }

    public void incrementPlayer8ChangeCount() {
        int player8ChangeCount = getPlayer8ChangeCount();
        Editor edit = this.mPrefs.edit();
        edit.putInt(PLAYER_8_CHANGE_COUNT, player8ChangeCount + 1);
        edit.commit();
    }

    public int getPlayer8ChangeCount() {
        return this.mPrefs.getInt(PLAYER_8_CHANGE_COUNT, 0);
    }

    public void incrementPlayer9ChangeCount() {
        int player9ChangeCount = getPlayer9ChangeCount();
        Editor edit = this.mPrefs.edit();
        edit.putInt(PLAYER_9_CHANGE_COUNT, player9ChangeCount + 1);
        edit.commit();
    }

    public int getPlayer9ChangeCount() {
        return this.mPrefs.getInt(PLAYER_9_CHANGE_COUNT, 0);
    }

    public void setOtherPlayerIndex(int i) {
        getPlayer9ChangeCount();
        Editor edit = this.mPrefs.edit();
        edit.putInt(OTHER_PLAYER_INDEX, i);
        edit.commit();
    }

    public int getOtherPlayerIndex() {
        return this.mPrefs.getInt(OTHER_PLAYER_INDEX, 0);
    }

    public void setImgUrl(String str) {
        Editor edit = this.mPrefs.edit();
        edit.putString(IMG_URL, str);
        edit.commit();
    }

    public String getImgUrl() {
        return this.mPrefs.getString(IMG_URL, "");
    }
}
