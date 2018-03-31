package com.example.susmitharajan.musicplayeroriginal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static com.example.susmitharajan.musicplayeroriginal.TabFragment.int_items;

/**
 * Created by susmitharajan on 31/03/18.
 */

public class MyAdapter extends FragmentPagerAdapter {
    public MyAdapter(FragmentManager fm)
    {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TracksFragment();
            case 1:
                return new AlbumsFragment();
            case 2:
                return new ArtistsFragment();
            case 3:
                return new GenresFragment();
            case 4:
                return new PlaylistsFragment();
            case 5:
                return new FoldersFragment();


        }
        return null;
    }

    @Override
    public int getCount() {
        return int_items;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "TRACKS";
            case 1:
                return "ALBUMS";
            case 2:
                return "ARTISTS";
            case 3:
                return "GENRES";
            case 4:
                return "PLAYLISTS";
            case 5:
                return "FOLDERS";
        }
        return null;
    }
}
