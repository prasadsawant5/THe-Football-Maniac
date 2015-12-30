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

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(ApplicationConstants.TIMEOUT);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");

            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            stringBuilder.append("{ \"season\": ");

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            stringBuilder.append("}");


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

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return true;
            }

            return false;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isLeagueTableSaved(String id, Context context) {
        try {

            URL url = new URL(ServerConstants.URL + ServerConstants.LEAGUE_TABLE + id);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setConnectTimeout(ApplicationConstants.TIMEOUT);

            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            String leagueCaption = jsonObject.getString(ApplicationConstants.LEAGUE_CAPTION);
            int matchday = jsonObject.getInt(ApplicationConstants.MATCHDAY);
            JSONArray jsonArray = jsonObject.getJSONArray(ApplicationConstants.STANDING);
            int length = jsonArray.length();


            if (leagueCaption.contains(ApplicationConstants.bundesliga1)) {
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.BUNDESLIGA_1_PREFERENCES, ApplicationConstants.MATCHDAY, String.valueOf(matchday));
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.BUNDESLIGA_1_PREFERENCES, ApplicationConstants.LENGTH, String.valueOf(length));
                HttpManager.instanceOf().isTeamSaved(id, context, ApplicationConstants.BUNDESLIGA_1_PREFERENCES);
                HttpManager.instanceOf().isFixturesSaved(id, context, ApplicationConstants.BUNDESLIGA_1_PREFERENCES);

                for (int i = 0; i < length; i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.BUNDESLIGA_1_PREFERENCES, ApplicationConstants.POSITION + String.valueOf(i), object.getString(ApplicationConstants.TEAM_NAME));
                }

            } else if (leagueCaption.contains(ApplicationConstants.bundesliga2)) {
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.BUNDESLIGA_2_PREFERENCES, ApplicationConstants.MATCHDAY, String.valueOf(matchday));
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.BUNDESLIGA_2_PREFERENCES, ApplicationConstants.LENGTH, String.valueOf(length));
                HttpManager.instanceOf().isTeamSaved(id, context, ApplicationConstants.BUNDESLIGA_2_PREFERENCES);
                HttpManager.instanceOf().isFixturesSaved(id, context, ApplicationConstants.BUNDESLIGA_2_PREFERENCES);

                for (int i = 0; i < length; i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.BUNDESLIGA_2_PREFERENCES, ApplicationConstants.POSITION + String.valueOf(i), object.getString(ApplicationConstants.TEAM_NAME));
                }
            } else if (leagueCaption.contains(ApplicationConstants.bundesliga3)) {
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.BUNDESLIGA_3_PREFERENCES, ApplicationConstants.MATCHDAY, String.valueOf(matchday));
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.BUNDESLIGA_3_PREFERENCES, ApplicationConstants.LENGTH, String.valueOf(length));
                HttpManager.instanceOf().isTeamSaved(id, context, ApplicationConstants.BUNDESLIGA_3_PREFERENCES);
                HttpManager.instanceOf().isFixturesSaved(id, context, ApplicationConstants.BUNDESLIGA_3_PREFERENCES);

                for (int i = 0; i < length; i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.BUNDESLIGA_3_PREFERENCES, ApplicationConstants.POSITION + String.valueOf(i), object.getString(ApplicationConstants.TEAM_NAME));
                }
            } else if (leagueCaption.contains(ApplicationConstants.ligue1)) {
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.LIGUE_1_PREFERENCES, ApplicationConstants.MATCHDAY, String.valueOf(matchday));
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.LIGUE_1_PREFERENCES, ApplicationConstants.LENGTH, String.valueOf(length));
                HttpManager.instanceOf().isTeamSaved(id, context, ApplicationConstants.LIGUE_1_PREFERENCES);
                HttpManager.instanceOf().isFixturesSaved(id, context, ApplicationConstants.LIGUE_1_PREFERENCES);

                for (int i = 0; i < length; i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.LIGUE_1_PREFERENCES, ApplicationConstants.POSITION + String.valueOf(i), object.getString(ApplicationConstants.TEAM_NAME));
                }
            } else if (leagueCaption.contains(ApplicationConstants.ligue2)) {
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.LIGUE_2_PREFERENCES, ApplicationConstants.MATCHDAY, String.valueOf(matchday));
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.LIGUE_2_PREFERENCES, ApplicationConstants.LENGTH, String.valueOf(length));
                HttpManager.instanceOf().isTeamSaved(id, context, ApplicationConstants.LIGUE_2_PREFERENCES);
                HttpManager.instanceOf().isFixturesSaved(id, context, ApplicationConstants.LIGUE_2_PREFERENCES);

                for (int i = 0; i < length; i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.LIGUE_2_PREFERENCES, ApplicationConstants.POSITION + String.valueOf(i), object.getString(ApplicationConstants.TEAM_NAME));
                }
            } else if (leagueCaption.contains(ApplicationConstants.premierLeague)) {
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.PREMIER_LEAGUE_PREFERENCES, ApplicationConstants.MATCHDAY, String.valueOf(matchday));
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.PREMIER_LEAGUE_PREFERENCES, ApplicationConstants.LENGTH, String.valueOf(length));
                HttpManager.instanceOf().isTeamSaved(id, context, ApplicationConstants.PREMIER_LEAGUE_PREFERENCES);
                HttpManager.instanceOf().isFixturesSaved(id, context, ApplicationConstants.PREMIER_LEAGUE_PREFERENCES);

                for (int i = 0; i < length; i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.PREMIER_LEAGUE_PREFERENCES, ApplicationConstants.POSITION + String.valueOf(i), object.getString(ApplicationConstants.TEAM_NAME));
                }
            } else if (leagueCaption.contains(ApplicationConstants.primeraDivision)) {
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.PRIMERA_DIVISION_PREFERENCES, ApplicationConstants.MATCHDAY, String.valueOf(matchday));
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.PRIMERA_DIVISION_PREFERENCES, ApplicationConstants.LENGTH, String.valueOf(length));
                HttpManager.instanceOf().isTeamSaved(id, context, ApplicationConstants.PRIMERA_DIVISION_PREFERENCES);
                HttpManager.instanceOf().isFixturesSaved(id, context, ApplicationConstants.PRIMERA_DIVISION_PREFERENCES);

                for (int i = 0; i < length; i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.PRIMERA_DIVISION_PREFERENCES, ApplicationConstants.POSITION + String.valueOf(i), object.getString(ApplicationConstants.TEAM_NAME));
                }
            } else if (leagueCaption.contains(ApplicationConstants.segundaDivision)) {
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.SEGUNDA_DIVISION_PREFERENCES, ApplicationConstants.MATCHDAY, String.valueOf(matchday));
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.SEGUNDA_DIVISION_PREFERENCES, ApplicationConstants.LENGTH, String.valueOf(length));
                HttpManager.instanceOf().isTeamSaved(id, context, ApplicationConstants.SEGUNDA_DIVISION_PREFERENCES);
                HttpManager.instanceOf().isFixturesSaved(id, context, ApplicationConstants.SEGUNDA_DIVISION_PREFERENCES);

                for (int i = 0; i < length; i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.SEGUNDA_DIVISION_PREFERENCES, ApplicationConstants.POSITION + String.valueOf(i), object.getString(ApplicationConstants.TEAM_NAME));
                }
            } else if (leagueCaption.contains(ApplicationConstants.serieA)) {
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.SERIEA_PREFERENCES, ApplicationConstants.MATCHDAY, String.valueOf(matchday));
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.SERIEA_PREFERENCES, ApplicationConstants.LENGTH, String.valueOf(length));
                HttpManager.instanceOf().isTeamSaved(id, context, ApplicationConstants.SERIEA_PREFERENCES);
                HttpManager.instanceOf().isFixturesSaved(id, context, ApplicationConstants.SERIEA_PREFERENCES);

                for (int i = 0; i < length; i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.SERIEA_PREFERENCES, ApplicationConstants.POSITION + String.valueOf(i), object.getString(ApplicationConstants.TEAM_NAME));
                }
            } else if (leagueCaption.contains(ApplicationConstants.primeraLiga)) {
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.PRIMEIRA_LIGA_PREFERENCES, ApplicationConstants.MATCHDAY, String.valueOf(matchday));
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.PRIMEIRA_LIGA_PREFERENCES, ApplicationConstants.LENGTH, String.valueOf(length));
                HttpManager.instanceOf().isTeamSaved(id, context, ApplicationConstants.PRIMEIRA_LIGA_PREFERENCES);
                HttpManager.instanceOf().isFixturesSaved(id, context, ApplicationConstants.PRIMEIRA_LIGA_PREFERENCES);

                for (int i = 0; i < length; i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.PRIMEIRA_LIGA_PREFERENCES, ApplicationConstants.POSITION + String.valueOf(i), object.getString(ApplicationConstants.TEAM_NAME));
                }
            } else {
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.EREDIVISIE_PREFERENCES, ApplicationConstants.MATCHDAY, String.valueOf(matchday));
                MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.EREDIVISIE_PREFERENCES, ApplicationConstants.LENGTH, String.valueOf(length));
                HttpManager.instanceOf().isTeamSaved(id, context, ApplicationConstants.EREDIVISIE_PREFERENCES);
                HttpManager.instanceOf().isFixturesSaved(id, context, ApplicationConstants.EREDIVISIE_PREFERENCES);

                for (int i = 0; i < length; i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    MySharedPreferences.setLeagueTableInfo(context, ApplicationConstants.EREDIVISIE_PREFERENCES, ApplicationConstants.POSITION + String.valueOf(i), object.getString(ApplicationConstants.TEAM_NAME));
                }
            }


            if (bufferedReader != null) {
                bufferedReader.close();
            }

            if (stringBuilder.length() != 0) {
                return true;
            }
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void isTeamSaved(String id, Context context, String preferenceName) {
        try {

            URL url = new URL(ServerConstants.URL + ServerConstants.TEAMS + id);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setConnectTimeout(ApplicationConstants.TIMEOUT);

            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            JSONArray jsonArray = jsonObject.getJSONArray(ApplicationConstants.TEAMS);
            int length = jsonArray.length();

            for (int i = 0; i < length; i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                MySharedPreferences.setTeams(context, preferenceName, ApplicationConstants.TEAM + String.valueOf(i), object.getString(ApplicationConstants.NAME));
            }

            if (bufferedReader != null) {
                bufferedReader.close();
            }


        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void isFixturesSaved(String id, Context context, String preferenceName) {
        try {

            URL url = new URL(ServerConstants.MAIN_URL + id + ServerConstants.FIXTURES + MySharedPreferences.getLeagueTableInfo(context, preferenceName, ApplicationConstants.MATCHDAY));

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setConnectTimeout(ApplicationConstants.TIMEOUT);

            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            JSONArray jsonArray = jsonObject.getJSONArray(ApplicationConstants.FIXTURES);

            int length = jsonObject.getInt(ApplicationConstants.COUNT);

            for (int i = 0; i < length; i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                MySharedPreferences.setFixtures(context, preferenceName, ApplicationConstants.FIXTURES_LENGTH, String.valueOf(length));
                MySharedPreferences.setFixtures(context, preferenceName, ApplicationConstants.HOME_TEAM_NAME + String.valueOf(i), object.getString(ApplicationConstants.HOME_TEAM_NAME));
                MySharedPreferences.setFixtures(context, preferenceName, ApplicationConstants.AWAY_TEAM_NAME + String.valueOf(i), object.getString(ApplicationConstants.AWAY_TEAM_NAME));

                if (object.getString(ApplicationConstants.STATUS).equals(ApplicationConstants.FINISHED)) {

                    JSONObject obj = object.getJSONObject(ApplicationConstants.RESULT);

                    MySharedPreferences.setFixtures(context, preferenceName, ApplicationConstants.GOALS_HOME_TEAM + String.valueOf(i), String.valueOf(obj.getInt(ApplicationConstants.GOALS_HOME_TEAM)));
                    MySharedPreferences.setFixtures(context, preferenceName, ApplicationConstants.GOALS_AWAY_TEAM + String.valueOf(i), String.valueOf(obj.getInt(ApplicationConstants.GOALS_AWAY_TEAM)));

                }
            }

            if (bufferedReader != null) {
                bufferedReader.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
