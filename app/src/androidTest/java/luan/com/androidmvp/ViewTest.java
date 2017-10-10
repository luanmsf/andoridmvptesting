package luan.com.androidmvp;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import luan.com.androidmvp.base.Photo;
import luan.com.androidmvp.dagger.module.PhotoModule;
import luan.com.androidmvp.view.PhotoActivity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by ntluan on 10/09/17.
 */

public class ViewTest {

    Photo.Presenter mMockPhotoPresenter;
    PhotoModule mPhotoModule;

    @Rule
    public ActivityTestRule<PhotoActivity> mActivity =
            new ActivityTestRule<PhotoActivity>(PhotoActivity.class);

    @Before
    public void setup() {
        mPhotoModule = mock(PhotoModule.class);
        mMockPhotoPresenter = mock(Photo.Presenter.class);

        when(mPhotoModule.provideView()).thenReturn(mock(Photo.View.class));
        when(mPhotoModule.provideMainPresenter(any(Photo.Model.class))).thenReturn(mMockPhotoPresenter);

        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        TestApplication testApplication
                = (TestApplication) instrumentation.getTargetContext().getApplicationContext();

        testApplication.setPhotoModule(mPhotoModule);
    }

    @Test
    public void takeView_test() {
        mActivity.launchActivity(new Intent());
        onView(withId(R.id.btn_load)).perform(click());
        verify(mMockPhotoPresenter).requestToGetData(anyString());
    }
}
