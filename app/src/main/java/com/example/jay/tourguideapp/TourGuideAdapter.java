package com.example.jay.tourguideapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Jay on 2/14/17.
 */

public class TourGuideAdapter extends ArrayAdapter<TourGuide> {

    public TourGuideAdapter(Context context, ArrayList<TourGuide> tours) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, tours);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the object located at this position in the list
        TourGuide currentAttraction = getItem(position);

        // Find the TextView in the list_item.xml layout with the description ID
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        // set this text on the name TextView
        descriptionTextView.setText(currentAttraction.getTourDescription());

        // Find the TextView in the list_item.xml layout with the ID hyperlink_text_view
        TextView hyperlinkTextView = (TextView) listItemView.findViewById(R.id.hyperlink_text_view);
        // set this text on the TextView
        hyperlinkTextView.setText(currentAttraction.getMoreInformation());

        ImageView imageResourceID = (ImageView) listItemView.findViewById(R.id.imageListView);

        if(currentAttraction.hasImage()) {
            //get image resource id if available and make it Visible.
            imageResourceID.setImageResource(currentAttraction.getImageResourceID());
            imageResourceID.setVisibility(View.VISIBLE);
        }
        else {
            //Otherwise set the visibility of the view to be hidden
            imageResourceID.setVisibility(View.GONE);
        }
        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
