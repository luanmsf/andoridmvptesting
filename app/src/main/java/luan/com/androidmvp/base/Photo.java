package luan.com.androidmvp.base;


import java.util.List;

import rx.Observable;

/*
* For each module, we declare the separated module to easy control
* Ex : Photo module has sub mvp to control things of photo module.
*/
public interface Photo {

    interface Model extends Mvp.Model<Photo.Presenter> {
        Observable getDataFromServer(String token);
    }

    interface View extends Mvp.View {
        void updateDataToView(List<?> data);
    }

    interface Presenter extends Mvp.Presenter<Photo.View, Photo.Model> {
        void requestToGetData(String token);

//        void getDataFromModel(List<?> data);
    }
}
