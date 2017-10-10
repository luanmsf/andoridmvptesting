package luan.com.androidmvp;

import luan.com.androidmvp.base.Photo;
import luan.com.androidmvp.base.PhotoApplication;
import luan.com.androidmvp.dagger.module.PhotoModule;

/**
 * Created by ntluan on 10/9/17.
 */

public class TestApplication extends PhotoApplication {

    private PhotoModule mPhotoModule;

    public PhotoModule getPhotoModule(Photo.View view) {
        if (mPhotoModule == null) {
            return super.getPhotoModule(view);
        }

        return mPhotoModule;
    }

    public void setPhotoModule(PhotoModule photoModule) {
        mPhotoModule = photoModule;
    }
}
