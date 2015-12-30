package com.irrationalstudio.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.irrationalstudio.adapters.LeagueTableCustomAdapter;
import com.irrationalstudio.application.MyApplication;
import com.irrationalstudio.constants.ApplicationConstants;
import com.irrationalstudio.storage.MySharedPreferences;
import com.irrationalstudio.thefootballmaniac.R;


public class LeagueTableFragment extends Fragment {

    private static final String TAG = LeagueTableFragment.class.getName();
    private ListView listView;
    //private OnFragmentInteractionListener mListener;

    public LeagueTableFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    // TODO: Rename and change types and number of parameters
    public static LeagueTableFragment newInstance() {
        LeagueTableFragment fragment = new LeagueTableFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_league_table, container, false);

        listView = (ListView) rootView.findViewById(R.id.listView2);


        if (MyApplication.getAction().equals(ApplicationConstants.ACTION_BUNDESLIGA1))
            listView.setAdapter(new LeagueTableCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.BUNDESLIGA_1_PREFERENCES, Integer.parseInt(MySharedPreferences.getLeagueTableInfo(getActivity().getApplicationContext(), ApplicationConstants.BUNDESLIGA_1_PREFERENCES, ApplicationConstants.LENGTH))));
        else if (MyApplication.getAction().equals(ApplicationConstants.ACTION_BUNDESLIGA2))
            listView.setAdapter(new LeagueTableCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.BUNDESLIGA_2_PREFERENCES, Integer.parseInt(MySharedPreferences.getLeagueTableInfo(getActivity().getApplicationContext(), ApplicationConstants.BUNDESLIGA_2_PREFERENCES, ApplicationConstants.LENGTH))));
        else if (MyApplication.getAction().equals(ApplicationConstants.ACTION_BUNDESLIGA3))
            listView.setAdapter(new LeagueTableCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.BUNDESLIGA_3_PREFERENCES, Integer.parseInt(MySharedPreferences.getLeagueTableInfo(getActivity().getApplicationContext(), ApplicationConstants.BUNDESLIGA_3_PREFERENCES, ApplicationConstants.LENGTH))));
        else if (MyApplication.getAction().equals(ApplicationConstants.ACTION_LIGUE1))
            listView.setAdapter(new LeagueTableCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.LIGUE_1_PREFERENCES, Integer.parseInt(MySharedPreferences.getLeagueTableInfo(getActivity().getApplicationContext(), ApplicationConstants.LIGUE_1_PREFERENCES, ApplicationConstants.LENGTH))));
        else if (MyApplication.getAction().equals(ApplicationConstants.ACTION_LIGUE2))
            listView.setAdapter(new LeagueTableCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.LIGUE_2_PREFERENCES, Integer.parseInt(MySharedPreferences.getLeagueTableInfo(getActivity().getApplicationContext(), ApplicationConstants.LIGUE_2_PREFERENCES, ApplicationConstants.LENGTH))));
        else if (MyApplication.getAction().equals(ApplicationConstants.ACTION_PREMIER_LEAGUE))
            listView.setAdapter(new LeagueTableCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.PREMIER_LEAGUE_PREFERENCES, Integer.parseInt(MySharedPreferences.getLeagueTableInfo(getActivity().getApplicationContext(), ApplicationConstants.PREMIER_LEAGUE_PREFERENCES, ApplicationConstants.LENGTH))));
        else if (MyApplication.getAction().equals(ApplicationConstants.ACTION_PRIMERA_DIVISION))
            listView.setAdapter(new LeagueTableCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.PRIMERA_DIVISION_PREFERENCES, Integer.parseInt(MySharedPreferences.getLeagueTableInfo(getActivity().getApplicationContext(), ApplicationConstants.PRIMERA_DIVISION_PREFERENCES, ApplicationConstants.LENGTH))));
        else if (MyApplication.getAction().equals(ApplicationConstants.ACTION_SEGUNDA_DIVISION))
            listView.setAdapter(new LeagueTableCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.SEGUNDA_DIVISION_PREFERENCES, Integer.parseInt(MySharedPreferences.getLeagueTableInfo(getActivity().getApplicationContext(), ApplicationConstants.SEGUNDA_DIVISION_PREFERENCES, ApplicationConstants.LENGTH))));
        else if (MyApplication.getAction().equals(ApplicationConstants.ACTION_SERIE_A))
            listView.setAdapter(new LeagueTableCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.SERIEA_PREFERENCES, Integer.parseInt(MySharedPreferences.getLeagueTableInfo(getActivity().getApplicationContext(), ApplicationConstants.SERIEA_PREFERENCES, ApplicationConstants.LENGTH))));
        else if (MyApplication.getAction().equals(ApplicationConstants.ACTION_PRIMERA_LIGA))
            listView.setAdapter(new LeagueTableCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.PRIMEIRA_LIGA_PREFERENCES, Integer.parseInt(MySharedPreferences.getLeagueTableInfo(getActivity().getApplicationContext(), ApplicationConstants.PRIMEIRA_LIGA_PREFERENCES, ApplicationConstants.LENGTH))));
        else
            listView.setAdapter(new LeagueTableCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.EREDIVISIE_PREFERENCES, Integer.parseInt(MySharedPreferences.getLeagueTableInfo(getActivity().getApplicationContext(), ApplicationConstants.EREDIVISIE_PREFERENCES, ApplicationConstants.LENGTH))));


        return rootView;
    }

    /*// TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /*public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
