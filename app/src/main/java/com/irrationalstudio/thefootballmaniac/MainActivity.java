package com.irrationalstudio.thefootballmaniac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
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
    private String action;

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

                    LeagueTableAsyncTask leagueTableAsyncTask = new LeagueTableAsyncTask(MainActivity.this);

                    switch ((int) id) {
                        case 0:
                            // 1. Bundesliga
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_BUNDESLIGA1);
                            MyApplication.setAction(ApplicationConstants.ACTION_BUNDESLIGA1);
                            break;

                        case 1:
                            // 2. Bundesliga
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_BUNDESLIGA2);
                            MyApplication.setAction(ApplicationConstants.ACTION_BUNDESLIGA2);
                            break;

                        case 2:
                            // Ligue 1
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_LIGE1);
                            MyApplication.setAction(ApplicationConstants.ACTION_LIGUE1);
                            break;

                        case 3:
                            // Ligue 2
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_LIGE2);
                            MyApplication.setAction(ApplicationConstants.ACTION_LIGUE2);
                            break;

                        case 4:
                            // Premier League
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_PREMIER_LEAGUE);
                            MyApplication.setAction(ApplicationConstants.ACTION_PREMIER_LEAGUE);
                            break;

                        case 5:
                            // Primera Division
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_PRIMERA_DIVISION);
                            MyApplication.setAction(ApplicationConstants.ACTION_PRIMERA_DIVISION);
                            break;

                        case 6:
                            // Segunda Division
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_SEGUNDADIVISION);
                            MyApplication.setAction(ApplicationConstants.ACTION_SEGUNDA_DIVISION);
                            break;

                        case 7:
                            // Serie A
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_SERIEA);
                            MyApplication.setAction(ApplicationConstants.ACTION_SERIE_A);
                            break;

                        case 8:
                            // Primeira Liga
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_PRIMEIRA_LIGA);
                            MyApplication.setAction(ApplicationConstants.ACTION_PRIMERA_LIGA);
                            break;

                        case 9:
                            // 3. Bundesliga
                            leagueTableAsyncTask.execute(ApplicationConstants.ID_BUNDESLIGA3);
                            MyApplication.setAction(ApplicationConstants.ACTION_BUNDESLIGA3);
                            break;

                        case 10:
                            // Eredivisie
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
}
