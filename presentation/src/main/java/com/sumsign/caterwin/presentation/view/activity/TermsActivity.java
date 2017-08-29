package com.sumsign.caterwin.presentation.view.activity;

import com.sumsign.caterwin.data.net.RestApi;
import com.sumsign.caterwin.presentation.view.activity.base.WebViewActivity;

public class TermsActivity extends WebViewActivity {

    private static final String TERMS_URL = RestApi.URL_BASE + "/terms";

    @Override
    public String getUrl() {
        return TERMS_URL;
    }

}
