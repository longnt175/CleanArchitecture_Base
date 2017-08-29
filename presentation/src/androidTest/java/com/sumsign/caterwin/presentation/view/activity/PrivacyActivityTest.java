package com.sumsign.caterwin.presentation.view.activity;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.Toolbar;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.TextView;

import com.sumsign.caterwin.data.net.RestApi;
import com.sumsign.caterwin.presentation.R;
import com.sumsign.caterwin.presentation.view.fragment.WebViewFragment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.web.assertion.WebViewAssertions.webMatches;
import static android.support.test.espresso.web.model.Atoms.getCurrentUrl;
import static android.support.test.espresso.web.sugar.Web.onWebView;
import static java.lang.Thread.sleep;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class PrivacyActivityTest {

    @Rule
    public final ActivityTestRule<PrivacyActivity> activityTestRule =
            new ActivityTestRule<>(PrivacyActivity.class, false, true);
    private WebViewFragment webViewFragment;

    @Before
    public void setUp() throws Exception {
        this.webViewFragment = ((WebViewFragment) this.activityTestRule.getActivity()
                                .getFragmentManager().findFragmentById(R.id.fragment_container));
    }

    @Test
    public void testViewElements() throws InterruptedException {
        onView(allOf(isAssignableFrom(TextView.class),withParent(isAssignableFrom(Toolbar.class))))
                .check(matches(withText(R.string.title_activity_privacy)));
        onView(withId(R.id.webview)).check(matches(isDisplayed()));
    }

    @Test
    public void testUrl() {
        assertEquals(RestApi.URL_BASE + "/privacy", this.activityTestRule.getActivity().getUrl());
    }

}
