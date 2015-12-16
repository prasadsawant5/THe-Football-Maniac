package com.irrationalstudio.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.irrationalstudio.constants.ApplicationConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Prasad on 12/12/2015.
 */
public class MySharedPreferences {


    public static void saveSeason(Context context, HashMap<String, String> hashMap) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(ApplicationConstants.SEASON_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            editor.putString(entry.getKey(), entry.getValue());
        }

        editor.apply();
    }

    public static ArrayList getSeason(Context context) {
        HashMap<String, String> hashMap = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();

        SharedPreferences sharedPreferences = context.getSharedPreferences(ApplicationConstants.SEASON_PREFERENCES, Context.MODE_PRIVATE);

        hashMap.put(ApplicationConstants.BUNDESLIGA1, sharedPreferences.getString(ApplicationConstants.BUNDESLIGA1, null));
        hashMap.put(ApplicationConstants.BUNDESLIGA2, sharedPreferences.getString(ApplicationConstants.BUNDESLIGA2, null));
        hashMap.put(ApplicationConstants.BUNDESLIGA3, sharedPreferences.getString(ApplicationConstants.BUNDESLIGA3, null));
        hashMap.put(ApplicationConstants.LIGUE1, sharedPreferences.getString(ApplicationConstants.LIGUE1, null));
        hashMap.put(ApplicationConstants.LIGUE2, sharedPreferences.getString(ApplicationConstants.LIGUE2, null));
        hashMap.put(ApplicationConstants.PREMIER_LEAGUE, sharedPreferences.getString(ApplicationConstants.PREMIER_LEAGUE, null));
        hashMap.put(ApplicationConstants.PRIMERA_DIVISION, sharedPreferences.getString(ApplicationConstants.PRIMERA_DIVISION, null));
        hashMap.put(ApplicationConstants.SEGUNDADIVISION, sharedPreferences.getString(ApplicationConstants.SEGUNDADIVISION, null));
        hashMap.put(ApplicationConstants.SERIEA, sharedPreferences.getString(ApplicationConstants.SERIEA, null));
        hashMap.put(ApplicationConstants.PRIMEIRA_LIGA, sharedPreferences.getString(ApplicationConstants.PRIMEIRA_LIGA, null));
        hashMap.put(ApplicationConstants.EREDIVISIE, sharedPreferences.getString(ApplicationConstants.EREDIVISIE, null));
        hashMap.put(ApplicationConstants.CHAMPIONSLEAGUE, sharedPreferences.getString(ApplicationConstants.CHAMPIONSLEAGUE, null));

        int i = 0;
        for (Map.Entry entry : hashMap.entrySet()) {
            arrayList.add(i, (String) entry.getValue());
            i++;
        }

        return arrayList;
    }

    public static void setSeasonInfo(Context context, String preferenceName, String key, String value) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(key, value);
        editor.apply();

    }

    public static String getSeasonInfo(Context context, String preferenceName, String key) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);

        return sharedPreferences.getString(key, null);
    }


}
