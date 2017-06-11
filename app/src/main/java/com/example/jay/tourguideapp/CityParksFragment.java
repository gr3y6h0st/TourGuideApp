package com.example.jay.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CityParksFragment extends Fragment {

    public CityParksFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);
        //create ArrayList of CityParks
        final ArrayList<TourGuide> CityParks = new ArrayList<TourGuide>();
        CityParks.add(new TourGuide("Central Park", R.drawable.central_park_manhattan));
        CityParks.add(new TourGuide("Brooklyn Bridge Park", R.drawable.brooklyn_bridge_park));
        CityParks.add(new TourGuide("The High Line Park", R.drawable.the_high_line_park));
        CityParks.add(new TourGuide("The Hills Park", R.drawable.the_hills_park));

        TourGuideAdapter adapter = new TourGuideAdapter(getActivity(), CityParks);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        //sets onClickListener on each item, redirects users to respective Activity if clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id) {

                //gets position of current object, open corresponding activity
                switch (position){
                    case 0:
                        Intent centralPark = new Intent(getActivity(), CentralParkInfo.class);
                        startActivity(centralPark);
                        break;
                    case 1:
                        Intent brooklynBridgePark = new Intent(getActivity(), BrooklynBridgeParkInfo.class);
                        startActivity(brooklynBridgePark);
                        break;
                    case 2:
                        Intent highLinePark = new Intent(getActivity(), HighLineParkInfo.class);
                        startActivity(highLinePark);
                        break;
                    case 3:
                        Intent hillsPark = new Intent(getActivity(), HillsParkInfo.class);
                        startActivity(hillsPark);
                        break;
                }
            }
        });
        return rootView;
    }
}
