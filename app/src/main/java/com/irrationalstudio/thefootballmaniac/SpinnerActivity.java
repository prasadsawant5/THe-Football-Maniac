package com.irrationalstudio.thefootballmaniac;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.irrationalstudio.constants.ApplicationConstants;
import com.irrationalstudio.services.ServerService;
import com.irrationalstudio.util.InternetConnectivity;

/**
 * Created by harsh on 11-12-2015.
 */
public class SpinnerActivity extends Activity {

    private static final String TAG = SpinnerActivity.class.getName();

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent != null) {
                final String action = intent.getStringExtra(ApplicationConstants.EXTRA_SEASON_INITIALIZE_STATE);

                Log.d(TAG, action);

                if (action.equals(ApplicationConstants.STATE_SEASON_INITIALIZE_SUCCESS)) {
                    Intent mainActivityIntent = new Intent(SpinnerActivity.this, MainActivity.class);
                    startActivity(mainActivityIntent);
                }
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_layout);

        Log.d(TAG, String.valueOf(InternetConnectivity.isConnected(getApplicationContext())));
        if (InternetConnectivity.isConnected(getApplicationContext())) {
            LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, new IntentFilter(ApplicationConstants.SEASON_INITIALIZATION_EVENT));
            Log.d(TAG, "Starting service");
            ServerService.startSeasonInitialization(this.getApplicationContext());
        } else {
            Toast.makeText(this, R.string.no_internet, Toast.LENGTH_LONG).show();
            android.os.Process.killProcess(android.os.Process.myPid());
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }

    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }
}
