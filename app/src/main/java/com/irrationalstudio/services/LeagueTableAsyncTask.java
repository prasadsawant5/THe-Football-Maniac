package com.irrationalstudio.services;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.irrationalstudio.util.HttpManager;

/**
 * Created by Prasad-Dekstop on 16-12-2015.
 */
public class LeagueTableAsyncTask extends AsyncTask<Object, Void, Boolean> {

    private static final String TAG = LeagueTableAsyncTask.class.getName();


    @Override
    protected Boolean doInBackground(Object... params) {
        Log.d(TAG, params[0].toString());

        if (HttpManager.instanceOf().isLeagueTableSaved(params[0].toString(), (Context) params[1]))
            return true;
        else
            return false;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        //super.onPostExecute(aBoolean);

        if (aBoolean)
            Log.d(TAG, "true");
        else
            Log.d(TAG, "false");
    }
}
