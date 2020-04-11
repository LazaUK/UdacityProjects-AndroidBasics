package com.example.android.eurovision2019;

public class Song {
    // Private state members to store Song Name, Artist Name and Country
    private String mSongName = "";
    private String mArtistName = "";
    private String mCountry = "";

    // My class' constructor
    public Song(String songName, String artistName, String country) {
        mSongName = songName;
        mArtistName = artistName;
        mCountry = country;
    }

    // Public method to retrieve Artist Name
    public String getArtistName() {
        return mArtistName;
    }

    // Public method to retrieve Country
    public String getCountry() {
        return mCountry;
    }

    // Public method to retrieve Song Name
    public String getSongName() {
        return mSongName;
    }
}