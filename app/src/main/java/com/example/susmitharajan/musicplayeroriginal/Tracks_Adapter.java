package com.example.susmitharajan.musicplayeroriginal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.susmitharajan.musicplayeroriginal.R;
import com.example.susmitharajan.musicplayeroriginal.Tracks_DataModel;

import java.util.List;

/**
 * Created by susmitharajan on 31/03/18.
 */

public class Tracks_Adapter extends ArrayAdapter<Tracks_DataModel> {
    List<Tracks_DataModel> heroList;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public Tracks_Adapter(Context context, int resource, List<Tracks_DataModel> heroList) {
        super(context, resource, heroList);
        this.context = context;
        this.resource = resource;
        this.heroList = heroList;
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(resource, null, false);

        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewTeam = view.findViewById(R.id.textViewTeam);

        Tracks_DataModel hero = heroList.get(position);

        textViewName.setText(hero.getName());
        textViewTeam.setText(hero.getTeam());
        return view;
    }
}
