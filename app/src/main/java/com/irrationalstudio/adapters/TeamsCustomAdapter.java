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
import com.irrationalstudio.constants.ApplicationConstants;
import com.irrationalstudio.storage.MySharedPreferences;
import com.irrationalstudio.thefootballmaniac.R;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Prasad-Dekstop on 23-12-2015.
 */
public class TeamsCustomAdapter extends BaseAdapter {

    private int length;
    private Context context;
    private ArrayList<String> teams;
    private HashMap<String, String> teamCrest;
    private static final String TAG = TeamsCustomAdapter.class.getName();

    public TeamsCustomAdapter(Context context, String preferenceName, int length) {
        this.length = length;
        this.context = context;
        teams = MySharedPreferences.getTeams(this.context, preferenceName, this.length);
        teamCrest = MySharedPreferences.getTeamCrest(preferenceName);
    }

    @Override
    public int getCount() {
        return teams.size();
    }

    @Override
    public Object getItem(int position) {
        return teams.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.teams_row, parent, false);

        TextView tvTeamName = (TextView) row.findViewById(R.id.tv_teams);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Aller_Rg.ttf");
        tvTeamName.setTypeface(typeface);

        ImageView ivTeamCrest = (ImageView) row.findViewById(R.id.iv_team_logo);


        if ((teamCrest.size() != 0) && (teamCrest.get(teams.get(position)) != null))
            ivTeamCrest.setImageResource(Integer.parseInt(teamCrest.get(teams.get(position))));
        else
            ivTeamCrest.setImageResource(R.drawable.football);

        String title;
        if (teams.get(position).equals(ApplicationConstants.WURZBURGER_KICKERS))
            title = ApplicationConstants.LIST_WURZBURGER_KICKERS;
        else
            title = teams.get(position);

        tvTeamName.setText(title);
        return row;
    }
}
