package com.example.android.guardiannewsreader;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class QueryUtils {

    // Tag for log messages
    private static final String LOG_TAG = QueryUtils.class.getName();

    // String constants for the use in JSON hierarchy
    public static final String RESPONSE = "response";
    public static final String RESULTS = "results";
    public static final String WEB_TITLE = "webTitle";
    public static final String SECTION_NAME = "sectionName";
    public static final String PUBLISH_DATE = "webPublicationDate";
    public static final String REFERENCES = "references";
    public static final String WEB_URL = "webUrl";

    // String constants for the use in Error messages
    public static final String ERROR_NO_AUTHOR = "No author details provided";
    public static final String ERROR_JSON_PARSING = "Problem parsing the news JSON results.";
    public static final String ERROR_JSON_RETRIEVAL = "Problem retrieving the news JSON results.";
    public static final String ERROR_URL_BUILDING = "Problem building the URL.";
    public static final String ERROR_URL_RCODE = "URL response code: ";
    public static final String ERROR_HTTP_REQUEST = "Problem making the HTTP request.";

    // Private constructor
    private QueryUtils() {
    }

    // Return a list of News objects built up from parsing a JSON response.
    private static List<News> extractFeatureFromJson(String newsJSON) {

        // 2 seconds delay to show loading progress bar
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(newsJSON)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding news articles to
        List<News> news = new ArrayList<>();

        // Try to parse the JSON response string. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            // Create a JSONObject from the JSON response string
            JSONObject baseJsonResponse = new JSONObject(newsJSON);

            // Extract JSONObject, associated with the key called "response"
            JSONObject newsResponse = baseJsonResponse.getJSONObject(RESPONSE);

            // Extract JSONArray, associated with the key called "results"
            JSONArray newsArray = newsResponse.getJSONArray(RESULTS);

            // For each news in the newsArray, create an News object
            for (int i = 0; i < newsArray.length(); i++) {

                // Get a single news article at position i
                JSONObject currentNews = newsArray.getJSONObject(i);

                // Extract the values for the all required article details
                String title = currentNews.getString(WEB_TITLE);
                String section = currentNews.getString(SECTION_NAME);
                String date = currentNews.getString(PUBLISH_DATE);
                JSONArray authorArray = currentNews.getJSONArray(REFERENCES);
                String author;
                if (authorArray.length() < 1) {
                    author = ERROR_NO_AUTHOR;
                } else {
                    author = authorArray.getString(0);
                }
                String url = currentNews.getString(WEB_URL);

                // Create a new News object
                News newsArticle = new News(title, section, date, author, url);

                // Add the new News to the list of News.
                news.add(newsArticle);
            }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e(LOG_TAG, ERROR_JSON_PARSING, e);
        }

        // Return the list of earthquakes
        return news;
    }

    /**
     * Returns new URL object from the given string URL.
     */
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, ERROR_URL_BUILDING, e);
        }
        return url;
    }

    /**
     * Make an HTTP request to the given URL and return a String as the response.
     */
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, ERROR_URL_RCODE + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, ERROR_JSON_RETRIEVAL, e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Convert the InputStream into a String which contains JSON response from the server.
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    public static List<News> fetchNewsData(String requestUrl) {
        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, ERROR_HTTP_REQUEST, e);
        }

        // Extract relevant fields from the JSON response and create a list of {@link Earthquake}s
        List<News> news = extractFeatureFromJson(jsonResponse);

        // Return the list of {@link Earthquake}s
        return news;
    }
}
