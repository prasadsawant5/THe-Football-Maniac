package com.irrationalstudio.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.irrationalstudio.constants.ApplicationConstants;
import com.irrationalstudio.constants.ServerConstants;
import com.irrationalstudio.storage.MySharedPreferences;
import com.irrationalstudio.thefootballmaniac.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.irrationalstudio.thefootballmaniac.R.string.bundesliga;

/**
 * Created by harsh on 11-12-2015.
 */
public class HttpManager {

    private static final String TAG = HttpManager.class.getName();
    private BufferedReader bufferedReader;
    private StringBuilder stringBuilder = new StringBuilder();
    private HashMap<String, String> seasonHashMap = new HashMap<>();

    public static HttpManager instanceOf() {
        return new HttpManager();
    }

    public boolean isSeasonSaved(Context context) {

        try {
            URL url = new URL(ServerConstants.URL + ServerConstants.SEASON);

            Log.d(TAG, url.toString());

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");

            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            stringBuilder.append("{ \"season\": ");

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            stringBuilder.append("}");

            Log.d(TAG, stringBuilder.toString());

            if (bufferedReader != null) {
                bufferedReader.close();
            }

            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("season");


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String season = object.getString(ApplicationConstants.SEASON);
                String totalTeams = object.getString(ApplicationConstants.NO_OF_TEAMS);
                String totalGames = object.getString(ApplicationConstants.NO_OF_GAMES);

                //if (i == 0 || i == 1 || i == 9)
                    //season = season.substring(3);

                if (season.contains(ApplicationConstants.bundesliga)) {
                    if (i == 0) {
                        seasonHashMap.put(ApplicationConstants.BUNDESLIGA1, season);
                        MySharedPreferences.setSeasonInfo(context, ApplicationConstants.BUNDESLIGA_1_PREFERENCES, ApplicationConstants.NO_OF_TEAMS, totalTeams);
                        MySharedPreferences.setSeasonInfo(context, ApplicationConstants.BUNDESLIGA_1_PREFERENCES, ApplicationConstants.NO_OF_GAMES, totalGames);
                    }
                    else if (i == 1) {
                        seasonHashMap.put(ApplicationConstants.BUNDESLIGA2, season);
                        MySharedPreferences.setSeasonInfo(context, ApplicationConstants.BUNDESLIGA_2_PREFERENCES, ApplicationConstants.NO_OF_TEAMS, totalTeams);
                        MySharedPreferences.setSeasonInfo(context, ApplicationConstants.BUNDESLIGA_2_PREFERENCES, ApplicationConstants.NO_OF_GAMES, totalGames);
                    }
                    else if (i == 9) {
                        seasonHashMap.put(ApplicationConstants.BUNDESLIGA3, season);
                        MySharedPreferences.setSeasonInfo(context, ApplicationConstants.BUNDESLIGA_3_PREFERENCES, ApplicationConstants.NO_OF_TEAMS, totalTeams);
                        MySharedPreferences.setSeasonInfo(context, ApplicationConstants.BUNDESLIGA_3_PREFERENCES, ApplicationConstants.NO_OF_GAMES, totalGames);
                    }

                } else if (season.contains(ApplicationConstants.ligue1)) {
                    seasonHashMap.put(ApplicationConstants.LIGUE1, season);
                    MySharedPreferences.setSeasonInfo(context, ApplicationConstants.LIGUE_1_PREFERENCES, ApplicationConstants.NO_OF_TEAMS, totalTeams);
                    MySharedPreferences.setSeasonInfo(context, ApplicationConstants.LIGUE_1_PREFERENCES, ApplicationConstants.NO_OF_GAMES, totalGames);

                } else if (season.contains(ApplicationConstants.ligue2)) {
                    seasonHashMap.put(ApplicationConstants.LIGUE2, season);
                    MySharedPreferences.setSeasonInfo(context, ApplicationConstants.LIGUE_2_PREFERENCES, ApplicationConstants.NO_OF_TEAMS, totalTeams);
                    MySharedPreferences.setSeasonInfo(context, ApplicationConstants.LIGUE_2_PREFERENCES, ApplicationConstants.NO_OF_GAMES, totalGames);

                } else if (season.contains(ApplicationConstants.premierLeague)) {
                    seasonHashMap.put(ApplicationConstants.PREMIER_LEAGUE, season);
                    MySharedPreferences.setSeasonInfo(context, ApplicationConstants.PREMIER_LEAGUE_PREFERENCES, ApplicationConstants.NO_OF_TEAMS, totalTeams);
                    MySharedPreferences.setSeasonInfo(context, ApplicationConstants.PREMIER_LEAGUE_PREFERENCES, ApplicationConstants.NO_OF_GAMES, totalGames);

                } else if (season.contains(ApplicationConstants.primeraDivision)) {
                    seasonHashMap.put(ApplicationConstants.PRIMERA_DIVISION, season);
                    MySharedPreferences.setSeasonInfo(context, ApplicationConstants.PRIMERA_DIVISION_PREFERENCES, ApplicationConstants.NO_OF_TEAMS, totalTeams);
                    MySharedPreferences.setSeasonInfo(context, ApplicationConstants.PRIMERA_DIVISION_PREFERENCES, ApplicationConstants.NO_OF_GAMES, totalGames);

                } else if (season.contains(ApplicationConstants.segundaDivision)) {
                    seasonHashMap.put(ApplicationConstants.SEGUNDADIVISION, season);
                    MySharedPreferences.setSeasonInfo(context, ApplicationConstants.SEGUNDA_DIVISION_PREFERENCES, ApplicationConstants.NO_OF_TEAMS, totalTeams);
                    MySharedPreferences.setSeasonInfo(context, ApplicationConstants.SEGUNDA_DIVISION_PREFERENCES, ApplicationConstants.NO_OF_GAMES, totalGames);

                } else if (season.contains(ApplicationConstants.serieA)) {
                    seasonHashMap.put(ApplicationConstants.SERIEA, season);
                    MySharedPreferences.setSeasonInfo(context, ApplicationConstants.SERIEA_PREFERENCES, ApplicationConstants.NO_OF_TEAMS, totalTeams);
                    MySharedPreferences.setSeasonInfo(context, ApplicationConstants.SERIEA_PREFERENCES, ApplicationConstants.NO_OF_GAMES, totalGames);

                } else if (season.contains(ApplicationConstants.primeraLiga)) {
                    seasonHashMap.put(ApplicationConstants.PRIMEIRA_LIGA, season);
                    MySharedPreferences.setSeasonInfo(context, ApplicationConstants.PRIMEIRA_LIGA_PREFERENCES, ApplicationConstants.NO_OF_TEAMS, totalTeams);
                    MySharedPreferences.setSeasonInfo(context, ApplicationConstants.PRIMEIRA_LIGA_PREFERENCES, ApplicationConstants.NO_OF_GAMES, totalGames);


                } else if (season.contains(ApplicationConstants.eredivisie)) {
                    seasonHashMap.put(ApplicationConstants.EREDIVISIE, season);
                    MySharedPreferences.setSeasonInfo(context, ApplicationConstants.EREDIVISIE_PREFERENCES, ApplicationConstants.NO_OF_TEAMS, totalTeams);
                    MySharedPreferences.setSeasonInfo(context, ApplicationConstants.EREDIVISIE_PREFERENCES, ApplicationConstants.NO_OF_GAMES, totalGames);

                } else {
                    seasonHashMap.put(ApplicationConstants.CHAMPIONSLEAGUE, season);
                    MySharedPreferences.setSeasonInfo(context, ApplicationConstants.CHAMPIONS_LEAGUE_PREFERENCES, ApplicationConstants.NO_OF_TEAMS, totalTeams);
                    MySharedPreferences.setSeasonInfo(context, ApplicationConstants.CHAMPIONS_LEAGUE_PREFERENCES , ApplicationConstants.NO_OF_GAMES, totalGames);

                }
            }

            MySharedPreferences.saveSeason(context, seasonHashMap);

            //Log.d(TAG, String.valueOf(httpURLConnection.getResponseCode()));

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isLeagueTableSaved(String id, Context context) {
        try {

            URL url = new URL(ServerConstants.URL + ServerConstants.LEAGUE_TABLE + id);
            Log.d(TAG, url.toString());

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");

            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            Log.d(TAG, stringBuilder.toString());

            if (bufferedReader != null) {
                bufferedReader.close();
            }

            if (stringBuilder.length() != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
