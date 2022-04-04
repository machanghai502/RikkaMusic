package com.rikkathewrold.rikkamusic.main.mvp.contract;

import com.rikkathewrold.rikkamusic.base.BaseModel;
import com.rikkathewrold.rikkamusic.base.BasePresenter;
import com.rikkathewrold.rikkamusic.base.BaseView;
import com.rikkathewrold.rikkamusic.main.bean.LikeListBean;
import com.rikkathewrold.rikkamusic.main.bean.LogoutBean;
import com.rikkathewrold.rikkamusic.main.bean.UserLikeData;

import io.reactivex.Observable;


public interface MainContract {
    interface View extends BaseView {
        void onLogoutSuccess();

        void onLogoutFail(String e);

        void onGetLikeListSuccess(UserLikeData bean);

        void onGetLikeListFail(String e);
    }

    interface Model extends BaseModel {
        Observable<LogoutBean> logout();

        Observable<UserLikeData> getLikeList(long uid);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void logout();

        public abstract void getLikeList(long uid);
    }
}
