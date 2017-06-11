package com.example.jay.tourguideapp;

/**
 * Created by Jay on 2/14/17.
 */

public class TourGuide {
    /** Description for each location */
    private String mTourDescription;

    /**More information about the location Link*/
    private String mMoreInformation;

    /**Image associated with the current location*/
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    /**Image resource ID*/
    private static final int NO_IMAGE_PROVIDED = -1;

    public TourGuide(String tourDescription, String moreInformation) {
        mTourDescription = tourDescription;
        mMoreInformation = moreInformation;
    }

    public TourGuide(String tourDescription, int imageResourceID ) {
        mTourDescription = tourDescription;
        mImageResourceID = imageResourceID;
    }

    public TourGuide(String tourDescription, String moreInformation, int imageResourceID ) {
        mTourDescription = tourDescription;
        mMoreInformation = moreInformation;
        mImageResourceID = imageResourceID;
    }

    public String getTourDescription(){
        return mTourDescription;
    }

    public String getMoreInformation(){
        return mMoreInformation; //hyperlink to redirect user to open website
    }

    public int getImageResourceID(){
        return mImageResourceID;
    }

    public boolean hasImage(){
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }
}
