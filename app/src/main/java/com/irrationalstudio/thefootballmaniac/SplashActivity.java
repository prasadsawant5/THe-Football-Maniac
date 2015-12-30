package com.irrationalstudio.thefootballmaniac;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.irrationalstudio.services.LeagueAsyncTask;
import com.irrationalstudio.util.InternetConnectivity;

/**
 * Created by harsh on 11-12-2015.
 */
public class SplashActivity extends Activity {

    private static final String TAG = SplashActivity.class.getName();
    private ImageView imageView;
    private Animation animation;
    private TextView tvLoading;
    private Typeface typeface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tvLoading = (TextView) findViewById(R.id.tv_loading);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/Aller_Rg.ttf");
        tvLoading.setTypeface(typeface);


        animation = AnimationUtils.loadAnimation(this, R.anim.rotate);

        imageView = (ImageView) findViewById(R.id.iv_football);
        imageView.startAnimation(animation);

        if (InternetConnectivity.isConnected(getApplicationContext())) {
            Log.d(TAG, "Starting service");
            LeagueAsyncTask leagueAsyncTask = new LeagueAsyncTask(SplashActivity.this);
            leagueAsyncTask.execute(getApplicationContext());
        } else {
            Toast.makeText(this, R.string.no_internet, Toast.LENGTH_LONG).show();
            android.os.Process.killProcess(android.os.Process.myPid());
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
