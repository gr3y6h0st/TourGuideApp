package com.example.jay.tourguideapp;

/**
 * Created by Jay on 4/11/17.
 */
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    /** Context of the app */
    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.city_parks_main);
        } else if (position == 1) {
            return mContext.getString(R.string.city_entertainment_main);
        } else if (position == 2) {
            return mContext.getString(R.string.city_artsCulture_main);
        } else {
            return mContext.getString(R.string.city_restaurants_main);
        }
    }
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new CityParksFragment();
        } else if (position == 1){
            return new EntertainmentFragment();
        } else if (position == 2) {
            return new ArtsAndCultureFragment();
        } else {
            return new RestaurantsFragment();
        }
    }
    @Override
    public int getCount() {
        return 4;
    }
}