package com.example.android.eurovision2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ArrayList with 2019 Eurovision finalist details
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Chameleon", "Michela", "Malta"));
        songs.add(new Song("Ktheju tokës", "Jonida Maliqi", "Albania"));
        songs.add(new Song("Friend of a Friend", "Lake Malawi", "Czech Republic"));
        songs.add(new Song("Sister", "S!sters", "Germany"));
        songs.add(new Song("Scream", "Sergey Lazarev", "Russia"));
        songs.add(new Song("Love Is Forever", "Leonora", "Denmark"));
        songs.add(new Song("Say Na Na Na", "Serhat", "San Marino"));
        songs.add(new Song("Proud", "Tamara Todevska", "North Macedonia"));
        songs.add(new Song("Too Late For Love", "John Lundvik", "Sweden"));
        songs.add(new Song("Sebi", "Zala Kralj & Gašper Šantl", "Slovenia"));
        songs.add(new Song("Replay", "Tamta", "Cyprus"));
        songs.add(new Song("Arcade", "Duncan Laurence", "The Netherlands"));
        songs.add(new Song("Better Love", "Katerine Duska", "Greece"));
        songs.add(new Song("Home", "Kobi Marimi", "Israel"));
        songs.add(new Song("Spirit in the Sky", "KEiiNO", "Norway"));
        songs.add(new Song("Bigger Than Us", "Michael Rice", "United Kingdom"));
        songs.add(new Song("Hatrið mun sigra", "Hatari", "Iceland"));
        songs.add(new Song("Storm", "Victor Crone", "Estonia"));
        songs.add(new Song("Like It", "ZENA", "Belarus"));
        songs.add(new Song("Truth", "Chingiz", "Azerbaijan"));
        songs.add(new Song("Roi", "Bilal Hassani", "France"));
        songs.add(new Song("Soldi", "Mahmood", "Italy"));
        songs.add(new Song("Kruna", "Nevena Božović", "Serbia"));
        songs.add(new Song("She Got Me", "Luca Hänni", "Switzerland"));
        songs.add(new Song("Zero Gravity", "Kate Miller-Heidke", "Australia"));
        songs.add(new Song("La Venda", "Miki", "Spain"));

        // Create an SongAdapter and use it to show Songs in the ListView
        SongAdapter adapter = new SongAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.songs_listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Retrieve details of selected item
                Song selectedItem = songs.get(position);
                String selectedSong = selectedItem.getSongName();
                String selectedArtist = selectedItem.getArtistName();
                String selectedCountry = selectedItem.getCountry();
                // Log.v("MainActivity", "Selected song is " + selectedSong +
                //        " by " + selectedArtist + " / " + selectedCountry);

                // Call activity to show playing song
                Intent intent = new Intent(getApplicationContext(),SongActivity.class);
                intent.putExtra("song", selectedSong);
                intent.putExtra("artist", selectedArtist);
                intent.putExtra("country", selectedCountry);
                startActivity(intent);
            }
        });

    }
}
