package com.example.susmitharajan.musicplayeroriginal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by susmitharajan on 01/04/18.
 */

class Genres_Adapter extends ArrayAdapter<Genres_DataModel> {
    List<Genres_DataModel> heroList;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public Genres_Adapter(Context context, int resource, List<Genres_DataModel> heroList) {
        super(context, resource, heroList);
        this.context = context;
        this.resource = resource;
        this.heroList = heroList;
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewTeam = view.findViewById(R.id.textViewTeam);

        Genres_DataModel hero = heroList.get(position);

        //adding values to the list item
        textViewName.setText(hero.getName());
        textViewTeam.setText(hero.getTeam());

        //finally returning the view
        return view;
    }
}
