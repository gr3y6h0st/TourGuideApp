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
public class ArtsAndCultureFragment extends Fragment {


    public ArtsAndCultureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list, container, false);
        //create ArrayList of ArtsAndCulture
        //create ArrayList of Artsy places
        final ArrayList<TourGuide> ArtsCulture = new ArrayList<TourGuide>();
        ArtsCulture.add(new TourGuide("Museum of Modern Art", R.drawable.museum_of_modern_art_image));
        ArtsCulture.add(new TourGuide("American Museum of Natural History", R.drawable.american_museum_of_natural_history_5));
        ArtsCulture.add(new TourGuide("Museum of Sex", R.drawable.museum_of_sex_1));
        ArtsCulture.add(new TourGuide("Metro Museum", R.drawable.metro_museum));


        TourGuideAdapter adapter = new TourGuideAdapter(getActivity(), ArtsCulture);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        //sets onClickListener on each item, redirects users to respective Activity if clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id) {

                //gets position of current object, open corresponding activity
                switch (position){
                    case 0:
                        Intent museumModernArt = new Intent(getActivity(), MuseumModernArtInfo.class);
                        startActivity(museumModernArt);
                        break;
                    case 1:
                        Intent americanMusuem = new Intent(getActivity(), AmericanMuseumInfo.class);
                        startActivity(americanMusuem);
                        break;
                    case 2:
                        Intent museumOfSex = new Intent(getActivity(), MuseumOfSexInfo.class);
                        startActivity(museumOfSex);
                        break;
                    case 3:
                        Intent metroMuseum = new Intent(getActivity(), MetroMuseumInfo.class);
                        startActivity(metroMuseum);
                        break;
                }

            }
        });

        return rootView;
    }

}