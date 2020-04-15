package com.example.android.samarkandcityguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {
    public LocationAdapter(@NonNull Context context, ArrayList<Location> locations) {
        super(context, 0, locations);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Location currentLocation = getItem(position);

        TextView locationNameTextView = (TextView) listItemView.findViewById(R.id.location_name);
        locationNameTextView.setText(currentLocation.getLocationName());

        TextView locationDescriptionTextView = (TextView) listItemView.findViewById(R.id.location_description);
        locationDescriptionTextView.setText(currentLocation.getLocationDescription());

        TextView locationPricingTextView = (TextView) listItemView.findViewById(R.id.location_pricing);
        locationPricingTextView.setText(currentLocation.getLocationPricing());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        iconView.setImageResource(currentLocation.getLocationPhotoRID());

        return listItemView;
    }
}
