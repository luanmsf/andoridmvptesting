package luan.com.androidmvp;

import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import luan.com.androidmvp.custom.Condition;
import luan.com.androidmvp.custom.ConsiderCondition;
import luan.com.androidmvp.view.PhotoActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;
import static org.hamcrest.Matchers.not;

/**
 * Created by ntluan on 10/09/17.
 */

public class ViewTest extends ConsiderCondition {
    @Rule
    public ActivityTestRule<PhotoActivity> mActivity =
            new ActivityTestRule<PhotoActivity>(PhotoActivity.class);

    @Before
    public void setup() {
    }

    @Test
    public void testRecycleView() {
        final RecyclerView recyclerView = (RecyclerView) mActivity.getActivity().findViewById(R.id.recylerview_photo);
        waitForCondition(new Condition() {
            @Override
            public boolean isSatisfied() {
                return recyclerView != null && recyclerView.getAdapter()!= null;
            }
        }, 3000);

        assertNotNull(recyclerView);
        assertNotNull(recyclerView.getAdapter());
        assertNotSame(0, recyclerView.getAdapter().getItemCount());
    }

    @Test
    public void testProgressBar() {
        onView(withId(R.id.recylerview_photo)).check(matches(isDisplayed()));
        waitFor(200);
        onView(withId(R.id.progress_bar)).check(matches(not(isDisplayed())));
    }
}
