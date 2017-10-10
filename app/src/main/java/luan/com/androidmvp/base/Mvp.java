package luan.com.androidmvp.base;

/*
* This is MVP-base class used for all module, all common functions are declared here
*/

public interface Mvp {

    /*
    * base Model layer
    */
    interface Model <P>{
//        void takePresenter(P presenter);
    }

    /*
    * base View layer
    */
    interface View {
        void showLoading(boolean isShow);

        void showError();
    }

    /*
    * base Presenter layer
    */
    interface Presenter<V, M> {
        void takeView(V view);

        void removeView();
    }
}
