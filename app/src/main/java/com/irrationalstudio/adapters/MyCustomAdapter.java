package com.irrationalstudio.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.irrationalstudio.constants.ApplicationConstants;
import com.irrationalstudio.storage.MySharedPreferences;
import com.irrationalstudio.thefootballmaniac.MainActivity;
import com.irrationalstudio.thefootballmaniac.R;
import java.util.ArrayList;

/**
 * Created by harsh on 11-12-2015.
 */
public class MyCustomAdapter extends BaseAdapter {

    private Context context;
    private static  final String TAG = "MyCustomAdapter";
    private ArrayList<String> arrayList;

    public MyCustomAdapter(Context context) {

        Log.d(TAG, "MyCustomAdapter");
        this.context = context;

        arrayList = MySharedPreferences.getSeason(context);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        Log.d(TAG, String.valueOf(arrayList.get(position)));
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.main_list_rows, parent, false);
        TextView tvLeagueTitle = (TextView) row.findViewById(R.id.tv_league_title);
        TextView tvTeams = (TextView) row.findViewById(R.id.tv_league_teams);
        TextView tvGames = (TextView) row.findViewById(R.id.tv_league_games);
        ImageView ivLeagueLogo = (ImageView) row.findViewById(R.id.iv_league_logo);

        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Aller_Rg.ttf");
        tvLeagueTitle.setTypeface(typeface);
        tvTeams.setTypeface(typeface);
        tvGames.setTypeface(typeface);

        tvLeagueTitle.setText(arrayList.get(position));


        if (arrayList.get(position).contains(ApplicationConstants.json_bundesliga1)) {
            tvTeams.setText("Total number of teams: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.BUNDESLIGA_1_PREFERENCES, ApplicationConstants.NO_OF_TEAMS));
            tvGames.setText("Total number of games: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.BUNDESLIGA_1_PREFERENCES, ApplicationConstants.NO_OF_GAMES));
            ivLeagueLogo.setImageResource(R.drawable.bundesliga);

        } else if (arrayList.get(position).contains(ApplicationConstants.json_bundesliga2)) {
            tvTeams.setText("Total number of teams: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.BUNDESLIGA_2_PREFERENCES, ApplicationConstants.NO_OF_TEAMS));
            tvGames.setText("Total number of games: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.BUNDESLIGA_2_PREFERENCES, ApplicationConstants.NO_OF_GAMES));
            ivLeagueLogo.setImageResource(R.drawable.bundesliga);

        } else if (arrayList.get(position).contains(ApplicationConstants.json_bundesliga3)) {
            tvTeams.setText("Total number of teams: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.BUNDESLIGA_3_PREFERENCES, ApplicationConstants.NO_OF_TEAMS));
            tvGames.setText("Total number of games: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.BUNDESLIGA_3_PREFERENCES, ApplicationConstants.NO_OF_GAMES));
            ivLeagueLogo.setImageResource(R.drawable.bundesliga);

        } else if (arrayList.get(position).contains(ApplicationConstants.json_ligue1)) {
            tvTeams.setText("Total number of teams: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.LIGUE_1_PREFERENCES, ApplicationConstants.NO_OF_TEAMS));
            tvGames.setText("Total number of games: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.LIGUE_1_PREFERENCES, ApplicationConstants.NO_OF_GAMES));
            ivLeagueLogo.setImageResource(R.drawable.ligue1);

        } else if (arrayList.get(position).contains(ApplicationConstants.json_ligue2)) {
            tvTeams.setText("Total number of teams: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.LIGUE_2_PREFERENCES, ApplicationConstants.NO_OF_TEAMS));
            tvGames.setText("Total number of games: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.LIGUE_2_PREFERENCES, ApplicationConstants.NO_OF_GAMES));
            ivLeagueLogo.setImageResource(R.drawable.ligue2);

        } else if (arrayList.get(position).contains(ApplicationConstants.json_premierLeague)) {
            tvTeams.setText("Total number of teams: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.PREMIER_LEAGUE_PREFERENCES, ApplicationConstants.NO_OF_TEAMS));
            tvGames.setText("Total number of games: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.PREMIER_LEAGUE_PREFERENCES, ApplicationConstants.NO_OF_GAMES));
            ivLeagueLogo.setImageResource(R.drawable.premier_league);

        } else if (arrayList.get(position).contains(ApplicationConstants.json_primeraDivision)) {
            tvTeams.setText("Total number of teams: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.PRIMERA_DIVISION_PREFERENCES, ApplicationConstants.NO_OF_TEAMS));
            tvGames.setText("Total number of games: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.PRIMERA_DIVISION_PREFERENCES, ApplicationConstants.NO_OF_GAMES));
            ivLeagueLogo.setImageResource(R.drawable.laliga);

        } else if (arrayList.get(position).contains(ApplicationConstants.json_segundaDivision)) {
            tvTeams.setText("Total number of teams: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.SEGUNDA_DIVISION_PREFERENCES, ApplicationConstants.NO_OF_TEAMS));
            tvGames.setText("Total number of games: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.SEGUNDA_DIVISION_PREFERENCES, ApplicationConstants.NO_OF_GAMES));
            ivLeagueLogo.setImageResource(R.drawable.segunda);

        } else if (arrayList.get(position).contains(ApplicationConstants.json_serieA)) {
            tvTeams.setText("Total number of teams: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.SERIEA_PREFERENCES, ApplicationConstants.NO_OF_TEAMS));
            tvGames.setText("Total number of games: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.SERIEA_PREFERENCES, ApplicationConstants.NO_OF_GAMES));
            ivLeagueLogo.setImageResource(R.drawable.serie_a);

        } else if (arrayList.get(position).contains(ApplicationConstants.json_primeraLiga)) {
            tvTeams.setText("Total number of teams: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.PRIMEIRA_LIGA_PREFERENCES, ApplicationConstants.NO_OF_TEAMS));
            tvGames.setText("Total number of games: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.PRIMEIRA_LIGA_PREFERENCES, ApplicationConstants.NO_OF_GAMES));
            ivLeagueLogo.setImageResource(R.drawable.primeira_liga);

        } else if (arrayList.get(position).contains(ApplicationConstants.json_eredivisie)) {
            tvTeams.setText("Total number of teams: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.EREDIVISIE_PREFERENCES, ApplicationConstants.NO_OF_TEAMS));
            tvGames.setText("Total number of games: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.EREDIVISIE_PREFERENCES, ApplicationConstants.NO_OF_GAMES));
            ivLeagueLogo.setImageResource(R.drawable.eredivisie);
        } else {
            tvTeams.setText("Total number of teams: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.CHAMPIONS_LEAGUE_PREFERENCES, ApplicationConstants.NO_OF_TEAMS));
            tvGames.setText("Total number of games: " + MySharedPreferences.getSeasonInfo(context, ApplicationConstants.CHAMPIONS_LEAGUE_PREFERENCES, ApplicationConstants.NO_OF_GAMES));
            ivLeagueLogo.setImageResource(R.drawable.champions_league);
        }

        /*row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick()" + v.getId());
            }
        });*/


        return row;
    }



}
