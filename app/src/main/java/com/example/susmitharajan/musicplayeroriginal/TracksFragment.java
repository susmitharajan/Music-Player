package com.example.susmitharajan.musicplayeroriginal;


import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static java.sql.Types.DISTINCT;


/**
 * A simple {@link Fragment} subclass.
 */
public class TracksFragment extends Fragment {

    ArrayList<String> tracks = new ArrayList<>();

    List<Tracks_DataModel> heroList;

    //the listview
    ListView listView;


    public TracksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tracks, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        displayMusicAlbums(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        tracks.size();

        heroList = new ArrayList<>();

        listView = (ListView) getView().findViewById(R.id.listView);

        //adding some values to our list
        heroList.add(new Tracks_DataModel(R.drawable.nature, "Spiderman", "Avengers"));
        heroList.add(new Tracks_DataModel(R.drawable.nature, "Joker", "Injustice Gang"));
        heroList.add(new Tracks_DataModel(R.drawable.nature, "Iron Man", "Avengers"));
        heroList.add(new Tracks_DataModel(R.drawable.nature, "Doctor Strange", "Avengers"));
        heroList.add(new Tracks_DataModel(R.drawable.nature, "Captain America", "Avengers"));
        heroList.add(new Tracks_DataModel(R.drawable.nature, "Batman", "Justice League"));

        //creating the adapter
        Tracks_Adapter adapter = new Tracks_Adapter(getContext(), R.layout.track_custom_list, heroList);

        //attaching adapter to the listview
        listView.setAdapter(adapter);
    }

    void displayMusicAlbums(Uri externalContentUri){
        String cval;
        ArrayList<String> albumlist = new ArrayList<>();
        String selection = MediaStore.Audio.Media.IS_MUSIC + "!= 0";
        String sortOrder = MediaStore.Audio.Media.TITLE;
        String[] albums = {sortOrder};
        Cursor cursor=getActivity().getContentResolver().query(externalContentUri,  albums, selection, null, sortOrder);
        if(cursor!=null && cursor.getCount() > 0){
            cursor.moveToFirst();
            do
            {
                cval = cursor.getString(cursor.getColumnIndexOrThrow(sortOrder));
                tracks.add(cval);
            } while(cursor.moveToNext());
        }
    }
}
