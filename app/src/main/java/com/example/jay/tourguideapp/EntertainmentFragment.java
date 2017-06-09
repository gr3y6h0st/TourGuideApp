package com.example.jay.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntertainmentFragment extends Fragment {


    public EntertainmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);
        //create ArrayList of Entertainment places
        final ArrayList<TourGuide> Entertainment = new ArrayList<TourGuide>();

        Entertainment.add(new TourGuide("Times Square", R.drawable.times_squar));
        Entertainment.add(new TourGuide("Statue of Liberty", R.drawable.statute_liberty));
        Entertainment.add(new TourGuide("Empire State Building", R.drawable.empire_state_bldg));
        Entertainment.add(new TourGuide("Brooklyn Bridge", R.drawable.brooklyn_bridge));

        TourGuideAdapter adapter = new TourGuideAdapter(getActivity(), Entertainment);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        //sets onClickListener on each item, redirects users to respective Activity if clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id) {

                //gets position of current object, open corresponding activity
                switch (position){
                    case 0:
                        Intent timesSquare = new Intent(getActivity(), TimesSquareInfo.class);
                        startActivity(timesSquare);
                        break;
                    case 1:
                        Intent statueLiberty = new Intent(getActivity(), StatueLibertyInfo.class);
                        startActivity(statueLiberty);
                        break;
                    case 2:
                        Intent empireState = new Intent(getActivity(), EmpireStateInfo.class);
                        startActivity(empireState);
                        break;
                    case 3:
                        Intent brooklynBridge = new Intent(getActivity(), BrooklynBridgeInfo.class);
                        startActivity(brooklynBridge);
                        break;
                }

            }
        });

        return rootView;
    }

}
