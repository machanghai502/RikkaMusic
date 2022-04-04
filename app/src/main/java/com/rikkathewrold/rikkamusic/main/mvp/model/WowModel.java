package com.rikkathewrold.rikkamusic.main.mvp.model;

import com.rikkathewrold.rikkamusic.api.ApiEngine;
import com.rikkathewrold.rikkamusic.main.bean.BannerBean;
import com.rikkathewrold.rikkamusic.main.bean.DailyRecommendBean;
import com.rikkathewrold.rikkamusic.main.bean.HighQualityPlayListBean;
import com.rikkathewrold.rikkamusic.main.bean.MainRecommendPlayListBean;
import com.rikkathewrold.rikkamusic.main.bean.PlayList;
import com.rikkathewrold.rikkamusic.main.bean.PlayListRecommendData;
import com.rikkathewrold.rikkamusic.main.bean.PlaylistDetailBean;
import com.rikkathewrold.rikkamusic.main.bean.RecommendPlayListBean;
import com.rikkathewrold.rikkamusic.main.bean.SongDailyRecommendData;
import com.rikkathewrold.rikkamusic.main.bean.TopListBean;
import com.rikkathewrold.rikkamusic.main.mvp.contract.WowContract;
import com.rikkathewrold.rikkamusic.manager.bean.MusicCanPlayBean;

import io.reactivex.Observable;

public class WowModel implements WowContract.Model {
    @Override
    public Observable<BannerBean> getBanner() {
        return ApiEngine.getInstance().getApiService().getBanner("2");
    }

    @Override
    public Observable<PlayListRecommendData> getRecommendPlayList() {
        return ApiEngine.getInstance().getApiService().getRecommendPlayList();
    }

    @Override
    public Observable<SongDailyRecommendData> getDailyRecommend() {
        return ApiEngine.getInstance().getApiService().getDailyRecommend();
    }

    @Override
    public Observable<TopListBean> getTopList() {
        return ApiEngine.getInstance().getApiService().getTopList();
    }

    @Override
    public Observable<RecommendPlayListBean> getPlayList(String type, int limit) {
        return ApiEngine.getInstance().getApiService().getPlayList(type, limit);
    }

    @Override
    public Observable<PlaylistDetailBean> getPlaylistDetail(long id) {
        return ApiEngine.getInstance().getApiService().getPlaylistDetail(id);
    }

    @Override
    public Observable<MusicCanPlayBean> getMusicCanPlay(long id) {
        return ApiEngine.getInstance().getApiService().getMusicCanPlay(id);
    }

    @Override
    public Observable<HighQualityPlayListBean> getHighQuality(int limit, long before) {
        return ApiEngine.getInstance().getApiService().getHighquality(limit, before);
    }
}
