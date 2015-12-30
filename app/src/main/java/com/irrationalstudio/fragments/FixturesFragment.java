package com.irrationalstudio.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.irrationalstudio.adapters.FixturesCustomAdapter;
import com.irrationalstudio.adapters.LeagueTableCustomAdapter;
import com.irrationalstudio.application.MyApplication;
import com.irrationalstudio.constants.ApplicationConstants;
import com.irrationalstudio.storage.MySharedPreferences;
import com.irrationalstudio.thefootballmaniac.R;


public class FixturesFragment extends Fragment {

    private static final String TAG = FixturesFragment.class.getName();
    private ListView listView;

    //private OnFragmentInteractionListener mListener;

    public FixturesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    // TODO: Rename and change types and number of parameters
    public static FixturesFragment newInstance() {
        FixturesFragment fragment = new FixturesFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_fixtures, container, false);
        listView = (ListView) rootView.findViewById(R.id.listView3);


        if (MyApplication.getAction().equals(ApplicationConstants.ACTION_BUNDESLIGA1))
            listView.setAdapter(new FixturesCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.BUNDESLIGA_1_PREFERENCES, Integer.parseInt(MySharedPreferences.getFixturesLenght(getActivity().getApplicationContext(), ApplicationConstants.BUNDESLIGA_1_PREFERENCES, ApplicationConstants.FIXTURES_LENGTH))));
        else if (MyApplication.getAction().equals(ApplicationConstants.ACTION_BUNDESLIGA2))
            listView.setAdapter(new FixturesCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.BUNDESLIGA_2_PREFERENCES, Integer.parseInt(MySharedPreferences.getFixturesLenght(getActivity().getApplicationContext(), ApplicationConstants.BUNDESLIGA_2_PREFERENCES, ApplicationConstants.FIXTURES_LENGTH))));
        else if (MyApplication.getAction().equals(ApplicationConstants.ACTION_BUNDESLIGA3))
            listView.setAdapter(new FixturesCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.BUNDESLIGA_3_PREFERENCES, Integer.parseInt(MySharedPreferences.getFixturesLenght(getActivity().getApplicationContext(), ApplicationConstants.BUNDESLIGA_3_PREFERENCES, ApplicationConstants.FIXTURES_LENGTH))));
        else if (MyApplication.getAction().equals(ApplicationConstants.ACTION_LIGUE1))
            listView.setAdapter(new FixturesCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.LIGUE_1_PREFERENCES, Integer.parseInt(MySharedPreferences.getFixturesLenght(getActivity().getApplicationContext(), ApplicationConstants.LIGUE_1_PREFERENCES, ApplicationConstants.FIXTURES_LENGTH))));
        else if (MyApplication.getAction().equals(ApplicationConstants.ACTION_LIGUE2))
            listView.setAdapter(new FixturesCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.LIGUE_2_PREFERENCES, Integer.parseInt(MySharedPreferences.getFixturesLenght(getActivity().getApplicationContext(), ApplicationConstants.LIGUE_2_PREFERENCES, ApplicationConstants.FIXTURES_LENGTH))));
        else if (MyApplication.getAction().equals(ApplicationConstants.ACTION_PREMIER_LEAGUE))
            listView.setAdapter(new FixturesCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.PREMIER_LEAGUE_PREFERENCES, Integer.parseInt(MySharedPreferences.getFixturesLenght(getActivity().getApplicationContext(), ApplicationConstants.PREMIER_LEAGUE_PREFERENCES, ApplicationConstants.FIXTURES_LENGTH))));
        else if (MyApplication.getAction().equals(ApplicationConstants.ACTION_PRIMERA_DIVISION))
            listView.setAdapter(new FixturesCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.PRIMERA_DIVISION_PREFERENCES, Integer.parseInt(MySharedPreferences.getFixturesLenght(getActivity().getApplicationContext(), ApplicationConstants.PRIMERA_DIVISION_PREFERENCES, ApplicationConstants.FIXTURES_LENGTH))));
        else if (MyApplication.getAction().equals(ApplicationConstants.ACTION_SEGUNDA_DIVISION))
            listView.setAdapter(new FixturesCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.SEGUNDA_DIVISION_PREFERENCES, Integer.parseInt(MySharedPreferences.getFixturesLenght(getActivity().getApplicationContext(), ApplicationConstants.SEGUNDA_DIVISION_PREFERENCES, ApplicationConstants.FIXTURES_LENGTH))));
        else if (MyApplication.getAction().equals(ApplicationConstants.ACTION_SERIE_A))
            listView.setAdapter(new FixturesCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.SERIEA_PREFERENCES, Integer.parseInt(MySharedPreferences.getFixturesLenght(getActivity().getApplicationContext(), ApplicationConstants.SERIEA_PREFERENCES, ApplicationConstants.FIXTURES_LENGTH))));
        else if (MyApplication.getAction().equals(ApplicationConstants.ACTION_PRIMERA_LIGA))
            listView.setAdapter(new FixturesCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.PRIMEIRA_LIGA_PREFERENCES, Integer.parseInt(MySharedPreferences.getFixturesLenght(getActivity().getApplicationContext(), ApplicationConstants.PRIMEIRA_LIGA_PREFERENCES, ApplicationConstants.FIXTURES_LENGTH))));
        else
            listView.setAdapter(new FixturesCustomAdapter(getActivity().getApplicationContext(), ApplicationConstants.EREDIVISIE_PREFERENCES, Integer.parseInt(MySharedPreferences.getFixturesLenght(getActivity().getApplicationContext(), ApplicationConstants.EREDIVISIE_PREFERENCES, ApplicationConstants.FIXTURES_LENGTH))));

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
