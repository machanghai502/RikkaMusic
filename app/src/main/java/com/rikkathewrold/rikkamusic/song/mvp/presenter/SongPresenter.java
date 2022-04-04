package com.rikkathewrold.rikkamusic.song.mvp.presenter;


import com.rikkathewrold.rikkamusic.main.bean.LikeListBean;
import com.rikkathewrold.rikkamusic.main.bean.Song;
import com.rikkathewrold.rikkamusic.main.bean.UserLikeData;
import com.rikkathewrold.rikkamusic.song.bean.CommentLikeBean;
import com.rikkathewrold.rikkamusic.song.bean.LikeMusicBean;
import com.rikkathewrold.rikkamusic.song.bean.LyricBean;
import com.rikkathewrold.rikkamusic.song.bean.MusicCommentBean;
import com.rikkathewrold.rikkamusic.song.bean.PlayListCommentBean;
import com.rikkathewrold.rikkamusic.song.bean.SongDetailBean;
import com.rikkathewrold.rikkamusic.song.mvp.contract.SongContract;
import com.rikkathewrold.rikkamusic.song.mvp.model.SongModel;
import com.rikkathewrold.rikkamusic.util.LogUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SongPresenter extends SongContract.Presenter {
    private static final String TAG = "SongPresenter";

    public SongPresenter(SongContract.View view) {
        this.mView = view;
        this.mModel = new SongModel();
    }

    @Override
    public void getSongDetail(long songId) {
        mModel.getSongDetail(songId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Song>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        LogUtil.d(TAG, "onSubscribe");
                    }

                    @Override
                    public void onNext(Song bean) {
                        LogUtil.d(TAG, "onNext :" + bean);
                        mView.onGetSongDetailSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e(TAG, "onError : " + e.getLocalizedMessage());
                        mView.onGetSongDetailFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.d(TAG, "onComplete");
                    }
                });
    }


    /**
     * 喜欢或者取消喜欢接口
     * @param songId
     */
    @Override
    public void likeOrUnLikeMusic(long songId, long uid) {
        mModel.likeOrUnLikeMusic(songId, uid).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        LogUtil.d(TAG, "onSubscribe");
                    }

                    @Override
                    public void onNext(Boolean bean) {
                        LogUtil.d(TAG, "onNext :" + bean);
                        mView.onLikeOrUnLikeMusicSuccess(bean, String.valueOf(songId));
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e(TAG, "onError :" + e.getLocalizedMessage());
                        mView.onLikeMusicFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.d(TAG, "onComplete ");
                    }
                });
    }

    @Override
    public void getLikeList(long uid) {
        mModel.getLikeList(uid).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserLikeData>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        LogUtil.d(TAG, "onSubscribe");
                    }

                    @Override
                    public void onNext(UserLikeData bean) {
                        LogUtil.d(TAG, "onNext :" + bean);
                        mView.onGetLikeListSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e(TAG, "onError : " + e);
                        mView.onGetLikeListFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.d(TAG, "onComplete");
                    }
                });
    }

    @Override
    public void getMusicComment(long id) {
        mModel.getMusicComment(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MusicCommentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        LogUtil.d(TAG, "onSubscribe");
                    }

                    @Override
                    public void onNext(MusicCommentBean bean) {
                        LogUtil.d(TAG, "onNext : " + bean);
                        mView.onGetMusicCommentSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e(TAG, "onError : " + e.getLocalizedMessage());
                        mView.onGetMusicCommentFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.d(TAG, "onComplete");
                    }
                });
    }

    @Override
    public void likeComment(long id, long cid, int t, int type) {
        mModel.likeComment(id, cid, t, type).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentLikeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        LogUtil.d(TAG, "onSubscribe");
                    }

                    @Override
                    public void onNext(CommentLikeBean bean) {
                        LogUtil.d(TAG, "onNext :" + bean);
                        mView.onLikeCommentSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.d(TAG, "onError :" + e.getLocalizedMessage());
                        mView.onLikeCommentFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.d(TAG, "onComplete");
                    }
                });
    }

    @Override
    public void getLyric(long id) {
        mModel.getLyric(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LyricBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        LogUtil.d(TAG, "getLyric onSubscribe");
                    }

                    @Override
                    public void onNext(LyricBean bean) {
                        LogUtil.d(TAG, "getLyric onNext" + bean);
                        mView.onGetLyricSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e(TAG, "getLyric onError" + e.getLocalizedMessage());
                        mView.onGetLyricFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.d(TAG, "getLyric onComplete");
                    }
                });
    }

    @Override
    public void getPlaylistComment(long id) {
        mModel.getPlaylistComment(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PlayListCommentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        LogUtil.d(TAG, "getPlaylistComment onSubscribe ");
                    }

                    @Override
                    public void onNext(PlayListCommentBean bean) {
                        LogUtil.d(TAG, "getPlaylistComment onNext:" + bean);
                        mView.onGetPlaylistCommentSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e(TAG, "getPlaylistComment onError: " + e.getLocalizedMessage());
                        mView.onGetPlaylistCommentFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.d(TAG, "getPlaylistComment onComplete ");
                    }
                });
    }
}
