package com.example.nanodegree;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.nanodegree.adapter.WordAdapter;
import com.example.nanodegree.model.Numbers;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        final ArrayList<Numbers> numbers = new ArrayList<Numbers>();



        numbers.add(new Numbers("red","weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
        numbers.add(new Numbers("green","chokokki",R.drawable.color_green,R.raw.color_green));
        numbers.add(new Numbers("brown","ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        numbers.add(new Numbers("gray","ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        numbers.add(new Numbers("black","kululli",R.drawable.color_black,R.raw.color_black));
        numbers.add(new Numbers("white","kelelli",R.drawable.color_white,R.raw.color_white));
        numbers.add(new Numbers("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        numbers.add(new Numbers("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));


        LinearLayout rootView = findViewById(R.id.rootView_colors);

        WordAdapter itemsAdapter = new WordAdapter (this, numbers,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list_colors);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Numbers item = numbers.get(i);
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, item.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}