package com.mechmocha_chorsipahi;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class AppPreferences {
    private static final String CAT1 = "cat1";
    private static final String CAT10 = "cat10";
    private static final String CAT2 = "cat2";
    private static final String CAT3 = "cat3";
    private static final String CAT4 = "cat4";
    private static final String CAT5 = "cat5";
    private static final String CAT6 = "cat6";
    private static final String CAT7 = "cat7";
    private static final String CAT8 = "cat8";
    private static final String CAT9 = "cat9";
    private static final String IMG_URL = "IMG_URL";
    private static final String KISS_COUNT = "KISS_COUNT";
    private static final String PREF_APP_RATE = "pref_app_rate";
    private static final String PREF_LAUNCH_COUNT = "cat1";
    private static AppPreferences sInstance;
    private SharedPreferences mPrefs;

    private AppPreferences(Context context) {
        this.mPrefs = context.getSharedPreferences("app_prefs", 0);
    }

    public static AppPreferences getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new AppPreferences(context);
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
        return this.mPrefs.getInt("cat1", 0);
    }

    public void incrementLaunchCount() {
        int launchCount = getLaunchCount();
        Editor edit = this.mPrefs.edit();
        edit.putInt("cat1", launchCount + 1);
        edit.commit();
    }

    public void resetLaunchCount() {
        Editor edit = this.mPrefs.edit();
        edit.remove("cat1");
        edit.commit();
    }

    public void incrementEarnCount(int i) {
        int kissCount = getKissCount();
        Editor edit = this.mPrefs.edit();
        edit.putInt("cat1", kissCount + i);
        edit.commit();
    }

    public int getEarnCount() {
        return this.mPrefs.getInt("cat1", 0);
    }

    public void setImageUrl(String str) {
        Editor edit = this.mPrefs.edit();
        edit.putString(IMG_URL, str);
        edit.commit();
    }

    public String getImageUrl() {
        return this.mPrefs.getString(IMG_URL, "");
    }

    public void setKissCount(int i) {
        int kissCount = getKissCount();
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT, kissCount + i);
        edit.commit();
    }

    public void decreaseKissCount() {
        int kissCount = getKissCount();
        Editor edit = this.mPrefs.edit();
        edit.putInt(KISS_COUNT, kissCount - 1);
        edit.commit();
    }

    public int getKissCount() {
        return this.mPrefs.getInt(KISS_COUNT, 0);
    }

    public void incrementCat1Count() {
        int launchCat1Count = getLaunchCat1Count();
        Editor edit = this.mPrefs.edit();
        edit.putInt("cat1", launchCat1Count + 1);
        edit.commit();
    }

    public int getLaunchCat1Count() {
        return this.mPrefs.getInt("cat1", 0);
    }

    public void incrementCat2Count() {
        int launchCat2Count = getLaunchCat2Count();
        Editor edit = this.mPrefs.edit();
        edit.putInt(CAT2, launchCat2Count + 1);
        edit.commit();
    }

    public int getLaunchCat2Count() {
        return this.mPrefs.getInt(CAT2, 0);
    }

    public void incrementCat3Count() {
        int launchCat3Count = getLaunchCat3Count();
        Editor edit = this.mPrefs.edit();
        edit.putInt(CAT3, launchCat3Count + 1);
        edit.commit();
    }

    public int getLaunchCat3Count() {
        return this.mPrefs.getInt(CAT3, 0);
    }

    public void incrementCat4Count() {
        int launchCat4Count = getLaunchCat4Count();
        Editor edit = this.mPrefs.edit();
        edit.putInt(CAT4, launchCat4Count + 1);
        edit.commit();
    }

    public int getLaunchCat4Count() {
        return this.mPrefs.getInt(CAT4, 0);
    }

    public void incrementCat5Count() {
        int launchCat5Count = getLaunchCat5Count();
        Editor edit = this.mPrefs.edit();
        edit.putInt(CAT5, launchCat5Count + 1);
        edit.commit();
    }

    public int getLaunchCat5Count() {
        return this.mPrefs.getInt(CAT5, 0);
    }

    public void incrementCat6Count() {
        int launchCat6Count = getLaunchCat6Count();
        Editor edit = this.mPrefs.edit();
        edit.putInt(CAT6, launchCat6Count + 1);
        edit.commit();
    }

    public int getLaunchCat6Count() {
        return this.mPrefs.getInt(CAT6, 0);
    }

    public void incrementCat7Count() {
        int launchCat7Count = getLaunchCat7Count();
        Editor edit = this.mPrefs.edit();
        edit.putInt(CAT7, launchCat7Count + 1);
        edit.commit();
    }

    public int getLaunchCat7Count() {
        return this.mPrefs.getInt(CAT7, 0);
    }

    public void incrementCat8Count() {
        int launchCat8Count = getLaunchCat8Count();
        Editor edit = this.mPrefs.edit();
        edit.putInt(CAT8, launchCat8Count + 1);
        edit.commit();
    }

    public int getLaunchCat8Count() {
        return this.mPrefs.getInt(CAT8, 0);
    }

    public void incrementCat9Count() {
        int launchCat9Count = getLaunchCat9Count();
        Editor edit = this.mPrefs.edit();
        edit.putInt(CAT9, launchCat9Count + 1);
        edit.commit();
    }

    public int getLaunchCat9Count() {
        return this.mPrefs.getInt(CAT9, 0);
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
}
