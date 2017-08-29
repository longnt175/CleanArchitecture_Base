package com.sumsign.caterwin.presentation.presenter;

import com.sumsign.caterwin.domain.interactor.user.DoLogoutUseCase;
import com.sumsign.caterwin.presentation.dependency.ActivityScope;
import com.sumsign.caterwin.presentation.view.BaseView;
import com.sumsign.caterwin.presentation.view.SettingsView;

import javax.inject.Inject;

@ActivityScope
public class SettingsPresenter extends BasePresenter implements Presenter {

    private DoLogoutUseCase doLogoutUseCase;
    SettingsView settingsView;

    @Inject
    public SettingsPresenter(DoLogoutUseCase doLogoutUseCase) {
        super(doLogoutUseCase);
        this.doLogoutUseCase = doLogoutUseCase;
    }

    @Override
    public void initWithView(BaseView view) {
        super.initWithView(view);
        this.settingsView = (SettingsView) view;
    }

    @Override
    public void destroy() {
        super.destroy();
        this.settingsView = null;
    }

    public void logoutUserButtonPressed() {
        this.doLogoutUseCase.execute(new BaseSubscriber<>());
        this.settingsView.closeAndDisplayLogin();
    }


}
