package com.rikkathewrold.rikkamusic.main.mvp.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hjq.toast.ToastUtils;
import com.rikkathewrold.rikkamusic.App;
import com.rikkathewrold.rikkamusic.R;
import com.rikkathewrold.rikkamusic.base.BaseFragment;
import com.rikkathewrold.rikkamusic.dj.mvp.view.RadioRecommendActivity;
import com.rikkathewrold.rikkamusic.main.adapter.PlayListAdapter;
import com.rikkathewrold.rikkamusic.main.bean.BannerBean;
import com.rikkathewrold.rikkamusic.main.bean.DailyRecommendBean;
import com.rikkathewrold.rikkamusic.main.bean.HighQualityPlayListBean;
import com.rikkathewrold.rikkamusic.main.bean.MainRecommendPlayListBean;
import com.rikkathewrold.rikkamusic.main.bean.PlayList;
import com.rikkathewrold.rikkamusic.main.bean.PlayListRecommendData;
import com.rikkathewrold.rikkamusic.main.bean.PlaylistBean;
import com.rikkathewrold.rikkamusic.main.bean.PlaylistDetailBean;
import com.rikkathewrold.rikkamusic.main.bean.RecommendPlayListBean;
import com.rikkathewrold.rikkamusic.main.bean.SongDailyRecommendData;
import com.rikkathewrold.rikkamusic.main.bean.TopListBean;
import com.rikkathewrold.rikkamusic.main.mvp.contract.WowContract;
import com.rikkathewrold.rikkamusic.main.mvp.presenter.WowPresenter;
import com.rikkathewrold.rikkamusic.main.mvp.view.DailyRecommendActivity;
import com.rikkathewrold.rikkamusic.main.mvp.view.PlayListActivity;
import com.rikkathewrold.rikkamusic.main.mvp.view.PlayListRecommendActivity;
import com.rikkathewrold.rikkamusic.main.mvp.view.RankActivity;
import com.rikkathewrold.rikkamusic.manager.bean.MusicCanPlayBean;
import com.rikkathewrold.rikkamusic.util.BannerGlideImageLoader;
import com.rikkathewrold.rikkamusic.util.ClickUtil;
import com.rikkathewrold.rikkamusic.util.LogUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 发现
 */
public class WowFragment extends BaseFragment<WowPresenter> implements WowContract.View {
    private static final String TAG = "WowFragment";
    //歌单名称
    public static final String PLAYLIST_NAME = "playlistName";
    //歌单图片
    public static final String PLAYLIST_PICURL = "playlistPicUrl";
    //歌单创建者昵称
    public static final String PLAYLIST_CREATOR_NICKNAME = "playlistCreatorNickname";
    //歌单创建者头像
    public static final String PLAYLIST_CREATOR_AVATARURL = "playlistCreatorAvatarUrl";
    //歌单ID
    public static final String PLAYLIST_ID = "playlistId";

    //banner
    @BindView(R.id.wow_banner)
    Banner banner;

    //推荐歌单
    @BindView(R.id.rv_recommend_playlist)
    RecyclerView rvRecommendPlayList;

    private PlayListAdapter recommendPlayListAdapter;

    //banner的图片集合
    List<URL> bannerImageList = new ArrayList<>();

    //banner集合
    List<BannerBean.BannersBean> banners = new ArrayList<>();

    //推荐歌单集合
    List<PlayList> recommends = new ArrayList<>();

    //？？
    List<PlaylistBean> list = new ArrayList<>();

    public WowFragment() {
        setFragmentTitle(App.getContext().getString(R.string.wow));
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LogUtil.d(TAG, "initView  isPrepared：" + isPrepared() + " isFragmentVisible：" + isFragmentVisible());
        //获取所在的activity？
        View rootView = inflater.inflate(R.layout.fragment_wow, container, false);
        ButterKnife.bind(this, rootView);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setDelayTime(4000)
                .setImageLoader(new BannerGlideImageLoader())
                .isAutoPlay(true);
        return rootView;
    }


    @Override
    protected void initData() {
        LogUtil.d(TAG, "WowFragment initData");
        list.clear();
        //推荐歌单合集
        recommends.clear();
        recommendPlayListAdapter = new PlayListAdapter(getContext());
        recommendPlayListAdapter.setType(2);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        rvRecommendPlayList.setLayoutManager(manager);
        rvRecommendPlayList.setHasFixedSize(true);
        rvRecommendPlayList.setAdapter(recommendPlayListAdapter);
        showDialog();

        //从网络中获取banner信息
        mPresenter.getBanner();

        //从网络中获取推荐歌单
        mPresenter.getRecommendPlayList();
    }

    @Override
    public WowPresenter onCreatePresenter() {
        return new WowPresenter(this);
    }

    @Override
    protected void initVariables(Bundle bundle) {
    }


    //获取banner成功调用方法
    @Override
    public void onGetBannerSuccess(BannerBean bean) {
        LogUtil.d(TAG, "onGetBannerSuccess:" + bean);
        banners.addAll(bean.getBanners());
        loadImageToList();
        banner.setImages(bannerImageList).start();

        //banner点击事件
        banner.setOnBannerListener(position -> {
            ToastUtils.show("你以为轮播图可以点，但是我也找不到入口哒！");
        });

    }

    //将图片装到BannerList中
    private void loadImageToList() {
        for (int i = 0; i < banners.size(); i++) {
            try {
                URL url = new URL(banners.get(i).getPic());
                bannerImageList.add(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    /*@OnClick({R.id.rl_day_rec, R.id.rl_play_list, R.id.rl_rank, R.id.rl_radio, R.id.rl_live,
            R.id.tv_playlist_playground})*/
    //@OnClick({R.id.rl_day_rec, R.id.rl_play_list, R.id.rl_rank})
    @OnClick({R.id.rl_day_rec, R.id.rl_rank})
    public void onClick(View v) {
        if (ClickUtil.isFastClick(1000, v)) {
            return;
        }
        switch (v.getId()) {
            case R.id.rl_day_rec:
                //每日推荐
                startActivity(new Intent(activity, DailyRecommendActivity.class));
                break;
            /*case R.id.rl_play_list:
                //歌单
                startActivity(new Intent(activity, PlayListRecommendActivity.class));
                break;*/
            case R.id.rl_rank:
                //排行榜
                startActivity(new Intent(activity, RankActivity.class));
                break;
            /*case R.id.rl_radio:
                //电台
                startActivity(new Intent(activity, RadioRecommendActivity.class));
                break;
            case R.id.rl_live:
                //直播
                ToastUtils.show("没有提供直播接口哦，你想看我跳舞也行");
                break;
            case R.id.tv_playlist_playground:
                //歌单广场
                startActivity(new Intent(activity, PlayListRecommendActivity.class));
                break;*/
        }
    }

    @Override
    public void onGetBannerFail(String e) {
        ToastUtils.show(e);
        LogUtil.e(TAG, "onGetBannerFail : " + e);
    }

    /**
     * 获取推荐歌单成功调用的方法
     * @param playListRecommendData
     */
    @Override
    public void onGetRecommendPlayListSuccess(PlayListRecommendData playListRecommendData) {
        hideDialog();
        LogUtil.d(TAG, "onGetRecommendPlayListSuccess" + playListRecommendData);
        recommends.addAll(playListRecommendData.getPlayLists());
        for (int i = 0; i < recommends.size(); i++) {
            PlaylistBean beanInfo = new PlaylistBean();
            beanInfo.setPlaylistName(recommends.get(i).getTitle());
            beanInfo.setPlaylistCoverUrl(recommends.get(i).getPic());
            list.add(beanInfo);
        }
        recommendPlayListAdapter.setListener(listClickListener);
        recommendPlayListAdapter.notifyDataSetChanged(list);
    }

    //点击推荐列表事件处理
    private PlayListAdapter.OnPlayListClickListener listClickListener = position -> {
        if (recommends != null && !recommends.isEmpty()) {
            //进入歌单详情页面
            Intent intent = new Intent(getActivity(), PlayListActivity.class);
            PlayList playList = recommends.get(position);
            String playlistName = playList.getTitle();
            intent.putExtra(PLAYLIST_NAME, playlistName);
            String playlistPicUrl = playList.getPic();
            intent.putExtra(PLAYLIST_PICURL, playlistPicUrl);
            //todo
            //String playlistCreatorNickname = playList.getCreator().getNickname();
            String playlistCreatorNickname = "admin";
            intent.putExtra(PLAYLIST_CREATOR_NICKNAME, playlistCreatorNickname);
            //todo
            //String playlistCreatorAvatarUrl = bean.getCreator().getAvatarUrl();
            String playlistCreatorAvatarUrl = "https://p1.music.126.net/QWMV-Ru_6149AKe0mCBXKg==/1420569024374784.jpg";
            intent.putExtra(PLAYLIST_CREATOR_AVATARURL, playlistCreatorAvatarUrl);
            String playlistId = playList.getId();
            intent.putExtra(PLAYLIST_ID, playlistId);
            startActivity(intent);
        }
    };

    @Override
    public void onGetRecommendPlayListFail(String e) {
        hideDialog();
        ToastUtils.show(e);
        LogUtil.e(TAG, "onGetRecommendPlayListFail : " + e);
    }

    @Override
    public void onGetDailyRecommendSuccess(SongDailyRecommendData bean) {

    }

    @Override
    public void onGetDailyRecommendFail(String e) {

    }

    @Override
    public void onGetTopListSuccess(TopListBean bean) {

    }

    @Override
    public void onGetTopListFail(String e) {

    }

    @Override
    public void onGetPlayListSuccess(RecommendPlayListBean bean) {

    }

    @Override
    public void onGetPlayListFail(String e) {

    }

    @Override
    public void onGetPlaylistDetailSuccess(PlaylistDetailBean bean) {

    }

    @Override
    public void onGetPlaylistDetailFail(String e) {

    }

    @Override
    public void onGetMusicCanPlaySuccess(MusicCanPlayBean bean) {

    }

    @Override
    public void onGetMusicCanPlayFail(String e) {

    }

    @Override
    public void onGetHighQualitySuccess(HighQualityPlayListBean bean) {

    }

    @Override
    public void onGetHighQualityFail(String e) {

    }

}
