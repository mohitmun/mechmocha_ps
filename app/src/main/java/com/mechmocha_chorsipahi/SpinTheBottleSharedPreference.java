package com.mechmocha_chorsipahi;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpinTheBottleSharedPreference {
    public static final String FAVORITES = "Product_Favorite";
    public static final String FFAVORITES = "Product_Favorite";
    public static final String FPREFS_NAME = "PRODUCT_APP";
    public static final String PREFS_NAME = "PRODUCT_APP";

    public void saveFavorites(Context context, List<Integer> list) {
        Editor edit = context.getSharedPreferences("PRODUCT_APP", 0).edit();
        edit.putString("Product_Favorite", new Gson().toJson((Object) list));
        edit.commit();
    }

    public void addFavorite(Context context, Integer num) {
        ArrayList favorites = getFavorites(context);
        if (favorites == null) {
            favorites = new ArrayList();
        }
        favorites.add(num);
        saveFavorites(context, favorites);
    }

    public void removeFavorite(Context context, Integer num) {
        ArrayList favorites = getFavorites(context);
        if (favorites != null) {
            favorites.remove(num);
            saveFavorites(context, favorites);
        }
    }

    public ArrayList<Integer> getFavorites(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("PRODUCT_APP", 0);
        String str = "Product_Favorite";
        if (!sharedPreferences.contains(str)) {
            return null;
        }
        return new ArrayList<>(Arrays.asList((Integer[]) new Gson().fromJson(sharedPreferences.getString(str, null), Integer[].class)));
    }

    public void removeAllFavorite(Context context) {
        saveFavorites(context, new ArrayList());
    }

    public void saveFFavorites(Context context, List<Integer> list) {
        Editor edit = context.getSharedPreferences("PRODUCT_APP", 0).edit();
        edit.putString("Product_Favorite", new Gson().toJson((Object) list));
        edit.commit();
    }

    public void addFFavorite(Context context, Integer num) {
        ArrayList fFavorites = getFFavorites(context);
        if (fFavorites == null) {
            fFavorites = new ArrayList();
        }
        fFavorites.add(num);
        saveFFavorites(context, fFavorites);
    }

    public void removeFFavorite(Context context, Integer num) {
        ArrayList fFavorites = getFFavorites(context);
        if (fFavorites != null) {
            fFavorites.remove(num);
            saveFFavorites(context, fFavorites);
        }
    }

    public ArrayList<Integer> getFFavorites(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("PRODUCT_APP", 0);
        String str = "Product_Favorite";
        if (!sharedPreferences.contains(str)) {
            return null;
        }
        return new ArrayList<>(Arrays.asList((Integer[]) new Gson().fromJson(sharedPreferences.getString(str, null), Integer[].class)));
    }

    public void removeAllFFavorite(Context context) {
        saveFFavorites(context, new ArrayList());
    }
}
