package com.rikkathewrold.rikkamusic.search.bean;

import com.rikkathewrold.rikkamusic.main.bean.Song;

import java.util.List;

public class SongData {

    private List<Song> songs;

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "SongData{" +
                "songs=" + songs +
                '}';
    }
}
