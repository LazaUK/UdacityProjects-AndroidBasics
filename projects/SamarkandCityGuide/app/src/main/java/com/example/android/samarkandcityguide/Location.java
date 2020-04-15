package com.example.android.samarkandcityguide;

public class Location {

    // Private state members for the location name, description and pricing
    // Optionally, there is also a resource ID of the location's photo
    private String mLocationName = "";
    private String mLocationDescription = "";
    private String mLocationPricing = "";
    private int mLocationPhotoRID = 0;

    // My Location class' constructor
    public Location(String locationName, String locationDescription, String locationPricing, int locationPhotoRID) {
        mLocationName = locationName;
        mLocationDescription = locationDescription;
        mLocationPricing = locationPricing;
        mLocationPhotoRID = locationPhotoRID;
    }

    // 4 "getter" methods for the relevant state members
    public String getLocationName() {
        return mLocationName;
    }

    public String getLocationDescription() {
        return mLocationDescription;
    }

    public String getLocationPricing() {
        return mLocationPricing;
    }

    public int getLocationPhotoRID() {
        return mLocationPhotoRID;
    }
}
