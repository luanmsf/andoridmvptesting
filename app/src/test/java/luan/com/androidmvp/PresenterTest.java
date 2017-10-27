package luan.com.androidmvp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;

import luan.com.androidmvp.model.entity.Photo;
import luan.com.androidmvp.presenter.PhotoPresenter;
import rx.Observable;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by ntluan on 10/8/17.
 */

public class PresenterTest {

    luan.com.androidmvp.base.Photo.Presenter mPhotoPresenter;
    luan.com.androidmvp.base.Photo.Model mMockPhotoModel;
    luan.com.androidmvp.base.Photo.View mMockPhotoView;

    @Before
    public void setup() {
        //mock object
        mMockPhotoModel = Mockito.mock(luan.com.androidmvp.base.Photo.Model.class);
        mMockPhotoView = Mockito.mock(luan.com.androidmvp.base.Photo.View.class);

        mPhotoPresenter = new PhotoPresenter(mMockPhotoModel);
        mPhotoPresenter.takeView(mMockPhotoView);

    }

    @Test
    public void test_requestToModelToGetData() {
        Mockito.when(mMockPhotoModel.getDataFromServer(anyString())).thenReturn(Observable.just(new ArrayList<Photo>()));
        mPhotoPresenter.requestToGetData(anyString());

        verify(mMockPhotoModel).getDataFromServer(anyString());
        verify(mMockPhotoView).updateDataToView(new ArrayList<Photo>());
    }

    @Test
    public void test_showError() {
        Mockito.when(mMockPhotoModel.getDataFromServer(anyString())).thenReturn(Observable.error(new Exception()));
        mPhotoPresenter.requestToGetData(anyString());

        verify(mMockPhotoView).showError();
    }

    @Test
    public void test_Real() {
        Mockito.when(mMockPhotoModel.getDataFromServer(anyString())).thenReturn(Observable.just(new ArrayList<Photo>()));

        mPhotoPresenter.requestToGetData(anyString());
        verify(mPhotoPresenter).requestToGetData("");
    }
}
