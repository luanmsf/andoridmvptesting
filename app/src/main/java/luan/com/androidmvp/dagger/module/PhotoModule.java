package luan.com.androidmvp.dagger.module;

import dagger.Module;
import dagger.Provides;
import luan.com.androidmvp.base.Photo;
import luan.com.androidmvp.model.PhotoModel;
import luan.com.androidmvp.presenter.PhotoPresenter;
import luan.com.androidmvp.retrofit.RetrofitService;

@Module
public class PhotoModule {

    private Photo.View mPhotoView;

    public PhotoModule(Photo.View photoView) {
        mPhotoView = photoView;
    }

    @Provides
    public Photo.View provideView() {
        return mPhotoView;
    }

    @Provides
    public Photo.Model provideMainModel(RetrofitService retrofitService) {
        return new PhotoModel(retrofitService);
    }

    @Provides
    public Photo.Presenter provideMainPresenter(Photo.Model mainModel) {
        return new PhotoPresenter(mainModel);
    }
}
