package com.irrationalstudio.thefootballmaniac;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.irrationalstudio.adapters.MyCustomAdapter;
import com.irrationalstudio.application.MyApplication;
import com.irrationalstudio.constants.ApplicationConstants;
import com.irrationalstudio.services.LeagueTableAsyncTask;
import com.irrationalstudio.util.InternetConnectivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private ListView listView;
    private ImageView ivProgressBar;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivProgressBar = (ImageView) findViewById(R.id.iv_progress_bar);
        animation = AnimationUtils.loadAnimation(this, R.anim.rotate);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new MyCustomAdapter(this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (InternetConnectivity.isConnected(getApplicationContext())) {

                    LeagueTableAsyncTask leagueTableAsyncTask = new LeagueTableAsyncTask(MainActivity.this, listView, ivProgressBar);

                    switch ((int) id) {
                        case 0:
                            // 1. Bundesliga
                            listView.setEnabled(false);
                            ivProgressBar.startAnimation(animation);
                            ivProgressBar.setVisibility(View.VISIBLE);
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_BUNDESLIGA1);
                            MyApplication.setAction(ApplicationConstants.ACTION_BUNDESLIGA1);
                            break;

                        case 1:
                            // 2. Bundesliga
                            listView.setEnabled(false);
                            ivProgressBar.startAnimation(animation);
                            ivProgressBar.setVisibility(View.VISIBLE);
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_BUNDESLIGA2);
                            MyApplication.setAction(ApplicationConstants.ACTION_BUNDESLIGA2);
                            break;

                        case 2:
                            // Ligue 1
                            listView.setEnabled(false);
                            ivProgressBar.startAnimation(animation);
                            ivProgressBar.setVisibility(View.VISIBLE);
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_LIGE1);
                            MyApplication.setAction(ApplicationConstants.ACTION_LIGUE1);
                            break;

                        case 3:
                            // Ligue 2
                            listView.setEnabled(false);
                            ivProgressBar.startAnimation(animation);
                            ivProgressBar.setVisibility(View.VISIBLE);
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_LIGE2);
                            MyApplication.setAction(ApplicationConstants.ACTION_LIGUE2);
                            break;

                        case 4:
                            // Premier League
                            listView.setEnabled(false);
                            ivProgressBar.startAnimation(animation);
                            ivProgressBar.setVisibility(View.VISIBLE);
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_PREMIER_LEAGUE);
                            MyApplication.setAction(ApplicationConstants.ACTION_PREMIER_LEAGUE);
                            break;

                        case 5:
                            // Primera Division
                            listView.setEnabled(false);
                            ivProgressBar.startAnimation(animation);
                            ivProgressBar.setVisibility(View.VISIBLE);
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_PRIMERA_DIVISION);
                            MyApplication.setAction(ApplicationConstants.ACTION_PRIMERA_DIVISION);
                            break;

                        case 6:
                            // Segunda Division
                            listView.setEnabled(false);
                            ivProgressBar.startAnimation(animation);
                            ivProgressBar.setVisibility(View.VISIBLE);
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_SEGUNDADIVISION);
                            MyApplication.setAction(ApplicationConstants.ACTION_SEGUNDA_DIVISION);
                            break;

                        case 7:
                            // Serie A
                            listView.setEnabled(false);
                            ivProgressBar.startAnimation(animation);
                            ivProgressBar.setVisibility(View.VISIBLE);
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_SERIEA);
                            MyApplication.setAction(ApplicationConstants.ACTION_SERIE_A);
                            break;

                        case 8:
                            // Primeira Liga
                            listView.setEnabled(false);
                            ivProgressBar.startAnimation(animation);
                            ivProgressBar.setVisibility(View.VISIBLE);
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_PRIMEIRA_LIGA);
                            MyApplication.setAction(ApplicationConstants.ACTION_PRIMERA_LIGA);
                            break;

                        case 9:
                            // 3. Bundesliga
                            listView.setEnabled(false);
                            ivProgressBar.startAnimation(animation);
                            ivProgressBar.setVisibility(View.VISIBLE);
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_BUNDESLIGA3);
                            MyApplication.setAction(ApplicationConstants.ACTION_BUNDESLIGA3);
                            break;

                        case 10:
                            // Eredivisie
                            listView.setEnabled(false);
                            ivProgressBar.startAnimation(animation);
                            ivProgressBar.setVisibility(View.VISIBLE);
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_EREDIVISIE);
                            MyApplication.setAction(ApplicationConstants.ACTION_EREDIVISIE);
                            break;

                        case 11:
                            // Champions League
                            Toast toast = Toast.makeText(getApplication(), R.string.service_under_construction, Toast.LENGTH_LONG);
                            View v = toast.getView();
                            v.setBackgroundResource(R.color.colorGreenLight);
                            toast.show();
                            break;

                        default:
                            Toast toastNoService = Toast.makeText(getApplication(), R.string.something_wrong, Toast.LENGTH_LONG);
                            View toastView = toastNoService.getView();
                            toastView.setBackgroundResource(R.color.colorGreenLight);
                            toastNoService.show();
                            break;
                    }
                } else {
                    Toast toast = Toast.makeText(getApplication(), R.string.no_internet, Toast.LENGTH_LONG);
                    View v = toast.getView();
                    v.setBackgroundResource(R.color.colorGreenLight);
                    toast.show();
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;


        sharedPreferences = getApplicationContext().getSharedPreferences(ApplicationConstants.BUNDESLIGA_1_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.clear();
        editor.apply();


        sharedPreferences = getApplicationContext().getSharedPreferences(ApplicationConstants.BUNDESLIGA_2_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.clear();
        editor.apply();

        sharedPreferences = getApplicationContext().getSharedPreferences(ApplicationConstants.BUNDESLIGA_3_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.clear();
        editor.apply();



        sharedPreferences = getApplicationContext().getSharedPreferences(ApplicationConstants.LIGUE_1_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.clear();
        editor.apply();


        sharedPreferences = getApplicationContext().getSharedPreferences(ApplicationConstants.LIGUE_2_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.clear();
        editor.apply();


        sharedPreferences = getApplicationContext().getSharedPreferences(ApplicationConstants.PREMIER_LEAGUE_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.clear();
        editor.apply();


        sharedPreferences = getApplicationContext().getSharedPreferences(ApplicationConstants.PRIMERA_DIVISION_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.clear();
        editor.apply();

        sharedPreferences = getApplicationContext().getSharedPreferences(ApplicationConstants.SEGUNDA_DIVISION_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.clear();
        editor.apply();

        sharedPreferences = getApplicationContext().getSharedPreferences(ApplicationConstants.SERIEA_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.clear();
        editor.apply();

        sharedPreferences = getApplicationContext().getSharedPreferences(ApplicationConstants.PRIMEIRA_LIGA_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.clear();
        editor.apply();


        sharedPreferences = getApplicationContext().getSharedPreferences(ApplicationConstants.EREDIVISIE_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.clear();
        editor.apply();


        finish();
    }
}
