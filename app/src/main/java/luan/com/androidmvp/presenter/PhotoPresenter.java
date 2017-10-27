package luan.com.androidmvp.presenter;

import android.util.Log;

import java.util.List;

import luan.com.androidmvp.base.Photo;
import luan.com.androidmvp.model.PhotoModel;
import rx.functions.Action1;

public class PhotoPresenter implements Photo.Presenter {

    private Photo.Model mPhotoModel;
    private Photo.View mView;

    public PhotoPresenter(Photo.Model photoModel) {
        mPhotoModel = photoModel;
//        mPhotoModel.takePresenter(this);
    }

    @Override
    public void requestToGetData(String url) {
        mView.showLoading(true);

        mPhotoModel.getDataFromServer(url).
                subscribe(new Action1<List<luan.com.androidmvp.model.entity.Photo>>() {
                              @Override
                              public void call(List<luan.com.androidmvp.model.entity.Photo> photos) {
                                  mView.updateDataToView(photos);
                                  mView.showLoading(false);
                              }
                          },
                        new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                throwable.printStackTrace();
                                mView.showLoading(false);
                                mView.showError();
                            }
                        });
        ;

    }

    @Override
    public void takeView(Photo.View view) {
        mView = view;
    }

    @Override
    public void removeView() {
        mView = null;
    }

    //for testing
    public Photo.View getView() {
        return mView;
    }
}
