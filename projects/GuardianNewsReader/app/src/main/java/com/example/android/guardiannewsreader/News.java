package com.example.android.guardiannewsreader;

public class News {

    // Private state members
    private String mNewsTitle;
    private String mNewsSection;
    private String mNewsPublishDate;
    private String mNewsAuthor;
    private String mNewsUrl;

    // Class constructor
    public News(String title, String section, String publishDate, String author, String url) {
        mNewsTitle = title;
        mNewsSection = section;
        mNewsPublishDate = publishDate;
        mNewsAuthor = author;
        mNewsUrl = url;
    }

    /**
     * Five Getter methods for the News class
     */

    public String getTitle() {
        return mNewsTitle;
    }

    public String getSection() {
        return mNewsSection;
    }

    public String getPublishDate() {
        return mNewsPublishDate;
    }

    public String getAuthor() {
        return mNewsAuthor;
    }

    public String getUrl() {
        return mNewsUrl;
    }
}
