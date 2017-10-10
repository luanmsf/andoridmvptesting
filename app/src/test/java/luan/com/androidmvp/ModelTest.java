package luan.com.androidmvp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import luan.com.androidmvp.base.Photo;
import rx.Observable;
import rx.observers.TestSubscriber;

import static org.mockito.ArgumentMatchers.anyString;

/**
 * Created by ntluan on 10/09/17.
 */

public class ModelTest {
    luan.com.androidmvp.base.Photo.Model mMockPhotoModel;

    @Before
    public void setup() {
        mMockPhotoModel = Mockito.mock(luan.com.androidmvp.base.Photo.Model.class);
        Mockito.when(mMockPhotoModel.getDataFromServer(anyString())).thenReturn(Observable.just(new ArrayList<Photo>()));
    }

    @Test
    public void test_getDataFromServer() {
        TestSubscriber<luan.com.androidmvp.model.entity.Photo> testSubscriber = TestSubscriber.create();
        mMockPhotoModel.getDataFromServer(anyString()).subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();
    }
}
