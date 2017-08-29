package com.sumsign.caterwin.presentation.presenter;

import com.sumsign.caterwin.domain.entity.UserEntity;
import com.sumsign.caterwin.domain.entity.request.UserLoginModel;
import com.sumsign.caterwin.domain.entity.response.UserResponse;
import com.sumsign.caterwin.domain.interactor.user.DoLoginUseCase;
import com.sumsign.caterwin.presentation.dependency.ActivityScope;
import com.sumsign.caterwin.presentation.view.BaseView;
import com.sumsign.caterwin.presentation.view.LoginView;

import javax.inject.Inject;

@ActivityScope
public class LoginPresenter extends BasePresenter implements Presenter {

    private DoLoginUseCase doLoginUseCase;
    LoginView loginView;

    @Inject
    public LoginPresenter(DoLoginUseCase doLoginUseCase) {
        super(doLoginUseCase);
        this.doLoginUseCase = doLoginUseCase;
    }

    @Override
    public void initWithView(BaseView view) {
        super.initWithView(view);
        this.loginView = (LoginView) view;
    }

    @Override
    public void destroy() {
        super.destroy();
        this.loginView = null;
    }

    public void loginUser(String email, String password) {
        UserLoginModel user = new UserLoginModel(email,password);


        this.showLoader();
        this.doLoginUseCase.setParams(user);
        this.doLoginUseCase.execute(new LoginSubscriber());
    }

    protected class LoginSubscriber extends BaseSubscriber<UserResponse> {

        @Override
        public void onNext(UserResponse user) {
            LoginPresenter.this.hideLoader();
            LoginPresenter.this.loginView.viewNotes();
        }

    }

}
