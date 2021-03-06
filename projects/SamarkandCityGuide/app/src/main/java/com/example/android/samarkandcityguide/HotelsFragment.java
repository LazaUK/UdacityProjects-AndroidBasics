package com.example.android.samarkandcityguide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate ListView for locations
        View rootView = inflater.inflate(R.layout.locations_list, container, false);

        // Add Arraylist of locations
        ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.hotel_name_1), getString(R.string.hotel_descr_1),
                getString(R.string.hotel_price_1), R.drawable.baseline_hotel_black_24));
        locations.add(new Location(getString(R.string.hotel_name_2), getString(R.string.hotel_descr_2),
                getString(R.string.hotel_price_2), R.drawable.baseline_hotel_black_24));
        locations.add(new Location(getString(R.string.hotel_name_3), getString(R.string.hotel_descr_3),
                getString(R.string.hotel_price_3), R.drawable.baseline_hotel_black_24));
        locations.add(new Location(getString(R.string.hotel_name_4), getString(R.string.hotel_descr_4),
                getString(R.string.hotel_price_4), R.drawable.baseline_hotel_black_24));
        locations.add(new Location(getString(R.string.hotel_name_5), getString(R.string.hotel_descr_5),
                getString(R.string.hotel_price_5), R.drawable.baseline_hotel_black_24));
        locations.add(new Location(getString(R.string.hotel_name_6), getString(R.string.hotel_descr_6),
                getString(R.string.hotel_price_6), R.drawable.baseline_hotel_black_24));
        locations.add(new Location(getString(R.string.hotel_name_7), getString(R.string.hotel_descr_7),
                getString(R.string.hotel_price_7), R.drawable.baseline_hotel_black_24));

        // Create an LocationAdapter with the list of Locations and assign it to ListView
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Return our populated ListView
        return rootView;
    }
}
