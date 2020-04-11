package com.example.android.eurovision2019;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    // SongAdapter's constructor
    public SongAdapter(@NonNull Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the item's position in the recycler view
        Song currentSong = getItem(position);
        final String currentSongName = currentSong.getSongName();
        final String currentArtistName = currentSong.getArtistName();
        final String currentCountry = currentSong.getCountry();

        // Set the value for the Song Name, Artist Name and Country
        TextView songTextView = (TextView) convertView.findViewById(R.id.song_name);
        songTextView.setText(currentSongName);
        TextView artistTextView = (TextView) convertView.findViewById(R.id.artist_name);
        artistTextView.setText("by " + currentArtistName);
        TextView countryTextView = (TextView) convertView.findViewById(R.id.country);
        countryTextView.setText(currentCountry);
        // ImageView countryIconView = (ImageView) listItemView.findViewById(R.id.country_icon);
        // countryIconView.setImageResource(currentSong.getCountryImageRId());

//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.v("ListView", "Selected song is " + currentSongName +
//                        " by " + currentArtistName + " / " + currentCountry);
//            }
//        });

        return convertView;
    }

}
