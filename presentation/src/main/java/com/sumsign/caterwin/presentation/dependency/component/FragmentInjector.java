package com.sumsign.caterwin.presentation.dependency.component;

import com.sumsign.caterwin.presentation.view.fragment.LoginFragment;
import com.sumsign.caterwin.presentation.view.fragment.RegisterFragment;
import com.sumsign.caterwin.presentation.view.fragment.ResetPasswordFragment;
import com.sumsign.caterwin.presentation.view.fragment.SettingsFragment;

public interface FragmentInjector {

    void inject(LoginFragment loginFragment);
    void inject(RegisterFragment registerFragment);
    void inject(SettingsFragment settingsFragment);
    void inject(ResetPasswordFragment resetPasswordFragment);

}
