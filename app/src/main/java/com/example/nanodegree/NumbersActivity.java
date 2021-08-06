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

public class NumbersActivity extends AppCompatActivity {


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
        setContentView(R.layout.activity_numbers);

        final ArrayList<Numbers> numbers = new ArrayList<Numbers>();

        numbers.add(new Numbers("one","lutti",R.drawable.number_one,R.raw.number_one));
        numbers.add(new Numbers("two","otiiko",R.drawable.number_two,R.raw.number_two));
        numbers.add(new Numbers("three","tolookosu",R.drawable.number_three,R.raw.number_three));
        numbers.add(new Numbers("four","oyyisa",R.drawable.number_four,R.raw.number_four));
        numbers.add(new Numbers("five","massokka",R.drawable.number_five,R.raw.number_five));
        numbers.add(new Numbers("six","temmokka",R.drawable.number_six, R.raw.number_six));
        numbers.add(new Numbers("seven","kenekaku",R.drawable.number_seven, R.raw.number_seven));
        numbers.add(new Numbers("eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
        numbers.add(new Numbers("nine","wo'e",R.drawable.number_nine,R.raw.number_nine));
        numbers.add(new Numbers("ten","na'aacha",R.drawable.number_ten,R.raw.number_ten));

        LinearLayout rootView = findViewById(R.id.rootView);

        WordAdapter itemsAdapter = new WordAdapter (this, numbers,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list_numbers);


        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Numbers item = numbers.get(i);
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, item.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}