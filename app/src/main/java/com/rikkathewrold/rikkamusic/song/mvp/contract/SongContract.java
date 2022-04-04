package com.rikkathewrold.rikkamusic.song.mvp.contract;

import com.rikkathewrold.rikkamusic.base.BaseModel;
import com.rikkathewrold.rikkamusic.base.BasePresenter;
import com.rikkathewrold.rikkamusic.base.BaseView;
import com.rikkathewrold.rikkamusic.main.bean.LikeListBean;
import com.rikkathewrold.rikkamusic.main.bean.Song;
import com.rikkathewrold.rikkamusic.main.bean.UserLikeData;
import com.rikkathewrold.rikkamusic.song.bean.CommentLikeBean;
import com.rikkathewrold.rikkamusic.song.bean.LikeMusicBean;
import com.rikkathewrold.rikkamusic.song.bean.LyricBean;
import com.rikkathewrold.rikkamusic.song.bean.MusicCommentBean;
import com.rikkathewrold.rikkamusic.song.bean.PlayListCommentBean;
import com.rikkathewrold.rikkamusic.song.bean.SongDetailBean;

import io.reactivex.Observable;

public interface SongContract {
    interface View extends BaseView {
        void onGetSongDetailSuccess(Song bean);

        void onGetSongDetailFail(String e);

        void onLikeOrUnLikeMusicSuccess(Boolean bean, String songId);

        void onLikeMusicFail(String e);

        void onGetLikeListSuccess(UserLikeData bean);

        void onGetLikeListFail(String e);

        void onGetMusicCommentSuccess(MusicCommentBean bean);

        void onGetMusicCommentFail(String e);

        void onLikeCommentSuccess(CommentLikeBean bean);

        void onLikeCommentFail(String e);

        void onGetLyricSuccess(LyricBean bean);

        void onGetLyricFail(String e);

        void onGetPlaylistCommentSuccess(PlayListCommentBean bean);

        void onGetPlaylistCommentFail(String e);
    }

    interface Model extends BaseModel {
        Observable<Song> getSongDetail(long songId);

        Observable<Boolean> likeOrUnLikeMusic(long songId, long uid);

        Observable<UserLikeData> getLikeList(long uid);

        Observable<MusicCommentBean> getMusicComment(long id);

        Observable<CommentLikeBean> likeComment(long id, long cid, int t, int type);

        Observable<LyricBean> getLyric(long id);

        Observable<PlayListCommentBean> getPlaylistComment(long id);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getSongDetail(long ids);

        public abstract void likeOrUnLikeMusic(long songId, long uid);

        public abstract void getLikeList(long uid);

        public abstract void getMusicComment(long id);

        public abstract void likeComment(long id, long cid, int t, int type);

        public abstract void getLyric(long id);

        public abstract void getPlaylistComment(long id);
    }
}
