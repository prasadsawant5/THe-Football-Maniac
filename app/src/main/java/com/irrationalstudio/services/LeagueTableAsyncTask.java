package com.irrationalstudio.services;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
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

    public LeagueTableAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected Boolean doInBackground(Object... params) {
        Log.d(TAG, params[0].toString());

        if (HttpManager.instanceOf().isLeagueTableSaved(params[0].toString(), context))
            return true;

        return false;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        //super.onPostExecute(aBoolean);

        if (aBoolean) {
            Log.d(TAG, "true");

            Intent intent = new Intent(context, TabbedActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        }
        else {
            Log.d(TAG, "false");

            Toast toast = Toast.makeText(context, R.string.something_wrong, Toast.LENGTH_LONG);
            View view = toast.getView();
            view.setBackgroundResource(R.color.colorGreenLight);
            toast.show();

        }
    }
}
