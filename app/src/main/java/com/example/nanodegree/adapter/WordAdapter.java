package com.example.nanodegree.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.nanodegree.R;
import com.example.nanodegree.model.Numbers;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter <Numbers> {

    private int color;

    public WordAdapter(Activity context, ArrayList<Numbers> numbers, int color) {
        super(context, 0, numbers);
        this.color = color;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Numbers currentNumbers = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        englishTextView.setText(currentNumbers.getEnglishTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        miwokTextView.setText(currentNumbers.getMiwokTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);


        if (currentNumbers.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentNumbers.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text);

        int color = ContextCompat.getColor(getContext(), this.color);
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
