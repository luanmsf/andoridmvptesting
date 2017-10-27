package luan.com.androidmvp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import luan.com.androidmvp.base.Photo;
import luan.com.androidmvp.custom.ConsiderCondition;
import luan.com.androidmvp.model.PhotoModel;
import luan.com.androidmvp.presenter.PhotoPresenter;
import luan.com.androidmvp.retrofit.RetrofitService;
import luan.com.androidmvp.view.PhotoActivity;
import rx.Observable;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ntluan on 10/19/17.
 */

@RunWith(AndroidJUnit4.class)
public class PresenterAtView extends ConsiderCondition {
    @Rule
    public ActivityTestRule<PhotoActivity> mActivity =
            new ActivityTestRule<PhotoActivity>(PhotoActivity.class);

    @Test
    public void testTakeView() {
        RetrofitService retrofitServiceMock = mock(RetrofitService.class);
        PhotoModel photoModelMock = new PhotoModel(retrofitServiceMock);
        PhotoPresenter photoPresenterMock = new PhotoPresenter(photoModelMock);

        assertNull(photoPresenterMock.getView());

        photoPresenterMock.takeView(mock(Photo.View.class));
        assertNotNull(photoPresenterMock.getView());
    }

    @Test
    public void testRequestData() {
        RetrofitService retrofitServiceMock = mock(RetrofitService.class);
        PhotoModel photoModelMock = new PhotoModel(retrofitServiceMock);
        PhotoPresenter photoPresenterMock = new PhotoPresenter(photoModelMock);
        Photo.View viewMock = mock(Photo.View.class);

        photoPresenterMock.takeView(viewMock);

        when(retrofitServiceMock.getPhoto(anyString())).
                thenReturn(Observable.<List<luan.com.androidmvp.model.entity.Photo>>error(new IOException()));
        photoPresenterMock.requestToGetData(anyString());
        waitFor(200);
        verify(viewMock, atLeastOnce()).showError();
    }
}
