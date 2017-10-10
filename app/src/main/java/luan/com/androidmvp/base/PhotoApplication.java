package luan.com.androidmvp.base;

import android.app.Application;

import luan.com.androidmvp.dagger.component.DaggerRetrofitComponent;
import luan.com.androidmvp.dagger.component.RetrofitComponent;
import luan.com.androidmvp.dagger.module.PhotoModule;
import luan.com.androidmvp.dagger.module.RetrofitModule;

public class PhotoApplication extends Application {

    private RetrofitComponent mRetrofitComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mRetrofitComponent = DaggerRetrofitComponent
                .builder()
                .retrofitModule(new RetrofitModule()).build();
    }

    public PhotoModule getPhotoModule(Photo.View view) {
        return new PhotoModule(view);
    }

    public RetrofitComponent getRetrofitComponent() {
        return mRetrofitComponent;
    }
}
