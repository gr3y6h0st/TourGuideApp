package com.example.jay.tourguideapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.logging.Logger;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {

    @Override
    public Context getContext() {
        return super.getContext();
    }

    public RestaurantsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);
        //create ArrayList of Restaurant places
        final ArrayList<TourGuide> Restaurants = new ArrayList<TourGuide>();

        Restaurants.add(new TourGuide(getString(R.string.IchiranTitle), getString(R.string.Ichiran_Info), R.drawable.ichiran_restaurant));
        Restaurants.add(new TourGuide(getString(R.string.WonjoTitle), getString(R.string.WonjoInfo), R.drawable.wonjo_restaurant));
        Restaurants.add(new TourGuide(getString(R.string.JoesTitle), getString(R.string.JoesInfo), R.drawable.joes_pizza));
        Restaurants.add(new TourGuide(getString(R.string.HagiTitle), getString(R.string.HagiInfo), R.drawable.sake_bar_hagi));

        TourGuideAdapter adapter = new TourGuideAdapter(getActivity(), Restaurants);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        //sets onClickListener on each item, redirects users to respective Activity if clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id) {

                //gets position of current object, open corresponding activity
                switch (position){
                    case 0:
                        Intent ichiranInfoPage = new Intent(getActivity(), IchiranInfo.class);
                        startActivity(ichiranInfoPage);
                        break;
                    case 1:
                        Intent wonjoInfoPage = new Intent(getActivity(), NewWonjoInfo.class);
                        startActivity(wonjoInfoPage);
                        break;
                    case 2:
                        Intent joesInfoPage = new Intent(getActivity(), JoesPizzaInfo.class);
                        startActivity(joesInfoPage);
                        break;
                    case 3:
                        Intent hagiInfoPage = new Intent(getActivity(), HagiInfo.class);
                        startActivity(hagiInfoPage);
                        break;
                }
            }
        });
        return rootView;
    }

}
