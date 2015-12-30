package com.irrationalstudio.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.irrationalstudio.storage.MySharedPreferences;
import com.irrationalstudio.thefootballmaniac.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Prasad-Dekstop on 29-12-2015.
 */
public class FixturesCustomAdapter extends BaseAdapter {

    Context context;
    String preferenceName;
    int count;
    private ArrayList<String> homeTeamNames, homeGoals;
    private ArrayList<String> awayTeamNames, awayGoals;
    private HashMap<String, String> teamCrest;
    private final static String TAG = FixturesCustomAdapter.class.getName();

    public FixturesCustomAdapter(Context context, String preferenceName, int count) {
        this.context = context;
        this.preferenceName = preferenceName;
        this.count = count;

        homeTeamNames = MySharedPreferences.getHomeTeamNames(this.context, this.preferenceName, this.count);
        awayTeamNames = MySharedPreferences.getAwayTeamNames(this.context, this.preferenceName, this.count);

        homeGoals = MySharedPreferences.getHomeGoals(this.context, this.preferenceName, this.count);
        awayGoals = MySharedPreferences.getAwayGoals(this.context, this.preferenceName, this.count);

        teamCrest = MySharedPreferences.getTeamCrest(this.preferenceName);
    }

    @Override
    public int getCount() {
        return homeTeamNames.size();
    }

    @Override
    public Object getItem(int position) {
        return homeTeamNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.fixtures_layout, parent, false);

        TextView tvDash = (TextView) row.findViewById(R.id.tv_dash);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Aller_Rg.ttf");
        tvDash.setTypeface(typeface);

        if (((homeGoals.size() > position) && (homeGoals.get(position) != null)) && ((awayGoals.size() > position) && (awayGoals.get(position) != null))) {
            String dash = homeGoals.get(position) + " - " + awayGoals.get(position);
            tvDash.setText(dash);
        }

        ImageView ivHomeTeam = (ImageView) row.findViewById(R.id.iv_home_team);
        ImageView ivAwayTeam = (ImageView) row.findViewById(R.id.iv_away_team);

        ivHomeTeam.setImageResource(Integer.parseInt(teamCrest.get(homeTeamNames.get(position))));
        ivAwayTeam.setImageResource(Integer.parseInt(teamCrest.get(awayTeamNames.get(position))));

        return row;
    }
}
