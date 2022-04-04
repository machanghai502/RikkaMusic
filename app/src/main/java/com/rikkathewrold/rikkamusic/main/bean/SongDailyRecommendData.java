package com.rikkathewrold.rikkamusic.main.bean;

import java.util.List;

public class SongDailyRecommendData {

    private List<Song> songs;

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "SongDailyRecommendData{" +
                "songs=" + songs +
                '}';
    }
}
