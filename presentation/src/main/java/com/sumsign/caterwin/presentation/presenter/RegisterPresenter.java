package com.sumsign.caterwin.presentation.presenter;

import com.sumsign.caterwin.domain.entity.UserEntity;
import com.sumsign.caterwin.domain.entity.request.UserLoginModel;
import com.sumsign.caterwin.domain.entity.response.UserResponse;
import com.sumsign.caterwin.domain.interactor.user.CreateUserUseCase;
import com.sumsign.caterwin.presentation.dependency.ActivityScope;
import com.sumsign.caterwin.presentation.view.BaseView;
import com.sumsign.caterwin.presentation.view.RegisterView;

import javax.inject.Inject;

@ActivityScope
public class RegisterPresenter extends BasePresenter implements Presenter {

    private CreateUserUseCase createUserUseCase;
    RegisterView registerView;

    @Inject
    public RegisterPresenter(CreateUserUseCase createUserUseCase) {
        super(createUserUseCase);
        this.createUserUseCase = createUserUseCase;
    }

    @Override
    public void initWithView(BaseView view) {
        super.initWithView(view);
        this.registerView = (RegisterView) view;
    }

    @Override
    public void destroy() {
        super.destroy();
        this.registerView = null;
    }

    public void registerUser(String email, String password, String passwordConfirmation) {
        UserLoginModel user = new UserLoginModel(email,password);
        user.setPassword(password);


        this.showLoader();
        this.createUserUseCase.setParams(user);
        this.createUserUseCase.execute(new RegisterSubscriber());
    }

    protected class RegisterSubscriber extends BaseSubscriber<UserResponse> {

        @Override
        public void onNext(UserResponse user) {
            RegisterPresenter.this.hideLoader();
            RegisterPresenter.this.registerView.viewNotes();
        }

    }

}
