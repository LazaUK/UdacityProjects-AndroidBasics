package com.example.android.samarkandcityguide;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    // Member state for the number of tabs in my UI
    private Context mContext;

    // Constructor of the class
    public PagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        mContext = context;
    }

    // Get relevant Java class for the selected tab:
    // 0 - Transport, 1 - Monuments, 2 - Food, 3 - Hotels
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TransportFragment();
            case 1:
                return new MonumentsFragment();
            case 2:
                return new FoodFragment();
            case 3:
                return new HotelsFragment();
            default:
                return null;
        }
    }

    // Get the number of tabs defined - in my case = 4
    @Override
    public int getCount() {
        return 4;
    }

    // Get relevant Strings for the selected tab titles:
    // 0 - Transport, 1 - Monuments, 2 - Food, 3 - Hotels
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.title_transport);
            case 1:
                return mContext.getString(R.string.title_monuments);
            case 2:
                return mContext.getString(R.string.title_food);
            case 3:
                return mContext.getString(R.string.title_hotels);
            default:
                return null;
        }
    }
}
