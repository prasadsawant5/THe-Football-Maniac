package com.irrationalstudio.adapters;

import android.content.Context;
import android.graphics.Typeface;
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
 * Created by Prasad-Dekstop on 18-12-2015.
 */
public class LeagueTableCustomAdapter extends BaseAdapter {
    private Context context;
    private int length;
    private String preferenceName;
    private ArrayList<String> positions;
    private HashMap<String, String> teamCrest;
    private static final String TAG = LeagueTableCustomAdapter.class.getName();

    public LeagueTableCustomAdapter(Context context, String preferenceName, int length) {
        this.context = context;
        this.length = length;
        this.preferenceName = preferenceName;
        positions = MySharedPreferences.getLeagueTableInfo(context, this.preferenceName, this.length);
        teamCrest = MySharedPreferences.getTeamCrest(preferenceName);
    }

    @Override
    public int getCount() {
        return positions.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.league_table_row, parent, false);

        TextView tvTeamName = (TextView) row.findViewById(R.id.tv_team_name);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Aller_Rg.ttf");
        tvTeamName.setTypeface(typeface);

        ImageView ivTeamCrest = (ImageView) row.findViewById(R.id.iv_team_logo);

        //Log.d(TAG, positions.get(position));

        if ((teamCrest.size() != 0) && (teamCrest.get(positions.get(position)) != null))
            ivTeamCrest.setImageResource(Integer.parseInt(teamCrest.get(positions.get(position))));
        else
            ivTeamCrest.setImageResource(R.drawable.football);

        String title;
        if (positions.get(position).equals(ApplicationConstants.WURZBURGER_KICKERS))
            title = String.valueOf(position + 1) + ". " + ApplicationConstants.LIST_WURZBURGER_KICKERS;
        else
            title = String.valueOf(position + 1) + ". " + positions.get(position);

        tvTeamName.setText(title);


        return row;
    }
}
