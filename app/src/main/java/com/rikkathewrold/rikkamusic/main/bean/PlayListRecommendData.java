package com.rikkathewrold.rikkamusic.main.bean;


import java.util.List;

/**
 * 推荐歌单
 */
public class PlayListRecommendData {

    private List<PlayList> playLists;

    public List<PlayList> getPlayLists() {
        return playLists;
    }

    public void setPlayLists(List<PlayList> playLists) {
        this.playLists = playLists;
    }

    @Override
    public String toString() {
        return "PlayListRecommendData{" +
                "playLists=" + playLists +
                '}';
    }
}
