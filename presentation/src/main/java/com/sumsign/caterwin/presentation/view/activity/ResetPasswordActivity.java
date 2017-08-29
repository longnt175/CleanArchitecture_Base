package com.sumsign.caterwin.presentation.view.activity;

import android.os.Bundle;

import com.sumsign.caterwin.presentation.R;
import com.sumsign.caterwin.presentation.view.activity.base.CleanActivity;
import com.sumsign.caterwin.presentation.view.fragment.ResetPasswordFragment;

public class ResetPasswordActivity extends CleanActivity {

    @Override
    protected void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, new ResetPasswordFragment());
        }
    }

    @Override
    protected boolean useToolbar() {
        return false;
    }

}
