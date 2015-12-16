package com.irrationalstudio.thefootballmaniac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.irrationalstudio.adapters.MyCustomAdapter;
import com.irrationalstudio.constants.ApplicationConstants;
import com.irrationalstudio.services.LeagueTableAsyncTask;
import com.irrationalstudio.util.InternetConnectivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new MyCustomAdapter(this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (InternetConnectivity.isConnected(getApplicationContext())) {

                    LeagueTableAsyncTask leagueTableAsyncTask = new LeagueTableAsyncTask();

                    switch ((int) id) {
                        case 0:
                            // Eredivisie
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_EREDIVISIE, getApplicationContext());
                            break;

                        case 1:
                            // 2. Bundesliga
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_BUNDESLIGA2, getApplicationContext());
                            break;

                        case 2:
                            // Champions League
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_CHAMPIONSLEAGE, getApplicationContext());
                            break;

                        case 3:
                            // Primera Division
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_PRIMERA_DIVISION, getApplicationContext());
                            break;

                        case 4:
                            // Ligue 1
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_LIGE1, getApplicationContext());
                            break;

                        case 5:
                            // 3. Bundesliga
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_BUNDESLIGA3, getApplicationContext());
                            break;

                        case 6:
                            // Serie A
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_SERIEA, getApplicationContext());
                            break;

                        case 7:
                            // 1. Bundesliga
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_BUNDESLIGA1, getApplicationContext());
                            break;

                        case 8:
                            // Premier League
                            leagueTableAsyncTask.execute(ApplicationConstants.PREMIER_LEAGUE, getApplicationContext());
                            break;

                        case 9:
                            // Segunda Division
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_SEGUNDADIVISION, getApplicationContext());
                            break;

                        case 10:
                            // Ligue 2
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_LIGE2, getApplicationContext());
                            break;

                        case 11:
                            // Primeira Liga
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_PRIMEIRA_LIGA, getApplicationContext());
                            break;
                    }
                } else {
                    Toast.makeText(getApplicationContext(), R.string.no_internet, Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
