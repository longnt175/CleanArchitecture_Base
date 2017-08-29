package com.sumsign.caterwin.presentation.presenter;

import com.sumsign.caterwin.domain.entity.MessageEntity;
import com.sumsign.caterwin.domain.entity.UserEntity;
import com.sumsign.caterwin.domain.entity.request.UserLoginModel;
import com.sumsign.caterwin.domain.interactor.user.ResetPasswordUseCase;
import com.sumsign.caterwin.presentation.dependency.ActivityScope;
import com.sumsign.caterwin.presentation.view.BaseView;
import com.sumsign.caterwin.presentation.view.ResetPasswordView;

import javax.inject.Inject;

@ActivityScope
public class ResetPasswordPresenter extends BasePresenter implements Presenter {

    private ResetPasswordUseCase resetPasswordUseCase;
    ResetPasswordView resetPasswordView;

    @Inject
    public ResetPasswordPresenter(ResetPasswordUseCase resetPasswordUseCase) {
        super(resetPasswordUseCase);
        this.resetPasswordUseCase = resetPasswordUseCase;
    }

    @Override
    public void initWithView(BaseView view) {
        super.initWithView(view);
        this.resetPasswordView = (ResetPasswordView) view;
    }

    @Override
    public void destroy() {
        super.destroy();
        this.resetPasswordView = null;
    }

    public void resetPassword(String email, String newPassword, String newPasswordConfirmation) {
        UserLoginModel user = new UserLoginModel(email,newPassword);


        this.showLoader();
        this.resetPasswordUseCase.setParams(user);
        this.resetPasswordUseCase.execute(new ResetPasswordSubscriber());
    }

    protected class ResetPasswordSubscriber extends BaseSubscriber<MessageEntity> {

        @Override
        public void onNext(MessageEntity message) {
            ResetPasswordPresenter.this.hideLoader();
            ResetPasswordPresenter.this.resetPasswordView.showMessage(message.getMessage());
            ResetPasswordPresenter.this.resetPasswordView.close();
        }

    }

}
