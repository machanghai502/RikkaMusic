package com.rikkathewrold.rikkamusic.main.bean;

import java.util.List;

/**
 * 用户喜欢歌曲data实体
 */
public class UserLikeData {

    /**
     * 歌曲id列表
     */
    private List<Long> songIdList;

    public List<Long> getSongIdList() {
        return songIdList;
    }

    public void setSongIdList(List<Long> songIdList) {
        this.songIdList = songIdList;
    }

    @Override
    public String toString() {
        return "UserLikeData{" +
                "songIdList=" + songIdList +
                '}';
    }
}
