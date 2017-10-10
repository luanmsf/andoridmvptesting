package luan.com.androidmvp.model;

import android.util.Log;

import java.util.List;

import luan.com.androidmvp.base.Photo;
import luan.com.androidmvp.presenter.PhotoPresenter;
import luan.com.androidmvp.retrofit.RetrofitService;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class PhotoModel implements Photo.Model {

    private final String TAG = PhotoModel.class.getSimpleName();
    private PhotoPresenter mMainPresenter;
    private RetrofitService mRetrofitService;

    public PhotoModel(RetrofitService retrofitService) {
        mRetrofitService = retrofitService;
    }

    @Override
    public Observable<List<luan.com.androidmvp.model.entity.Photo>> getDataFromServer(String token) {
        return mRetrofitService.getPhoto(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    /*@Override
    public void takePresenter(Photo.Presenter presenter) {
        mMainPresenter = (PhotoPresenter) presenter;
    }*/
}
