package com.irrationalstudio.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.irrationalstudio.constants.ApplicationConstants;
import com.irrationalstudio.util.HttpManager;
import com.irrationalstudio.util.InternetConnectivity;

/**
 * Created by harsh on 11-12-2015.
 */
public class ServerService extends IntentService {

    private static final String TAG = ServerService.class.getName();


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public ServerService(String name) {
        super(name);
    }

    public ServerService() {
        super("ServerService");
    }

    public static void startSeasonInitialization(Context context) {
        Intent intent = new Intent(context, ServerService.class);
        intent.setAction(ApplicationConstants.ACTION_SEASON_INITIALIZE);

        Log.d(TAG, "Service started");
        context.startService(intent);
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();
            Log.d(TAG, action);

            if (action.equals(ApplicationConstants.ACTION_SEASON_INITIALIZE)) {
                getSeason();
            }
        }

    }

    public void getSeason() {

        Log.d(TAG, "getSeason");

        Intent intent = new Intent(ApplicationConstants.SEASON_INITIALIZATION_EVENT);

        if (InternetConnectivity.isConnected(getApplicationContext())) {

            if (HttpManager.instanceOf().isSeasonSaved(getApplicationContext())) {
                Log.d(TAG, "Success");
                intent.putExtra(ApplicationConstants.EXTRA_SEASON_INITIALIZE_STATE, ApplicationConstants.STATE_SEASON_INITIALIZE_SUCCESS);
            } else {
                Log.d(TAG, "Failure");
                intent.putExtra(ApplicationConstants.EXTRA_SEASON_INITIALIZE_STATE, ApplicationConstants.STATE_SEASON_INITIALIZE_FAIL);
            }
        }

        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

    }
}
