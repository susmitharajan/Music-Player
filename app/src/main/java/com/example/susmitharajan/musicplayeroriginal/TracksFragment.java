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

    List<Tracks_DataModel> heroList = new ArrayList<>();

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



        listView = (ListView) getView().findViewById(R.id.listView);




        //adding some values to our list
        /*heroList.add(new Tracks_DataModel( "Spiderman", "Avengers"));
        heroList.add(new Tracks_DataModel( "Joker", "Injustice Gang"));
        heroList.add(new Tracks_DataModel( "Iron Man", "Avengers"));
        heroList.add(new Tracks_DataModel("Doctor Strange", "Avengers"));
        heroList.add(new Tracks_DataModel("Captain America", "Avengers"));
        heroList.add(new Tracks_DataModel( "Batman", "Justice League"));*/

        //creating the adapter
        Tracks_Adapter adapter = new Tracks_Adapter(getContext(), R.layout.track_custom_list, heroList);

        //attaching adapter to the listview
        listView.setAdapter(adapter);
    }

    void displayMusicAlbums(Uri externalContentUri){
        String title,artist;
        ArrayList<String> albumlist = new ArrayList<>();
        String selection = MediaStore.Audio.Media.IS_MUSIC + "!= 0";

       // String sortOrder = MediaStore.Audio.Media.TITLE;
       // String[] albums = {sortOrder};
      //  Cursor cursor=getActivity().getContentResolver().query(externalContentUri,  albums, selection, null, sortOrder);
        Cursor cursor=getActivity().getContentResolver().query(externalContentUri,  null, null, null, null);
        if(cursor!=null && cursor.getCount() > 0){
            cursor.moveToFirst();
            do
            {
                title = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
                artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
                heroList.add(new Tracks_DataModel(title,artist));
                tracks.add(title);
            } while(cursor.moveToNext());
        }
    }
}
