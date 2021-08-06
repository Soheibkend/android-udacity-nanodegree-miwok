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

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

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
        setContentView(R.layout.activity_family);

        final ArrayList<Numbers> numbers = new ArrayList<Numbers>();

        numbers.add(new Numbers("father","әpә",R.drawable.family_father,R.raw.family_father));
        numbers.add(new Numbers("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        numbers.add(new Numbers("son","angsi",R.drawable.family_son,R.raw.family_son));
        numbers.add(new Numbers("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        numbers.add(new Numbers("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        numbers.add(new Numbers("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_sister));
        numbers.add(new Numbers("older sister", "teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        numbers.add(new Numbers("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        numbers.add(new Numbers("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        numbers.add(new Numbers("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));

        LinearLayout rootView = findViewById(R.id.rootView);

        WordAdapter itemsAdapter = new WordAdapter (this, numbers,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list_family);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Numbers item = numbers.get(i);
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, item.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}