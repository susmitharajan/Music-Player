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


/**
 * A simple {@link Fragment} subclass.
 */
public class ArtistsFragment extends Fragment {


    ArrayList<String> albums = new ArrayList<>();

    List<Artists_DataModel> heroList = new ArrayList<>();

    ListView listView;


    public ArtistsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_artists, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        displayMusicAlbums(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        albums.size();

        listView = (ListView) getView().findViewById(R.id.listView);
        Artists_Adapter adapter = new Artists_Adapter(getContext(), R.layout.artist_custom_list, heroList);

        listView.setAdapter(adapter);
    }

    void displayMusicAlbums(Uri externalContentUri){
        String title,artists;
        ArrayList<String> albumlist = new ArrayList<>();

        Cursor cursor = getContext().getContentResolver().query(externalContentUri, null,null,
                null, null);

        if(cursor!=null && cursor.getCount() > 0){
            cursor.moveToFirst();
            do
            {
                title = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
                artists = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));

                if(!albums.contains(title))
                {
                    albums.add(title);
                    heroList.add(new Artists_DataModel(title,artists));
                }

            } while(cursor.moveToNext());
        }
    }
}
