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

public class PhrasesActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_phrases);

        final ArrayList<Numbers> numbers = new ArrayList<Numbers>();

        numbers.add(new Numbers("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        numbers.add(new Numbers("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        numbers.add(new Numbers("My name is..","oyaaset...",R.raw.phrase_my_name_is));
        numbers.add(new Numbers("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
        numbers.add(new Numbers("I’m feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
        numbers.add(new Numbers("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
        numbers.add(new Numbers("Yes, I’m coming","hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        numbers.add(new Numbers("I’m coming.","әәnәm",R.raw.phrase_im_coming));
        numbers.add(new Numbers("Let's go.","yoowutis",R.raw.phrase_lets_go));
        numbers.add(new Numbers("Come here.","әnni'nem",R.raw.phrase_come_here));

        LinearLayout rootView = findViewById(R.id.rootView);

        WordAdapter itemsAdapter = new WordAdapter (this, numbers, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list_phrases);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Numbers item = numbers.get(i);
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, item.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}