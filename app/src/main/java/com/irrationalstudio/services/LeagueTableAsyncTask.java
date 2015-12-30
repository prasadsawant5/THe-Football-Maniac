package com.irrationalstudio.services;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.irrationalstudio.thefootballmaniac.R;
import com.irrationalstudio.thefootballmaniac.TabbedActivity;
import com.irrationalstudio.util.HttpManager;

/**
 * Created by Prasad-Dekstop on 16-12-2015.
 */
public class LeagueTableAsyncTask extends AsyncTask<Object, Void, Boolean> {

    private static final String TAG = LeagueTableAsyncTask.class.getName();
    private Context context;
    private ListView listView;
    private ImageView ivProgressBar;

    public LeagueTableAsyncTask(Context context, ListView listView, ImageView ivProgressBar) {
        this.context = context;
        this.listView = listView;
        this.ivProgressBar = ivProgressBar;
    }

    @Override
    protected Boolean doInBackground(Object... params) {

        if (HttpManager.instanceOf().isLeagueTableSaved(params[0].toString(), context))
            return true;

        return false;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        //super.onPostExecute(aBoolean);

        if (aBoolean) {

            ivProgressBar.clearAnimation();
            ivProgressBar.setVisibility(View.GONE);
            listView.setEnabled(true);

            Intent intent = new Intent(context, TabbedActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        }
        else {

            Toast toast = Toast.makeText(context, R.string.something_wrong, Toast.LENGTH_LONG);
            View view = toast.getView();
            view.setBackgroundResource(R.color.colorGreenLight);
            toast.show();

        }
    }
}
