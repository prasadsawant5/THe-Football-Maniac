package com.irrationalstudio.services;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.irrationalstudio.thefootballmaniac.MainActivity;
import com.irrationalstudio.util.HttpManager;

/**
 * Created by Prasad-Dekstop on 17-12-2015.
 */
public class LeagueAsyncTask extends AsyncTask<Object, Void, Boolean> {

    private static final String TAG = LeagueAsyncTask.class.getName();
    private Context context;

    public LeagueAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected Boolean doInBackground(Object... params) {
        //context = (Context) params[0];

        if (HttpManager.instanceOf().isSeasonSaved(context)) {
            Log.d(TAG, "Success");
            return true;
        } else {
            Log.d(TAG, "failure");
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);

        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if (aBoolean) {

            context.startActivity(new Intent(context, MainActivity.class));
        }
    }
}
