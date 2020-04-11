package com.example.android.eurovision2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        // Retrieve values passed with intent
        String dataSong = getIntent().getExtras().getString("song");
        String dataArtist = getIntent().getExtras().getString("artist");
        String dataCountry = getIntent().getExtras().getString("country");
        // Log.v("SongActivity", dataSong + " by " + dataArtist + " from " + dataCountry);

        // Set the values from the content extras
        TextView playingSongView = (TextView) findViewById(R.id.playing_song);
        playingSongView.setText(dataSong);
        TextView playingArtistView = (TextView) findViewById(R.id.playing_artist);
        playingArtistView.setText(dataArtist);
        TextView playingCountryView = (TextView) findViewById(R.id.playing_country);
        playingCountryView.setText(dataCountry);

        Button returnButton = (Button) findViewById(R.id.return_button);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
